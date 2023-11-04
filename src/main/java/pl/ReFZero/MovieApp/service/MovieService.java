package pl.ReFZero.MovieApp.service;

import pl.ReFZero.MovieApp.model.Movie;

import java.util.List;

public interface MovieService {
    Movie getOneMovieById(Long movieId);
    List<Movie> getAllMovies();
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie, Long movieId);
    void deleteMovie(Long movieId);
    Movie updateMovieTitle(String newMovieTitle, Long movieId);
}