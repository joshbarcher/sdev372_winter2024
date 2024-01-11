package edu.greenriver.sdev.movieapp.controller;

import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//a web api to deliver movies...
@RestController
public class MovieApi
{
    private List<Movie> movies = new ArrayList<>(List.of(
        new Movie("Inception", 2010, "Science Fiction", "PG-13", false),
        new Movie("The Shawshank Redemption", 1994, "Drama", "R", false),
        new Movie("The Dark Knight", 2008, "Action", "PG-13", false),
        new Movie("Pulp Fiction", 1994, "Crime", "R", false),
        new Movie("Titanic", 1997, "Drama", "PG-13", false),
        new Movie("The Godfather", 1972, "Crime", "R", false),
        new Movie("Avatar", 2009, "Action", "PG-13", true),
        new Movie("The Lord of the Rings: The Return of the King", 2003, "Fantasy", "PG-13", false),
        new Movie("Jurassic Park", 1993, "Science Fiction", "PG-13", false),
        new Movie("Forrest Gump", 1994, "Drama", "PG-13", false)
    ));

    //REST apis are routes that pass data through HTTP
    //(methods: GET, POST, PUT/PATCH, DELETE)

    //respond to (GET) requests at localhost:3000/movies/random
    @GetMapping("movies/random")
    public Movie getRandom()
    {
        Random generator = new Random();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

    @GetMapping("movies/all")
    public List<Movie> all()
    {
        return movies;
    }

    @GetMapping("movies/{title}")
    public Movie byTitle(@PathVariable String title)
    {
        return getMovie(title);
    }

    private Movie getMovie(String title)
    {
        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getTitle().equalsIgnoreCase(title))
            {
                return next;
            }
        }

        //we can use functional code (with lambdas)
        /*Movie found = movies.stream()
            .filter(movie -> movie.getTitle().equals(title))
            .findFirst()
            .orElse(null);*/
        return null;
    }

    @GetMapping("movies/year/{year}")
    public List<Movie> byYear(@PathVariable int year)
    {
        List<Movie> results = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getYear() == year)
            {
                results.add(next);
            }
        }

        return results;
    }

    @PostMapping("movies")
    public void addMovie(@RequestBody Movie newMovie)
    {
        movies.add(newMovie);
    }

    @PutMapping("movies/{title}")
    public Movie updateMovie(@PathVariable String title,
                            @RequestBody Movie updatedMovie)
    {
        //find the movie that matches
        Movie savedMovie = getMovie(title);

        //update the data in the movie
        savedMovie.setGenre(updatedMovie.getGenre());
        savedMovie.setYear(updatedMovie.getYear());
        savedMovie.setInternational(updatedMovie.isInternational());
        savedMovie.setRating(updatedMovie.getRating());

        return savedMovie;
    }

    @DeleteMapping("")
    public void deleteMovie()
    {

    }
}
