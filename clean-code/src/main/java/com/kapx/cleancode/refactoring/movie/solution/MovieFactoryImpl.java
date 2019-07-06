package com.kapx.cleancode.refactoring.movie.solution;

public class MovieFactoryImpl implements MovieFactory {
    @Override
    public Movie createMovie(final MovieType type, final String title) {
        switch (type) {
            case CHILDRENS:
                return new ChildrensMovie(title);
            case NEW_RELEASE:
                return new NewReleaseMovie(title);
            case REGULAR:
                return new RegularMovie(title);
            default:
                throw new InvalidMovieException(type);
        }
    }
}
