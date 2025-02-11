package com.example.best_of_the_year.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.best_of_the_year.java.*;

@Controller
@RequestMapping("/")
public class IndexController {
    private ArrayList<Movies> moviesList = new ArrayList<>();
    private ArrayList<Songs> songsList = new ArrayList<>();

    @Autowired
    public IndexController() {
        if (this.moviesList.size() == 0) {
            this.moviesList.add(new Movies(1, "Inception"));
            this.moviesList.add(new Movies(2, "TheDarkKnight"));
            this.moviesList.add(new Movies(3, "Interstellar"));
            this.moviesList.add(new Movies(4, "TheGodfather"));
            this.moviesList.add(new Movies(5, "PulpFiction"));
        }
        if (this.songsList.size() == 0) {
            this.songsList.add(new Songs(1, "BohemianRhapsody"));
            this.songsList.add(new Songs(2, "StairwaytoHeaven"));
            this.songsList.add(new Songs(3, "HotelCalifornia"));
            this.songsList.add(new Songs(4, "Imagine"));
            this.songsList.add(new Songs(5, "SmellsLikeTeenSpirit"));
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Paolo Fabris");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("films", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String moviesId(@PathVariable String id, Model model) {
        if (UtilFunctions.existMovies(moviesList, id)) {
            model.addAttribute("id", id);
        } else {
            model.addAttribute("id", "false");
        }
        model.addAttribute("films", getBestMovies());
        return "moviesId";
    }

    @GetMapping("/songs/{id}")
    public String songsId(@PathVariable String id, Model model) {
        if (UtilFunctions.existSongs(songsList, id)) {
            model.addAttribute("id", id);
        } else {
            model.addAttribute("id", "false");
        }
        model.addAttribute("songs", getBestSongs());
        return "songsId";
    }

    private ArrayList<Movies> getBestMovies() {

        return this.moviesList;
    }

    private ArrayList<Songs> getBestSongs() {

        return this.songsList;
    }

}
