package com.hotelmanagement.repository.impl;

import com.hotelmanagement.constant.MessageCodes;
import com.hotelmanagement.entity.TableEntity;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.StatusMessage;
import com.hotelmanagement.io.TableModel;
import com.hotelmanagement.io.UserModel;
import com.hotelmanagement.repository.FoodmenuRepository;
import com.hotelmanagement.repository.TableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Slf4j
@Service
public class TableRepositoryImpl {

    @Autowired
    TableRepository tableRepository;
    String status = "";
    StatusMessage statusMessage = null;
    Object data;

    public BaseResponse addtable(TableModel request) {
        try {

            TableEntity tableEntity = new TableEntity();
            tableEntity.setTableID(request.getTableID());
            tableEntity.setTableName(request.getTableName());
            tableEntity.setCreatedOn(new Date());
            tableRepository.save(tableEntity);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.ADD_TABLE_SUCCESS_DESC)
                    .build();
            data = tableEntity;

        } catch (Exception e) {
            log.error("Error while adding new Table, Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.ADD_TABLE_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

    public BaseResponse deletetable(String tableID) {
        try {

            TableEntity tableEntity = tableRepository.findByTableID(tableID);
            tableRepository.delete(tableEntity);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.DELETE_TABLE_SUCCESS_DESC)
                    .build();
            data = tableEntity;

        } catch (Exception e) {
            log.error("Error while deleting Table, Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.DELETE_TABLE_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }
}
