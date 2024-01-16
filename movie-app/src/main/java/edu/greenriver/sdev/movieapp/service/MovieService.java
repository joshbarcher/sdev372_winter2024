package edu.greenriver.sdev.movieapp.service;

import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
    This class has business logic and is marked
    as a stereotypical service layer.
 */
@Service
public class MovieService
{
    private List<Movie> movies = new ArrayList<>(List.of(
            new Movie(0, "Inception", 2010, "Science Fiction", "PG-13", false),
            new Movie(0, "The Shawshank Redemption", 1994, "Drama", "R", false),
            new Movie(0, "The Dark Knight", 2008, "Action", "PG-13", false),
            new Movie(0, "Pulp Fiction", 1994, "Crime", "R", false),
            new Movie(0, "Titanic", 1997, "Drama", "PG-13", false),
            new Movie(0, "The Godfather", 1972, "Crime", "R", false),
            new Movie(0, "Avatar", 2009, "Action", "PG-13", true),
            new Movie(0, "The Lord of the Rings: The Return of the King", 2003, "Fantasy", "PG-13", false),
            new Movie(0, "Jurassic Park", 1993, "Science Fiction", "PG-13", false),
            new Movie(0, "Forrest Gump", 1994, "Drama", "PG-13", false)
    ));

    public Movie getRandomMovie()
    {
        Random generator = new Random();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

    public List<Movie> all()
    {
        //convert to read-only list
        return Collections.unmodifiableList(movies);
    }

    public Movie byTitle(String title)
    {
        int index = movieIndexOf(title);
        return movies.get(index);
    }

    public List<Movie> byYear(int year)
    {
        List<Movie> results = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getReleaseYear() == year)
            {
                results.add(next);
            }
        }

        return results;
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    public Movie updateMovie(Movie updatedMovie, String title)
    {
        //find the movie that matches
        Movie savedMovie = movies.get(movieIndexOf(title));

        //update the data in the movie
        savedMovie.setGenre(updatedMovie.getGenre());
        savedMovie.setReleaseYear(updatedMovie.getReleaseYear());
        savedMovie.setInternational(updatedMovie.isInternational());
        savedMovie.setRating(updatedMovie.getRating());

        return savedMovie;
    }

    public void deleteMovie(String title)
    {
        int index = movieIndexOf(title);
        movies.remove(index);
    }

    //returns the index where the matching movie title is found
    private int movieIndexOf(String title)
    {
        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getTitle().equalsIgnoreCase(title))
            {
                return i;
            }
        }

        return -1;
    }
}
