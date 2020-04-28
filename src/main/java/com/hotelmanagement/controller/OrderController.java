package com.hotelmanagement.controller;


import com.hotelmanagement.constant.NameSpaceConstants;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.BillModel;
import com.hotelmanagement.io.MenuModel;
import com.hotelmanagement.io.OrderModel;
import com.hotelmanagement.service.MenuService;
import com.hotelmanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = NameSpaceConstants.order.URL)
    public ResponseEntity<BaseResponse> processAddOrder(@RequestBody OrderModel request) throws Exception, IllegalArgumentException {
        log.info("OrderController :: processAddOrder() :: TableID :: {} :: Request :: {}", request.getFoodID(), request);
        BaseResponse response = orderService.processAddOrder(request);
        log.info("OrderController :: processAddOrder() :: TableID :: {} :: Response :: {}", request.getFoodID(), response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.update_order.URL)
    public ResponseEntity<BaseResponse> processUpdateOrder(@RequestBody OrderModel request) throws Exception, IllegalArgumentException {
        log.info("OrderController :: processUpdateOrder() :: TableID :: {} :: Request :: {}", request.getFoodID(), request);
        BaseResponse response = orderService.processAddOrder(request);
        log.info("OrderController :: processUpdateOrder() :: TableID :: {} :: Response :: {}", request.getFoodID(), response);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value = NameSpaceConstants.get_order_details.URL)
    public ResponseEntity<BaseResponse> processFetchOrderDetails(@RequestParam("TableID") String tableID) throws Exception, IllegalArgumentException {
        log.info("OrderController :: processFetchOrderDetails()");
        BaseResponse response = orderService.processFetchOrderDetails(tableID);
        log.info("OrderController :: processFetchOrderDetails() :: {} :: Response :: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.bill_order.URL)
    public ResponseEntity<BaseResponse> processBillingOrder(@RequestBody BillModel request) throws Exception, IllegalArgumentException {
        log.info("OrderController :: processBillingOrder()");
        BaseResponse response = orderService.processBillingOrder(request);
        log.info("OrderController :: processBillingOrder() :: {} :: Response :: {}", response);
        return ResponseEntity.ok(response);
    }

}
