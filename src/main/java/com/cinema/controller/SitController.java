package com.cinema.controller;

import com.cinema.bodies.BasicSitsInfo;
import com.cinema.model.Sit;
import com.cinema.service.SitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Sit Controller. It contains endpoints regarding information exchange regarding sits in theater rooms.
 */
@RestController
public class SitController {

    /**
     * Represents sit service layer.
     */
    private SitService sitService;

    @Autowired
    public SitController(SitService sitService) {
        this.sitService = sitService;
    }

    /**
     * @return List of all sits in database.
     */
    @GetMapping("/sit")
    public List<Sit> getAllSits() {
        return sitService.findAll();
    }

    /**
     * Endpoint looking for sits in given room.
     * @param room_id It is room id for which sits are looked for.
     * @return List of sits.
     */
    @GetMapping("/sit/{room_id}")
    public List<Sit> getAllSitsInRoom(@PathVariable("room_id") Long room_id) {
        return sitService.getSitByRoom_Id(room_id);
    }

    /**
     * Endpoint creating information about sits for given show. Information includes taken and available sits marked.
     * @param show_id It is show id for which information is created.
     * @return List of BasicSitsInfo.
     */
    @GetMapping("/sit/show/{id}")
    public List<BasicSitsInfo> getBasicSitsInfoByShowId(@PathVariable("id") Long show_id) {
        return sitService.getBasicSitsInfoByShowId(show_id);
    }



}
