package com.revature.furnituremover.services;

import com.revature.furnituremover.dtos.responses.FurnitureResponse;
import com.revature.furnituremover.models.Furniture;
import com.revature.furnituremover.repositories.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FurnitureServices {
    @Autowired
    private final FurnitureRepository furnitureRepository;

    public FurnitureServices(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public List<FurnitureResponse> viewFurniture(String home_id) {
        List<Furniture> furniture = furnitureRepository.viewFurniture(home_id);
        List<FurnitureResponse> furnitureResp = new ArrayList<FurnitureResponse>();
        for (Furniture i : furniture) {
            furnitureResp.add(new FurnitureResponse(i.getName(), i.getSize()));
        }
        return furnitureResp;
    }
}
