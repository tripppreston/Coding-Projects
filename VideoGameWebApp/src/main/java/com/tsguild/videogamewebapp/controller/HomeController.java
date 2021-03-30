package com.tsguild.videogamewebapp.controller;



import com.tsguild.videogamewebapp.dao.VideoGameDao;
import com.tsguild.videogamewebapp.dto.VideoGame;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    private VideoGameDao dao;

    @Inject
    public HomeController(VideoGameDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHome() {

        return "home";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public VideoGame createGame(@Valid @RequestBody VideoGame incomingVideoGame) {
        dao.addVideoGame(incomingVideoGame);
        return incomingVideoGame;
    }

    @ResponseBody
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public List<VideoGame> getAllGames() {
        return dao.getAllVideoGames();
    }

    @ResponseBody
    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public VideoGame getVideoGameById(@PathVariable("id") int gameId) {
        return dao.getVideoGameById(gameId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/game/{id}", method = RequestMethod.PUT)
    public void updateVideoGame(@PathVariable("id") int gameId, @RequestBody VideoGame updatedVideoGame) {
        updatedVideoGame.setId(gameId);
        dao.updateVideoGame(updatedVideoGame);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    public void removeVideoGame(@PathVariable("id") int gameId) {
        dao.removeVideoGame(gameId);

    }

}
