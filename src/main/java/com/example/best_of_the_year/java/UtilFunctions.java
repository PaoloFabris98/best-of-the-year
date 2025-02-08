package com.example.best_of_the_year.java;

import java.util.ArrayList;

public class UtilFunctions {
    public static boolean existMovies(ArrayList<Movies> a, String b) {
        if (a == null || a.isEmpty()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            String currentElement = a.get(i).getTitle();
            if (currentElement.toLowerCase().equals(b.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean existSongs(ArrayList<Songs> a, String b) {
        if (a == null || a.isEmpty()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            String currentElement = a.get(i).getTitle();
            if (currentElement.toLowerCase().equals(b.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
