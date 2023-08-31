package com.cinema.controller;

import com.cinema.model.Room;
import com.cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * It contains endpoint regarding information exchange about rooms in movie theater.
 */
@RestController
public class RoomController {

    /**
     * Represents service room service layer.
     */
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * @return List of all available rooms in theater.
     */
    @GetMapping("/room")
    public List<Room> getAllRooms() {
        return  roomService.findAll();
    }

    /**
     * @param show_id It is show id.
     * @return Room in which show with sent id is being displayed.
     */
    @GetMapping("/room/show/{show_id}")
    public Room getRoomByShowId(@PathVariable("show_id") Long show_id) {
        return roomService.getRoomByShowId(show_id);
    }

}
