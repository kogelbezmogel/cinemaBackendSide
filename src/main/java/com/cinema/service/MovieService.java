package com.cinema.service;

import com.cinema.model.Movie;
import com.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service layer for movie endpoints.
 */
@Service
@ComponentScan("com.example.repository")
public class MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMoviesByDate(LocalDateTime start, LocalDateTime end) {
        return movieRepository.getMoviesByDate(start, end);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }



}
