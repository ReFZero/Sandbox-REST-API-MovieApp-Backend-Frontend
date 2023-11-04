package pl.ReFZero.MovieApp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ReFZero.MovieApp.exception.customException.MovieNotFoundException;
import pl.ReFZero.MovieApp.model.Movie;
import pl.ReFZero.MovieApp.repository.MovieRepository;
import pl.ReFZero.MovieApp.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    public final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie getOneMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie could not be found"));
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieRepository.findAll());
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie updatedMovie, Long movieId) {
        Movie movieFromDb = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie could not be found"));
        movieFromDb.setTitle(updatedMovie.getTitle());
        movieFromDb.setDirector(updatedMovie.getDirector());
        movieFromDb.setYearProduction(updatedMovie.getYearProduction());
        return movieFromDb; // Dirty Checking
    }

    @Override
    public void deleteMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie could not be found"));
        movieRepository.delete(movie);
    }

    @Override
    public Movie updateMovieTitle(String newMovieTitle, Long movieId) {
        Movie movieFromDb = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie could not be found"));
        movieFromDb.setTitle(newMovieTitle);
        return movieFromDb; // Dirty Checking
    }

}
