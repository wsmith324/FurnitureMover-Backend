package com.revature.furnituremover.services;

import com.revature.furnituremover.dtos.requests.FurnitureRequest;
import com.revature.furnituremover.dtos.responses.FurnitureResponse;
import com.revature.furnituremover.models.Furniture;
import com.revature.furnituremover.models.Home;
import com.revature.furnituremover.repositories.FurnitureRepository;
import com.revature.furnituremover.repositories.HomeRepository;
import com.revature.furnituremover.utils.customexceptions.FullHouseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FurnitureServices {
    @Autowired
    private final FurnitureRepository furnitureRepository;
    private final HomeRepository homeRepository;

    public FurnitureServices(FurnitureRepository furnitureRepository, HomeRepository homeRepository) {
        this.furnitureRepository = furnitureRepository;
        this.homeRepository = homeRepository;
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public List<FurnitureResponse> viewFurniture(String home_id) {
        List<FurnitureResponse> furnitureResp = new ArrayList<>();
        for (Furniture i : furnitureRepository.viewFurniture(home_id)) {
            furnitureResp.add(new FurnitureResponse(i.getName(), i.getSize()));
        }
        return furnitureResp;
    }

    public List<FurnitureResponse> viewAllFurniture() {
        List<FurnitureResponse> furnitureResp = new ArrayList<>();
        for (Furniture i : furnitureRepository.findAll()) {
            furnitureResp.add(new FurnitureResponse(i.getName(), i.getSize()));
        }
        return furnitureResp;
    }

    public int itemQuantity(String name) {
        System.out.println("Name: " + name);
        System.out.println(furnitureRepository.itemQuantity(name));
        return Integer.parseInt(furnitureRepository.itemQuantity(name).split(",")[1]);
    }

    public String addFurniture(FurnitureRequest furnitureRequest, String home_id) {
        Home home = homeRepository.getHomeByID(home_id);
        Furniture furniture = new Furniture(UUID.randomUUID().toString(), furnitureRequest.getName().trim(), furnitureRequest.getSize(), home);
        int storageSize = 0;
        try {
            storageSize += Integer.parseInt(furnitureRepository.storageSize(home_id));
        } catch (NumberFormatException e) {}
        if (storageSize + furnitureRequest.getSize() > (homeRepository.homeSize(home_id))/2) {
            throw new FullHouseException("Home has reached maximum capacity");
        } else {
            furnitureRepository.save(furniture);
        }
        return "Item added to house!";
    }
}
