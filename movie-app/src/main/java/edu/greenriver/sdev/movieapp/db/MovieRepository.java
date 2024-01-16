package edu.greenriver.sdev.movieapp.db;

import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>
{

}
