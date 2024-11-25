package impl;

import database.Database;
import enums.Genre;
import interfaces.FindableService;
import models.Actor;
import models.Movie;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class FindableServiceImpl implements FindableService {


    @Override
    public List<Movie> getAllMovies() {
        return Database.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : Database.movies) {
            if (movie.getName().contains(name)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : Database.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().equals(actorName)) {
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : Database.movies) {
            if (movie.getYear().equals(year)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : Database.movies) {
            if (movie.getProducer().getFirstName().contains(producerFullName)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : getAllMovies()){
            if (movie.getGenre().equals(genre)){
                return movie;
            }
        }
            return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie: getAllMovies()){
            for (Actor actor: movie.getActors()){
                if (actor.getRole().equals(role)){
                    return movie;
                }
            }
        }
        return null;
    }
}
