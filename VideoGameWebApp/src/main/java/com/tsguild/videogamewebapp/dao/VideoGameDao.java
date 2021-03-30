/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp.dao;

import com.tsguild.videogamewebapp.dto.SearchTerm;
import com.tsguild.videogamewebapp.dto.VideoGame;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author apprentice
 */
public interface VideoGameDao {
    
    public VideoGame addVideoGame(VideoGame videoGame);
    
    public VideoGame getVideoGameById(int id);
    
    public List<VideoGame> getAllVideoGames();
    
    public void updateVideoGame(VideoGame videoGame);
    
    public void removeVideoGame(int id);
    
    public List<VideoGame> searchGamesByPublisher(String publisher);
    public List<VideoGame> searchGamesByGenre(String genre);
    
    public List<VideoGame> searchVideoGames(Map<SearchTerm, String> criteria);
    public List<VideoGame> searchVideoGames(Predicate<VideoGame> filter);
    
}
