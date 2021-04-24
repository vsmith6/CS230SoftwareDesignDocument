/*
 * Valerie J. Smith
 * Gaming Room Authentication Example
 * March 20, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Mod 4 Assignment 1
 * Dr.Lyon
 * 
 * 
 * */


package com.gamingroom.gameauth;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;

 
import javax.ws.rs.client.Client;
 
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.controller.RESTClientController;
import com.gamingroom.gameauth.healthcheck.AppHealthCheck;
import com.gamingroom.gameauth.healthcheck.HealthCheckController;
import com.gamingroom.gameauth.authentication.GameAuthorizer;
import com.gamingroom.gameauth.authentication.GameAuthenticator;
import com.gamingroom.gameauth.authentication.GameUser;


public class GameAuthApplication extends Application<Configuration> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);
    
    /**
     * the initialization of the app by bootstrapping the GameAuthConfiguration
     * @author Valerie Smith
     * March 26, 2021
     */

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
    	
    }

    @Override
    public void run(final Configuration configuration,
                    final Environment environment) {
    	LOGGER.info("Registering REST resources");
    	
        /**
         * the environment is passed an instance of the GameUserRESTController in order to 
         * register the Game REST Controller
         * 
         * @author Valerie Smith
         * @param GameUserRESTController
         * March 26 2021
    	*/ 
    	environment.jersey().register(new GameUserRESTController(environment.getValidator()));
    	
    	/**
    	 * Build the Rest Client by telling Jersey what rest client to build and
    	 * register this environment with the jersey environment
    	 * @author Valerie J. Smith
    	 * March 26, 2021
    	 * 
    	 */
    
    	
        final Client client = new JerseyClientBuilder(environment).build("DemoRESTClient");
        environment.jersey().register(new RESTClientController(client));

        environment.healthChecks().register("APIHealthCheck", new AppHealthCheck(client));
 
        environment.jersey().register(new HealthCheckController(environment.healthChecks()));
 
        //****** Dropwizard security - custom classes ***********/
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<GameUser>()
                                .setAuthenticator(new GameAuthenticator())
                                .setAuthorizer(new GameAuthorizer())
                                .setRealm("APP-SECURITY")
                                .buildAuthFilter()));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
    
    }
    public static void main(final String[] args) throws Exception {
        new GameAuthApplication().run(args);
    }


}
