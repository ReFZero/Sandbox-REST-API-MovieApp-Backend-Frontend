package pl.ReFZero.MovieApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ReFZero.MovieApp.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
