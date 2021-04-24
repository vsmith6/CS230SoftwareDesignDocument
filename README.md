# CS230SoftwareDesignDocument
Software Design Document and coding samples for SNHU CS 230 Course
*********************************
- Briefly summarize The Gaming Room client and their software requirements. Who was the client? What type of software did they want you to design?
```
     The client was a fictional company called The Gaming Room.  The ask is a web application version of their fictional game, “Draw It Or Lose It”. The fictional game is currently only available on an Android application, and the client wished to extend the game into a web application in order for the game to be accessed by multiple clients.
```
- What did you do particularly well in developing this documentation?
```
     There are two parts of the documentation that I feel that went well. The first being Part 1 of the assignment: the Executive Summary, the Design Constraints, and the Business Constraints. It seems that I was pretty accurate in listing what would be considered a constraint.  Since I have some experience with working with clients, it came naturally to me to list what was needed.  
     For the executive summary, I was able to reiterate the client’s ask and suggest a high-level solution, as well as provide a brief explanation with details. I felt that this was done very well considering the limited details provided from the fictional client in the assignment details. 
     The second part of the documentation that I feel was done very well was the Domain Model section, where I was able to accurately describe the UML diagram and provide details on the functionality between the class members of the code. From personal experience, I know that this is an important part of a design diagram and there is much attention to detail during this process of software development.
 ```    
- What about the process of working through a design document did you find helpful when developing the code?
```
     The Domain model section that covers the functionality and association between the Java classes that make up the game was extremely helpful and very rewarding to 
     learn from.  It was a really good learning experience to be able to work with the code as well as to detail the UML diagram in a visual manner.  Developing the classes and working with the code in an IDE such as Eclipse was a great way to get a feel for what the game would be doing. 
```
- If you could choose one part of your work on these documents to revise, what would you pick? How would you improve it?
```
     For the overall document, I feel that there should've been more detailed investigation and feedback from the client before trying to list out what the Design Constraints are and what the overall solution would be. 
     The overall length of the software design document is very wordy and if I would present this to a client I would bullet a lot of the documentation in order to 
     make the document more readable for the user, or break the document into more than one document.  I feel that the Evaluation table would be better represented if it had been given the details of the exact items that were needed, rather than an overall search to find the pro's and con's, which led to a lot more information shown than what is really needed. 
     From working with product owners in the client capacity, the Domain model is often elaborated on and discussed as a separate entity. The Domain model is also
     extended to show diagrams of the overall system connectivity in a more visual manner and the client usually is involved with several meetings with this documentation and review. 
```
- How did you interpret the user’s needs and implement them into your software design? Why is it so important to consider the user’s needs when designing?
 ```    
     It is very critical to incorporate the user's needs when designing for many reasons.  First of all, for this fictional client, there was a need for an application 
     that would be developer friendly as the client's developers did not have the skills necessary to create the application. Careful consideration was applied as it would be terrible to hand off an application to a client who does not have the resources to support it.  Secondly, the information given was
     very vague and lent for a lot of guesswork as to what the client really needed.  In order to prevent a lot of rework an misunderstanding, additional interviews and
     information from the client would have been necessary, especially to figure out in more detail the design constraints and the overall solution.  For this client, a broad overview of the existing game as well as any information that they may have documents for would have been really helpful.  A thorough analysis of the client's needs saves time and rework, and that saves both parties money as well as well as presents the client with a solution faster.  
```
- How did you approach designing software? What techniques or strategies would you use in the future to analyze and design a similar software application?
```     
    I am a software engineer, and can speak to the Agile approach of designing software as that is the approach that is used where I work.  The client is normally very
    involved in this approach and is often a project manager or business representative.  Regardless of the work environment, the needs of the user are highly
    analyized and prioritized, and many users are interviewed for their feedback at the inital project start up as well as throughout the development process.

    Strategies that I will use in the future are perphaps a pre-developed checklist of the benefits of each operating system and cloud platform in order to
    add more value to their end product and to help the client decide what is best for their situation. An additional strategy would be to ensure that I remain relevant in my skills and abilities in order to speak to the technology that a client is needing. 
```
************************************
Incorporting Feedback to Assignments
************************************
- Software Design Document Feedback
```
     The feedback that I received for the overall software design document has been incorporated into the final document.  
     Prior to Project 3 submission, I added an additional constraint for the development of user authentication as well as additional bullets that were suggested to the Evaluation sections, such as LDAP support options and browser compatibility.
     For the final feedback comments, I added additional Linux support benefits to the recommended operating platform section in the Software Design Document section for Recommendations.
```

- Game App Feedback
************************************
- Feedback from GameService.java.  I changed the lazy instantiation and also changed the iterator method to the one recommended from the feedback. 

- Lazy instantiation: 
```
	/*
	 * get the only object that is available of the Game Service Singleton class
	 */

	// adding feedback 'lazy' instantiation
	public static GameService getInstance() {
		if (service == null) {
			service = new GameService();
		}
		return service;
	}
```
- Iterator example:
```
	public Game addGame(String name) {
		Game game = null;
		Game tempGame = null;
	
		Iterator<Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {
			tempGame = gamesIterator.next();
			if (tempGame.getName().equalsIgnoreCase(name)) {
				return tempGame;
			}
		}
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);		
		
		}
		return game;
	}
```
- Game Authentication Feedback
***********************************
```
     For the game app Authentication assignment, I made a few small mistakes and have corrected the code based on feedback.

Authentication code error fixes from feedback:

In the GameAuthenticator.java class, I forgot to add the player with a role of “Player”.
```
- GameAuthenticator.java
```
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        /**
         * Add a player with the role of "Player"
         * @author vsmith6
         * April 2, 2021
         */
        "player",ImmutableSet.of("PLAYER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
```
    - In the GameRestController.java, I forgot to remove the curly braces in the RolesAllowed annotation and have corrected them in the code. This is one sample:
```
    @RolesAllowed("USER") // Authenticates USER and allows API access to users with USER role 
    @GET
    @Path("/{id}")
    public Response getGameUserById(@PathParam("id") Integer id,@Auth GameUser user) {
    	//You can validate here if user is watching his record
    	/*if(id != user.getId()){
    			//Not allowed
    	}*/
        GameUserInfo gameUser = GameUserDB.getGameUser(id);
        if (gameUser != null)
            return Response.ok(gameUser).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }
```
Valerie J. Smith
April 24, 2021