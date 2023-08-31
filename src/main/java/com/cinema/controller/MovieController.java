package com.cinema.controller;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Movie Controller. It contains endpoints regarding information exchange about movies in database.
 */
@RestController
public class MovieController {

    /**
     * Represents movie service layer.
     */
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * It takes no arguments
     * @return List of all movies in database
     */
    @GetMapping("/movie/all")
    public List<Movie> getAllMovies() { return  movieService.findAll(); }


    /**
     * @param start It is parameter in iso DateTime format representing beginning of scanned interval.
     * @param end It is parameter in iso DateTime format representing end of scanned interval
     * @return Return List of movies that are played between time range from start to end parameters.
     */
    @GetMapping("/movie/range")
    public List<Movie> getMoviesByDate(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        System.out.println("Movie range request with range: " + start.toString() + " - " + end.toString());
        return movieService.getMoviesByDate(start, end);
    }

}
