package com.revature.furnituremover.services;

import com.revature.furnituremover.dtos.responses.HomeResponse;
import com.revature.furnituremover.models.Home;
import com.revature.furnituremover.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<Home> homes = homeRepository.viewHomes();
        List<HomeResponse> homeResp = new ArrayList<HomeResponse>();
        for (Home i : homes) {
            homeResp.add(new HomeResponse(i.getName(), i.getSize()));
        }
        return homeResp;
    }
}
