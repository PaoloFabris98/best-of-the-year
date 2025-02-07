package com.example.best_of_the_year.java;

public class Movies {
    private int id = 0;
    private String titolo;

    public Movies(int id, String titolo) {
        this.id = id;
        this.titolo = titolo;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.titolo;
    }
}
