/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp.dao;

import com.tsguild.videogamewebapp.dto.SearchTerm;
import com.tsguild.videogamewebapp.dto.VideoGame;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class VideoGameDaoImpl implements VideoGameDao {

    private Map<Integer, VideoGame> videoGameMap = new HashMap<>();
    private static int counter = 0;

    @Override
    public VideoGame addVideoGame(VideoGame videoGame) {
        videoGame.setId(counter);
        videoGameMap.put(counter, videoGame);
        counter++;
        return videoGame;
    }

    @Override
    public VideoGame getVideoGameById(int id) {
        return videoGameMap.get(id);
    }

    @Override
    public List<VideoGame> getAllVideoGames() {
        return videoGameMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void updateVideoGame(VideoGame videoGame) {
        videoGameMap.put(videoGame.getId(), videoGame);
    }

    @Override
    public void removeVideoGame(int id) {
        videoGameMap.remove(id);
    }

    @Override
    public List<VideoGame> searchVideoGames(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VideoGame> searchVideoGames(Predicate<VideoGame> filter) {
        return videoGameMap.values().stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public List<VideoGame> searchGamesByPublisher(String publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VideoGame> searchGamesByGenre(String genre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
