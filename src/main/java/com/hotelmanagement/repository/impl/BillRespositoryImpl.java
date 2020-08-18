package com.hotelmanagement.repository.impl;


import com.hotelmanagement.constant.MessageCodes;
import com.hotelmanagement.entity.BillEntity;
import com.hotelmanagement.entity.FoodmenuEntity;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.StatusMessage;
import com.hotelmanagement.repository.BillRespository;
import com.hotelmanagement.repository.FoodmenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BillRespositoryImpl {

    @Autowired
    BillRespository billRespository;
    String status = "";
    StatusMessage statusMessage = null;
    Object data;

    public BaseResponse getBillDetails() {
           data=null;
        try {
            List<BillEntity> billEntity = (List<BillEntity>) billRespository.findAll();

            data = billEntity;
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.BILLED_SUCCESS_DESC)
                    .build();
        } catch (Exception e) {
            log.error("Error while retrieving bill details , Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.BILLED_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

    public BaseResponse getFilterBillDetails(String orderID) {
        data=null;
        try {
            List<BillEntity> billEntity = (List<BillEntity>) billRespository.findByOrderIDStartingWith(orderID);

            data = billEntity;
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.BILLED_SUCCESS_DESC)
                    .build();
        } catch (Exception e) {
            log.error("Error while retrieving bill details , Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.BILLED_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }


}
