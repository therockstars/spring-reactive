package reactive.example.netfluxexample.service;

import reactive.example.netfluxexample.domain.Movie;
import reactive.example.netfluxexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    /**
     * Get Stream of Movie Events for given Movie ID
     *
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * get Movie by ID
     *
     * @param id
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     * Return list of all movies
     *
     * @return
     */
    Flux<Movie> getAllMovies();

}
