/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp.dao;

import com.tsguild.videogamewebapp.dto.SearchTerm;
import com.tsguild.videogamewebapp.dto.VideoGame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class VideoGameDaoDbImpl implements VideoGameDao {

    private static final String SQL_INSERT_GAME
            = "INSERT INTO Games (title, publisher, genre, multiplayer, rating) " + "   VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_GAME
            = "DELETE FROM Games WHERE id = ?";
    private static final String SQL_SELECT_GAME_BY_ID
            = "SELECT * FROM Games WHERE id = ?";
    private static final String SQL_UPDATE_GAME
            = "UPDATE Games SET title = ?, publisher = ?, genre = ?, multiplayer = ?, rating = ? WHERE id = ?";
    private static final String SQL_SELECT_ALL_GAMES
            = "SELECT * FROM Games";
    private static final String SQL_SELECT_GAME_BY_PUBLISHER
            = "SELECT * FROM Games WHERE publisher = ?";
    private static final String SQL_SELECT_GAME_BY_GENRE
            = "SELECT * FROM Games WHERE genre = ?";
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public VideoGame addVideoGame(VideoGame videoGame) {
        jdbcTemplate.update(SQL_INSERT_GAME,
                videoGame.getTitle(),
                videoGame.getPublisher(),
                videoGame.getGenre(),
                videoGame.isIsMultiplayer(),
                videoGame.getEsrbRating());
        videoGame.setId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()",
                Integer.class));
        return videoGame;
    }

    @Override
    public VideoGame getVideoGameById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_GAME_BY_ID,
                    new GameMapper(), id);
        } catch (EmptyResultDataAccessException ex) {

            return null;
        }
    }

    @Override
    public List<VideoGame> getAllVideoGames() {
        return jdbcTemplate.query(SQL_SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public void updateVideoGame(VideoGame videoGame) {
        jdbcTemplate.update(SQL_UPDATE_GAME,
                videoGame.getTitle(),
                videoGame.getPublisher(),
                videoGame.getGenre(),
                videoGame.isIsMultiplayer(),
                videoGame.getEsrbRating(),
                videoGame.getId());
    }

    @Override
    public void removeVideoGame(int id) {
        jdbcTemplate.update(SQL_DELETE_GAME, id);
    }

    @Override
    public List<VideoGame> searchVideoGames(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VideoGame> searchVideoGames(Predicate<VideoGame> filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VideoGame> searchGamesByPublisher(String publisher) {
        return jdbcTemplate.query(SQL_SELECT_GAME_BY_PUBLISHER, new GameMapper());
    }

    @Override
    public List<VideoGame> searchGamesByGenre(String genre) {
        return jdbcTemplate.query(SQL_SELECT_GAME_BY_GENRE, new GameMapper());
    }

    private static final class GameMapper implements RowMapper<VideoGame> {

        @Override
        public VideoGame mapRow(ResultSet rs, int rowNum) throws SQLException {
           VideoGame videoGame = new VideoGame();
            videoGame.setId(rs.getInt("id"));
            videoGame.setTitle(rs.getString("title"));
            videoGame.setPublisher(rs.getString("publisher"));
            videoGame.setGenre(rs.getString("genre"));
            videoGame.setIsMultiplayer(rs.getBoolean("multiplayer"));
            videoGame.setEsrbRating(rs.getString("rating"));
            
      
            return videoGame;
        }
    }

}
