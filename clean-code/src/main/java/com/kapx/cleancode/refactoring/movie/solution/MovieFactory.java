package com.kapx.cleancode.refactoring.movie.solution;

public interface MovieFactory {
    Movie createMovie(MovieType type, String title);
}
