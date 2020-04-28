package com.hotelmanagement.repository;


import com.hotelmanagement.entity.BillEntity;
import com.hotelmanagement.entity.FoodmenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRespository extends CrudRepository<BillEntity, Long> {
    BillEntity findByOrderID(String orderID);
}
