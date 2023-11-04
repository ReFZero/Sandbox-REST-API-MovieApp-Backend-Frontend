package pl.ReFZero.MovieApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ReFZero.MovieApp.model.Movie;
import pl.ReFZero.MovieApp.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<Movie> getOneMovieById(@PathVariable(name = "movieId") Long movieId) {
        return new ResponseEntity<>(movieService.getOneMovieById(movieId), HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PostMapping("/movies/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        return new ResponseEntity<>(movieService.createMovie(newMovie), HttpStatus.CREATED);
    }

    @PutMapping("/movies/{movieId}/update")
    public ResponseEntity<Movie> updateMovieOrIfNotExistCreate(@RequestBody Movie updatedMovie,
                                                               @PathVariable(name = "movieId") Long movieId) {
        return new ResponseEntity<>(movieService.updateMovie(updatedMovie, movieId), HttpStatus.OK);
    }

    // DELETE z @PathVariable
//    @DeleteMapping("/movies/{movieId}/delete")
//    public ResponseEntity<String> deleteMovie(@PathVariable(name = "movieId") Long movieId) {
//        movieService.deleteMovie(movieId);
//        return new ResponseEntity<>("Movie deleted", HttpStatus.OK);
//    }

// DELETE z @RequestParam
    @DeleteMapping("/movies/delete")
    public ResponseEntity<String> deleteMovie(@RequestParam(value = "movieId", required = true) Long movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>("Movie deleted", HttpStatus.OK);
    }

    @PatchMapping("/movies/{movieId}/update")
    public ResponseEntity<Movie> updateMovieTitle(@RequestParam(value = "movieTitle") String newMovieTitle,
                                             @PathVariable(name = "movieId") Long movieId) {
        return new ResponseEntity<>(movieService.updateMovieTitle(newMovieTitle, movieId), HttpStatus.OK);
    }
}
