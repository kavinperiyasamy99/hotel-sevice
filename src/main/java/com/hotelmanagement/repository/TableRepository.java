package com.hotelmanagement.repository;

import com.hotelmanagement.entity.FoodmenuEntity;
import com.hotelmanagement.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Long> {
    TableEntity findAllByTableID(String tableID);
    TableEntity findByTableID(String tableID);
    List<TableEntity> findAll();

}
