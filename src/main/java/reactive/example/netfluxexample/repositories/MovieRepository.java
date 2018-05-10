package reactive.example.netfluxexample.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactive.example.netfluxexample.domain.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}
