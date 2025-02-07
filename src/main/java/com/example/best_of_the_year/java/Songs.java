package com.example.best_of_the_year.java;

public class Songs {

    private int id = 0;
    private String titolo;

    public Songs(int id, String titolo) {
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
