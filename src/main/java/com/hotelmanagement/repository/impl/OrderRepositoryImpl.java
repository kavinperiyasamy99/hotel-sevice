package com.hotelmanagement.repository.impl;


import com.hotelmanagement.constant.MessageCodes;
import com.hotelmanagement.entity.*;
import com.hotelmanagement.io.*;
import com.hotelmanagement.repository.BillRespository;
import com.hotelmanagement.repository.FoodmenuRepository;
import com.hotelmanagement.repository.OrderRespository;
import com.hotelmanagement.repository.TableRepository;
import com.hotelmanagement.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderRepositoryImpl {
    @Autowired
    FoodmenuRepository foodmenuRepository;
    @Autowired
    OrderRespository orderRespository;
    @Autowired
    TableRepository tableRepository;
    @Autowired
    BillRespository billRespository;
    @Autowired
    CommonUtils commonUtils;
    String status = "";
    StatusMessage statusMessage = null;
    Object data;

    public BaseResponse addOrder(OrderModel request) {
            try {
            OrderEntity orderEntity= new OrderEntity();
            TableEntity tableEntity= tableRepository.findByTableID(request.getTableID());
             FoodmenuEntity foodmenuEntity=foodmenuRepository.findByFoodID(request.getFoodID());
             orderEntity.setTableEntity(tableEntity);
             orderEntity.setFoodmenuEntity(foodmenuEntity);
             orderEntity.setTrackID(commonUtils.generateUUID());
             orderEntity.setOrderStatus("Pending");
             orderEntity.setQuantity(request.getQuantity());
             orderEntity.setTotalProductAmount(((Integer.parseInt(foodmenuEntity.getTotalAmount())) * (Integer.parseInt(request.getQuantity()))));
            orderEntity.setTableEntity(tableEntity);

            tableEntity.setOrderEntityset(new ArrayList<OrderEntity>(){{
                add(orderEntity);
            }});
            tableRepository.save(tableEntity);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.ADD_MENU_SUCCESS_DESC)
                    .build();
            data = tableEntity;
        } catch (Exception e) {
            log.error("Error while adding Food  with TableID: {} , Exception: {}", request.getTableID(), e);
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
    public BaseResponse updateOrder(OrderModel request) {
        try {

                OrderEntity orderEntity=orderRespository.findByTrackID(request.getTrackID());
                orderEntity.setOrderStatus(request.getOrderStatus());
                orderRespository.save(orderEntity);
                TableEntity tableEntity=tableRepository.findByTableID(request.getTableID());
                   status = MessageCodes.SUCCESS_MSG;
                   statusMessage = StatusMessage.builder()
                           .code(MessageCodes.SUCCESS)
                           .description(MessageCodes.UPDATE_ORDER_SUCCESS_DESC)
                           .build();
                data = tableEntity;
        } catch (Exception e) {
            log.error("Error while adding Food updates with TableID: {} , Exception: {}", request.getTableID(), e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.UPDATE_ORDER_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

    public BaseResponse orderDetails(String tableID) {
        try {
            TableEntity tableEntity=tableRepository.findByTableID(tableID);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.ORDER_DETAIL_SUCCESS_DESC)
                    .build();
            data = tableEntity;
        } catch (Exception e) {
            log.error("Error while fetching order details of TableID: {} , Exception: {}", tableID, e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.ORDER_DETAIL_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

    public BaseResponse billingOrder(BillModel request) {
        try {
            float totalbillamout=0;
            TableEntity tableEntity=tableRepository.findByTableID(request.getTableID());
            List<OrderEntity> orderEntityList=tableEntity.getOrderEntityset();
            if (orderEntityList != null) {
                BillEntity billEntity = new BillEntity();
                billEntity.setTableID(tableEntity.getTableID());
                billEntity.setOrderID(commonUtils.generateUUID());
                billEntity.setCustomerName(request.getCustomerName());
                billEntity.setGender(request.getGender());
                billEntity.setMobileNumber(request.getMobileNumber());
                billEntity.setPaymentStatus(request.getPaymentStatus());
                List<BillItemEntity> billItemEntityList = new ArrayList<>();
                if (orderEntityList != null) {
                    for (int i = 0; i < orderEntityList.size(); i++) {
                        BillItemEntity billItemEntity = new BillItemEntity();
                        billItemEntity.setBillEntity(billEntity);
                        if (orderEntityList.get(i).getFoodmenuEntity() != null) {
                            billItemEntity.setFoodID(orderEntityList.get(i).getFoodmenuEntity().getFoodID());
                            billItemEntity.setFoodName(orderEntityList.get(i).getFoodmenuEntity().getName());
                            billItemEntity.setAmount(orderEntityList.get(i).getFoodmenuEntity().getTotalAmount());
                        }
                        billItemEntity.setTrackID(orderEntityList.get(i).getTrackID());
                        billItemEntity.setQuantity(orderEntityList.get(i).getQuantity());
                        billItemEntity.setTotalAmount(orderEntityList.get(i).getTotalProductAmount());
                        totalbillamout += orderEntityList.get(i).getTotalProductAmount();
                        billItemEntityList.add(billItemEntity);
                    }
                }
                billEntity.setTotalAmount(totalbillamout);
                billEntity.setBillItemEntityList(billItemEntityList);
                billRespository.save(billEntity);
                orderRespository.deleteBytableID(tableEntity.getId());
                status = MessageCodes.SUCCESS_MSG;
                statusMessage = StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.BILLING_SUCCESS_DESC)
                        .build();
                data = billEntity;
            }else{
                status = MessageCodes.ERROR_MSG;
                statusMessage = StatusMessage.builder()
                        .code(MessageCodes.ERROR)
                        .description("Please Add the Order")
                        .build();
            }
        } catch (Exception e) {
            log.error("Error while billing of TableID: {} , Exception: {}", request.getTableID(), e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.BILLING_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

}