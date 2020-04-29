package com.hotelmanagement.repository.impl;


import com.hotelmanagement.constant.MessageCodes;
import com.hotelmanagement.entity.FoodmenuEntity;
import com.hotelmanagement.io.*;
import com.hotelmanagement.repository.FoodmenuRepository;
import com.hotelmanagement.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class FoodmenuRepositoryImpl {

    @Autowired
    CommonUtils commonUtils;
    @Autowired
    FoodmenuRepository foodmenuRepository;
    String status = "";
    StatusMessage statusMessage = null;
    Object data;

    public BaseResponse addMenu(MenuModel request) {
        data = null;
        try {
            FoodmenuEntity foodmenuEntity = foodmenuRepository.findByFoodID(request.getFoodID());
            if (StringUtils.isEmpty(foodmenuEntity)) {

                foodmenuEntity = new FoodmenuEntity();
                foodmenuEntity.setFoodID(commonUtils.generateUUID());
                foodmenuEntity.setName(request.getName());
                foodmenuEntity.setImage(request.getImage());
                foodmenuEntity.setBaseAmount(request.getBaseAmount());
                foodmenuEntity.setDiscount(request.getDiscount());
                foodmenuEntity.setTax(request.getTax());
                foodmenuEntity.setTotalAmount(request.getTotalAmount());
                foodmenuEntity.setFoodType(request.getFoodType());
                foodmenuEntity.setStatus(request.getStatus());
                foodmenuEntity.setDescription(request.getDescription());
                foodmenuEntity.setCreatedOn(new Date());
                foodmenuEntity.setUpdatedOn(null);

            } else {
                if (!StringUtils.isEmpty(request.getName()))
                    foodmenuEntity.setName(request.getName());
                if (!StringUtils.isEmpty(request.getImage()))
                    foodmenuEntity.setImage(request.getImage());
                if (!StringUtils.isEmpty(request.getBaseAmount()))
                    foodmenuEntity.setBaseAmount(request.getBaseAmount());
                if (!StringUtils.isEmpty(request.getDiscount()))
                    foodmenuEntity.setDiscount(request.getDiscount());
                if (!StringUtils.isEmpty(request.getTax()))
                    foodmenuEntity.setTax(request.getTax());
                if (!StringUtils.isEmpty(request.getTotalAmount()))
                    foodmenuEntity.setTotalAmount(request.getTotalAmount());
                if (!StringUtils.isEmpty(request.getFoodType()))
                    foodmenuEntity.setFoodType(request.getFoodType());
                if (!StringUtils.isEmpty(request.getStatus()))
                    foodmenuEntity.setStatus(request.getStatus());
                if (!StringUtils.isEmpty(request.getDescription()))
                    foodmenuEntity.setDescription(request.getDescription());
                foodmenuEntity.setUpdatedOn(new Date());
            }
            foodmenuRepository.save(foodmenuEntity);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.ADD_MENU_SUCCESS_DESC)
                    .build();
            data = foodmenuEntity;

        } catch (Exception e) {
            log.error("Error while adding MenuItem updates with FoodID: {} , Exception: {}", request.getFoodID(), e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.ADD_MENU_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

    public BaseResponse getMenuDetails() {
        data = null;
        try {
            List<FoodmenuEntity> foodmenuEntityList = foodmenuRepository.findAll();

            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.GET_MENU_SUCCESS_DESC)
                    .build();

            data = foodmenuEntityList;
        } catch (Exception e) {
            log.error("Error while retriving MenuItems , Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.GET_MENU_ERROR_DESC)
                    .build();
        }

        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();

    }

    public BaseResponse deleteMenuItem(String foodID) {
        data = null;
        try {
            FoodmenuEntity foodmenuEntity = foodmenuRepository.findByFoodID(foodID);

            data = foodmenuEntity;
            foodmenuRepository.delete(foodmenuEntity);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.DELETE_MENU_SUCCESS_DESC)
                    .build();
        } catch (Exception e) {
            log.error("Error while deleting MenuItems , Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.GET_MENU_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }


}
