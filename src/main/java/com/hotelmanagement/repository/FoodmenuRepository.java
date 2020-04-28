package com.hotelmanagement.repository;

import com.hotelmanagement.entity.FoodmenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodmenuRepository extends CrudRepository<FoodmenuEntity, Long> {
    FoodmenuEntity findByFoodID(String foodID);
    List<FoodmenuEntity> findAll();
}
