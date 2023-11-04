package pl.ReFZero.MovieApp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.ReFZero.MovieApp.model.Movie;
import pl.ReFZero.MovieApp.model.Review;
import pl.ReFZero.MovieApp.repository.MovieRepository;

import java.util.List;

@Component
public class DatabaseInit {

    private final MovieRepository movieRepository;

    @Autowired
    public DatabaseInit(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {
        List<Movie> movies = List.of(
                Movie.builder()
                        .title("Forrest Gump")
                        .director("Robert Zemeckis")
                        .yearProduction(1994)
                        .reviews(List.of(
                                Review.builder().author("user1").content("content1").build(),
                                Review.builder().author("user2").content("content2").build(),
                                Review.builder().author("user3").content("content3").build()
                        ))
                        .build(),
                Movie.builder()
                        .title("Władca Pierścieni: Dwie wieże")
                        .director("Peter Jackson")
                        .yearProduction(2002)
                        .reviews(List.of(
                                Review.builder().author("user4").content("content4").build()))
                        .build(),
                Movie.builder()
                        .title("Joker")
                        .director("Todd Phillips")
                        .yearProduction(2019)
                        .build(),
                Movie.builder()
                        .title("Incepcja")
                        .director("Christopher Nolan")
                        .yearProduction(2010)
                        .build(),
                Movie.builder()
                        .title("WALL-E")
                        .director("Andrew Stanton")
                        .yearProduction(2008)
                        .reviews(List.of(
                                Review.builder().author("user5").content("content5").build()))
                        .build()
        );
        movieRepository.saveAll(movies);
    }
}
