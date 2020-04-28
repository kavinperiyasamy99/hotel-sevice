package com.hotelmanagement.controller;

import com.hotelmanagement.constant.NameSpaceConstants;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.MenuModel;
import com.hotelmanagement.io.OrderModel;
import com.hotelmanagement.io.TableModel;
import com.hotelmanagement.service.MenuService;
import com.hotelmanagement.service.TableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TableController {

    @Autowired
    TableService tableService;

    @PostMapping(value = NameSpaceConstants.add_table.URL)
    public ResponseEntity<BaseResponse> processAddTable(@RequestBody TableModel request) throws Exception, IllegalArgumentException {
        log.info("TableController :: processAddTable() :: TableID :: {} :: Request :: {}", request.getTableID(), request);
        BaseResponse response = tableService.processAddTable(request);
        log.info("TableController :: processAddTable() :: TableID :: {} :: Response :: {}", request.getTableID(), response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.delete_table.URL)
    public ResponseEntity<BaseResponse> processDeleteTable(@RequestParam("TableID") String tableID) throws Exception, IllegalArgumentException {
        log.info("TableController :: processDeleteTable() :: TableID :: {} ", tableID);
        BaseResponse response = tableService.processDeleteTable(tableID);
        log.info("TableController :: processDeleteTable() :: TableID :: {} :: Response :: {}", tableID, response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.fetch_table_detail.URL)
    public ResponseEntity<BaseResponse> processFetchTabledata() throws Exception, IllegalArgumentException {
        log.info("TableController :: processFetchTabledata()");
        BaseResponse response = tableService.processFetchTabledata();
        log.info("TableController :: processFetchTabledata() :: {} :: Response :: {}", response);
        return ResponseEntity.ok(response);
    }




}
