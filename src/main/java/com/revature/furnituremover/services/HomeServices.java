package com.revature.furnituremover.services;

import com.revature.furnituremover.dtos.requests.HomeRequest;
import com.revature.furnituremover.dtos.responses.HomeResponse;
import com.revature.furnituremover.models.Home;
import com.revature.furnituremover.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomeServices {
    @Autowired
    private final HomeRepository homeRepository;

    public HomeServices(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public void saveHome(Home home) {
        homeRepository.save(home);
    }

    public List<HomeResponse> viewHomes() {
        List<HomeResponse> homeResp = new ArrayList<HomeResponse>();
        for (Home i : homeRepository.viewHomes()) {
            homeResp.add(new HomeResponse(i.getHome_id(), i.getName(), i.getSize()));
        }
        return homeResp;
    }

    public void createHome(HomeRequest homeRequest) {
        homeRepository.save(new Home(UUID.randomUUID().toString(), homeRequest.getName(), homeRequest.getSize()));
    }
}
