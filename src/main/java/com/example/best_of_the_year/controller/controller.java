package com.example.best_of_the_year.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.best_of_the_year.java.*;

@Controller
@RequestMapping("/")
public class controller {

    protected ArrayList<Movies> moviesList = new ArrayList<>();
    protected ArrayList<Songs> songsList = new ArrayList<>();
    protected String titolo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Paolo Fabris");
        return "index";
    }

    @GetMapping("/Movies")
    public String Movies(Model model) {
        if (moviesList.size() <= 0) {
            moviesList.add(new Movies(1, "Inception"));
            moviesList.add(new Movies(2, "TheDarkKnight"));
            moviesList.add(new Movies(3, "Interstellar"));
            moviesList.add(new Movies(4, "TheGodfather"));
            moviesList.add(new Movies(5, "PulpFiction"));
        }
        model.addAttribute("films", getBestMovies());
        return "movies";
    }

    @GetMapping("/Songs")
    public String Songs(Model model) {
        if (songsList.size() <= 0) {
            songsList.add(new Songs(1, "BohemianRhapsody"));
            songsList.add(new Songs(2, "StairwaytoHeaven"));
            songsList.add(new Songs(3, "HotelCalifornia"));
            songsList.add(new Songs(4, "Imagine"));
            songsList.add(new Songs(5, "SmellsLikeTeenSpirit"));
        }
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    @GetMapping("/Movies/{id}")
    public String MoviesId(@PathVariable String id, Model model) {
        model.addAttribute(id);
        model.addAttribute("films", getBestMovies());
        return "moviesId";
    }

    @GetMapping("/Songs/{id}")
    public String SongsId(@PathVariable String id, Model model) {
        model.addAttribute(id);
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
