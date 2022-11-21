package com.revature.furnituremover.controllers;

import com.revature.furnituremover.dtos.requests.HomeRequest;
import com.revature.furnituremover.dtos.responses.HomeResponse;
import com.revature.furnituremover.services.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private final HomeServices homeServices;

    public HomeController(HomeServices homeServices) {
        this.homeServices = homeServices;
    }

    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value = "/viewhomes", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<HomeResponse> viewHomes() {
        return homeServices.viewHomes();
    }

    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/createhome", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createHome(@RequestBody HomeRequest homeRequest) {
        homeServices.createHome(homeRequest);
        return "Your home has been added to the system!";
    }
}
