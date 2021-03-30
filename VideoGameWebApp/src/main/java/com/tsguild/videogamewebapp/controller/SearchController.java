/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp.controller;

import com.tsguild.videogamewebapp.dao.VideoGameDao;
import com.tsguild.videogamewebapp.dto.VideoGame;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class SearchController {

    private VideoGameDao dao;

    @Inject
    public SearchController(VideoGameDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }

    @RequestMapping(value = "search/addresses", method = RequestMethod.POST)
    @ResponseBody
    public List<VideoGame> searchVideoGames(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        List<VideoGame> addresses = dao.getAllVideoGames();

        String title = searchMap.get("title");
        String publisher = searchMap.get("publisher");
        String genre = searchMap.get("genre");
        String multiplayer = searchMap.get("multiplayer");
        String rating = searchMap.get("rating");
        

        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        if (!title.isEmpty()) {
            addresses = (List<VideoGame>) addresses.stream().filter((VideoGame a) -> {
                String addressFirstName = a.getTitle().toLowerCase();
                String addressSearch = searchMap.get("title");
                return addressFirstName.contains(addressSearch);
            }).collect(Collectors.toList());
        }

        if (!publisher.isEmpty()) {
            addresses = addresses.stream().filter(a -> a.getPublisher()
                    .contains(publisher.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (!genre.isEmpty()) {
            addresses = addresses.stream().filter(a -> a.getGenre()
                    .contains(genre.toLowerCase()))
                    .collect(Collectors.toList());
        }


        if (!rating.isEmpty()) {
            addresses = addresses.stream().filter(a -> a.getEsrbRating()
                    .contains(rating.toLowerCase()))
                    .collect(Collectors.toList());
        }

       

        return addresses;
    }
}
