
/*
 * Valerie J. Smith
 * Gaming Room Authentication Example
 * March 20, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Mod 4 Assignment 1
 * Dr.Lyon
 * 
 * 
 * */package com.gamingroom.gameauth.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gamingroom.gameauth.representations.GameUserInfo;

public class GameUserDB {
	public static HashMap<Integer, GameUserInfo> gameUserInfos = new HashMap<>();
    static{
        gameUserInfos.put(1, new GameUserInfo(1, "Lokesh", "Gupta", "India"));
        gameUserInfos.put(2, new GameUserInfo(2, "John", "Gruber", "USA"));
        gameUserInfos.put(3, new GameUserInfo(3, "Melcum", "Marshal", "AUS"));
    }
     
    public static List<GameUserInfo> getGameUsers(){
        return new ArrayList<GameUserInfo>(gameUserInfos.values());
    }
     
    public static GameUserInfo getGameUser(Integer id){
        return gameUserInfos.get(id);
    }
     
    public static void updateGameUser(Integer id, GameUserInfo gameUserInfo){
        gameUserInfos.put(id, gameUserInfo);
    }
     
    public static void removeGameUser(Integer id){
        gameUserInfos.remove(id);
    }

}
