package com.cinema.controller;


import com.cinema.bodies.BasicShowInfo;
import com.cinema.model.Show;
import com.cinema.bodies.ShowInfoIdTime;
import com.cinema.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Chow Controller. It contains endpoints regarding information exchange about show displayed in theater.
 */
@RestController
public class ShowController {

    /**
     * Represents show service layer.
     */
    ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    /**
     * @return List of all shows in database.
     */
    @GetMapping("/show")
    public List<Show> getAllShows() {
        List<Show> shows = showService.findAll();
        return shows;
    }


//    @GetMapping("/show/{date}")
//    public List<BasicShowInfo> getShowsByDate(@PathVariable("date") LocalDate date) {
//        return showService.getAllByDate(date);
//    }

//    @GetMapping("/show/times/movie/range")
//    public List<String> getShowsByMovieAndDate(
//            @RequestParam("movie_id") Long movie_id,
//            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
//            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
//        return showService.getShowTimesByMovie(movie_id, start, end);
//    }


    /**
     * This endpoint look for shows of one movie in given time range.
     * @param movie_id It is movie id which chows are looked for.
     * @param start It is parameter in iso DateTime format representing beginning of scanned interval.
     * @param end It is parameter in iso DateTime format representing end of scanned interval.
     * @return List of Shows
     */
    @GetMapping("/show/info/movie/range")
    public List<ShowInfoIdTime> getShowInfoByMovieAndDate(
            @RequestParam("movie_id") Long movie_id,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        System.out.println("Id: " + movie_id + " start: " + start.toString() + " end: " + end.toString());
        return showService.getShowInfoByMovie(movie_id, start, end);
    }

//    @GetMapping("/show/schedule/{room_id}/{date}")
//    public List<Show> getShowByRoomAndDate(@PathVariable("room_id") Long room_id, @PathVariable("date") Date day ) {
//        return null;
//        //return showService.getShowsByRoomAndDate(room_id, day);
//    }

//    @GetMapping("/show/schedule/select")
//    public List<Show> getShowByRoomAndDate(@RequestParam("room_id") Long room_id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date ) {
//        System.out.println("Get: room_id(" + room_id + ") date( " + date + " )");
//        return showService.getShowsByRoomAndDate(room_id, date);
//    }

    /**
     * This endpoint look for shows displayed in given room.
     * @param room_id It is room id
     * @param start It is parameter in iso DateTime format representing beginning of scanned interval.
     * @param end It is parameter in iso DateTime format representing end of scanned interval.
     * @return List of Shows
     */
    @GetMapping("/show/schedule/select")
    public List<Show> getShowByRoomAndDate(
            @RequestParam("room_id") Long room_id,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        System.out.println("Get: room_id(" + room_id + ") ( " + start.toString() + "-" + end.toString() + " )");
        return showService.getShowsByRoomAndDate(room_id, start, end);
    }

    /**
     * This endpoint tries to add show display to repertoire.
     * @param newShow It is show info taken as a body of post request.
     * @return true if show added and false otherwise.
     */
    @PostMapping("/show/schedule/add")
    public Boolean postShowInSchedule(@RequestBody BasicShowInfo newShow) {
        System.out.println("Post: newShow " + newShow);
        return showService.addShowInSchedule(newShow);
    }


}
