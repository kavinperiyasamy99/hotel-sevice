package com.hotelmanagement.repository;

import com.hotelmanagement.entity.FoodmenuEntity;
import com.hotelmanagement.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface OrderRespository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByTrackID(String trackID);
    @Transactional
    @Modifying      // to mark delete or update query
    @Query("Delete from OrderEntity u where u.tableEntity.id = :tableID")       // it will delete all the record with specific name
    int deleteBytableID( Long tableID);
}
