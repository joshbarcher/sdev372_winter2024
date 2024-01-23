package edu.greenriver.sdev.movieapp.controller;

import edu.greenriver.sdev.movieapp.domain.Movie;
import edu.greenriver.sdev.movieapp.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//a web api to deliver movies...
@RestController
public class MovieApi
{
    private MovieService service;

    public MovieApi(MovieService service)
    {
        this.service = service;
    }

    //respond to (GET) requests at localhost:3000/movies/random
    @GetMapping("movies/random")
    public Movie getRandom()
    {
        return service.getRandomMovie();
    }

    @GetMapping("movies/all")
    public List<Movie> all()
    {
        return service.all();
    }

    @GetMapping("movies/title/{title}")
    public Movie byTitle(@PathVariable String title)
    {
        return service.byTitle(title);
    }

    @GetMapping("movies/{id}")
    public Movie byId(@PathVariable int id)
    {
        return service.byId(id);
    }

    @GetMapping("movies/year/{year}")
    public List<Movie> byYear(@PathVariable int year)
    {
        return service.byYear(year);
    }

    @PostMapping("movies")
    public void addMovie(@RequestBody Movie newMovie)
    {
        service.addMovie(newMovie);
    }

    @PutMapping("movies/{id}")
    public Movie updateMovie(@PathVariable int id,
                            @RequestBody Movie updatedMovie)
    {
        return service.updateMovie(updatedMovie, id);
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovie(@PathVariable int id)
    {
        service.deleteMovie(id);
    }
}
