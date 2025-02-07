package com.example.best_of_the_year.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.best_of_the_year.java.*;

@Controller
@RequestMapping("/")
public class controller {

    protected ArrayList<Movies> moviesList = new ArrayList<>();
    protected ArrayList<Songs> songsList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Paolo Fabris");
        return "index";
    }

    @GetMapping("/Movies")
    public String Movies(Model model) {
        moviesList.add(new Movies(1, "Inception"));
        moviesList.add(new Movies(2, "The Dark Knight"));
        moviesList.add(new Movies(3, "Interstellar"));
        moviesList.add(new Movies(4, "The Godfather"));
        moviesList.add(new Movies(5, "Pulp Fiction"));
        model.addAttribute("films", getBestMovies());
        return "movies";
    }

    @GetMapping("/Songs")
    public String Songs(Model model) {
        songsList.add(new Songs(1, "Bohemian Rhapsody"));
        songsList.add(new Songs(2, "Stairway to Heaven"));
        songsList.add(new Songs(3, "Hotel California"));
        songsList.add(new Songs(4, "Imagine"));
        songsList.add(new Songs(5, "Smells Like Teen Spirit"));
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    private ArrayList<Movies> getBestMovies() {
        return this.moviesList;
    }

    private ArrayList<Songs> getBestSongs() {
        return this.songsList;
    }

}
