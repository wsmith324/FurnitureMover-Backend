package com.revature.furnituremover.controllers;

import com.revature.furnituremover.dtos.requests.FurnitureRequest;
import com.revature.furnituremover.dtos.responses.FurnitureResponse;
import com.revature.furnituremover.dtos.responses.HomeResponse;
import com.revature.furnituremover.services.FurnitureServices;
import com.revature.furnituremover.utils.customexceptions.FullHouseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {
    @Autowired
    private final FurnitureServices furnitureServices;

    public FurnitureController(FurnitureServices furnitureServices) {
        this.furnitureServices = furnitureServices;
    }

    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value = "/viewfurniture",  produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FurnitureResponse> viewFurniture(@RequestHeader(name = "home_id") String home_id) {
        return furnitureServices.viewFurniture(home_id);
    }

    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value = "/viewallfurniture",  produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FurnitureResponse> viewAllFurniture() {
        return furnitureServices.viewAllFurniture();
    }

    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value = "/itemquantity",  produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody int itemQuantity(@RequestHeader(name = "item") String item) {
        return furnitureServices.itemQuantity(item);
    }

    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/addfurniture", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addFurniture(@RequestBody FurnitureRequest furnitureRequest, @RequestHeader(name = "home_id") String home_id) {

        return furnitureServices.addFurniture(furnitureRequest, home_id);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public FullHouseException noRoomInHouse(FullHouseException e) {
        return e;
    }
}
