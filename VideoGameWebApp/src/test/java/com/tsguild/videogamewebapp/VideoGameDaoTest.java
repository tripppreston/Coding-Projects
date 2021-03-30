/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp;

import com.tsguild.videogamewebapp.dao.VideoGameDao;
import com.tsguild.videogamewebapp.dto.VideoGame;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class VideoGameDaoTest {

//    private VideoGameDao dao;
//
//    public VideoGameDaoTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        ApplicationContext ctx
//                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        dao = ctx.getBean("jdbcDao", VideoGameDao.class);
//        JdbcTemplate cleaner = ctx.getBean("jdbcTemplateBean", JdbcTemplate.class);
//        cleaner.execute("DELETE FROM Games");
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void addGetDeleteVideoGame() {
//
//        VideoGame game = new VideoGame();
//        game.setTitle("Skyrim");
//        game.setPublisher("Bethesda");
//        game.setGenre("RPG");
//        game.setIsMultiplayer(false);
//        game.setEsrbRating("M");
//
//        dao.addVideoGame(game);
//        VideoGame fromDb = dao.getVideoGameById(game.getId());
//
//        assertEquals(fromDb.getId(), game.getId());
//        assertEquals(fromDb.getTitle(), game.getTitle());
//        assertEquals(fromDb.getPublisher(), game.getPublisher());
//        assertEquals(fromDb.getGenre(), game.getGenre());
//        assertEquals(fromDb.isIsMultiplayer(), game.isIsMultiplayer());
//        assertEquals(fromDb.getEsrbRating(), game.getEsrbRating());
//
//        dao.removeVideoGame(game.getId());
//
//        assertNull(dao.getVideoGameById(game.getId()));
//
//    }
//
//    @Test
//    public void addUpdateGame() {
//        VideoGame game = new VideoGame();
//        game.setTitle("Skyrim");
//        game.setPublisher("Bethesda");
//        game.setGenre("RPG");
//        game.setIsMultiplayer(false);
//        game.setEsrbRating("M");
//
//        dao.addVideoGame(game);
//
//        game.setTitle("Fallout 3");
//        dao.updateVideoGame(game);
//
//        VideoGame fromDb = dao.getVideoGameById(game.getId());
//
//        assertEquals(fromDb.getId(), game.getId());
//        assertEquals(fromDb.getTitle(), game.getTitle());
//        assertEquals(fromDb.getPublisher(), game.getPublisher());
//        assertEquals(fromDb.getGenre(), game.getGenre());
//        assertEquals(fromDb.isIsMultiplayer(), game.isIsMultiplayer());
//        assertEquals(fromDb.getEsrbRating(), game.getEsrbRating());
//    }
//
//    @Test
//    public void getAllGames() {
//        VideoGame game = new VideoGame();
//        game.setTitle("Skyrim");
//        game.setPublisher("Bethesda");
//        game.setGenre("RPG");
//        game.setIsMultiplayer(false);
//        game.setEsrbRating("M");
//
//        dao.addVideoGame(game);
//
//        VideoGame game2 = new VideoGame();
//        game2.setTitle("Overwatch");
//        game2.setPublisher("Blizzard");
//        game2.setGenre("FPS");
//        game2.setIsMultiplayer(true);
//        game2.setEsrbRating("T");
//
//        dao.addVideoGame(game2);
//
//        List<VideoGame> gArr = dao.getAllVideoGames();
//        assertEquals(gArr.size(), 2);
//    }
}
