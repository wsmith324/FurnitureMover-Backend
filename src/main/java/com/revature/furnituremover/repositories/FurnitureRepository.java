package com.revature.furnituremover.repositories;

import com.revature.furnituremover.models.Furniture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends CrudRepository<Furniture, String> {
    @Query(value = "SELECT * FROM furniture WHERE home_id = ?1", nativeQuery = true)
    List<Furniture> viewFurniture(String home_id);

    @Query(value = "SELECT name, COUNT(*) FROM furniture GROUP BY name HAVING name = ?1", nativeQuery = true)
    String itemQuantity(String name);
}
