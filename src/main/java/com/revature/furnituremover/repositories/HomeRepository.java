package com.revature.furnituremover.repositories;

import com.revature.furnituremover.dtos.responses.HomeResponse;
import com.revature.furnituremover.models.Home;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface HomeRepository extends CrudRepository<Home, String> {

    @Query(value = "SELECT * FROM HOME", nativeQuery = true)
    List<Home> viewHomes();

}
