/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp.dto;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class VideoGame {

    private int id;
    
    @NotEmpty(message = "A videogame must have a title")
    @Length(min = 2, max = 50, message = "Videogame title must be between 2 and 50 characters in length")
    private String title;
    @NotEmpty(message = "A videogame must have a publisher")
    @Length(min = 2, max = 50, message = "Videogame publisher must be between 2 and 50 characters in length")
    private String publisher;
    @NotEmpty(message = "A videogame must have a genre")
    @Length(min = 2, max = 50, message = "Videogame genre must be between 2 and 50 characters in length")
    private String genre;
   
    private boolean isMultiplayer;
   
    private String esrbRating;

    public VideoGame() {
    }

    public VideoGame(int id, String title, String publisher, String genre, boolean isMultiplayer, String esrbRating) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.isMultiplayer = isMultiplayer;
        this.esrbRating = esrbRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isIsMultiplayer() {
        return isMultiplayer;
    }

    public void setIsMultiplayer(boolean isMultiplayer) {
        this.isMultiplayer = isMultiplayer;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.publisher);
        hash = 97 * hash + Objects.hashCode(this.genre);
        hash = 97 * hash + (this.isMultiplayer ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.esrbRating);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VideoGame other = (VideoGame) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.isMultiplayer != other.isMultiplayer) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.esrbRating, other.esrbRating)) {
            return false;
        }
        return true;
    }

}
