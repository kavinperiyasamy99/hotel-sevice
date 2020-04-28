package com.hotelmanagement.controller;

import com.hotelmanagement.constant.NameSpaceConstants;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.MenuModel;
import com.hotelmanagement.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping(value = NameSpaceConstants.addMenu.URL)
    public ResponseEntity<BaseResponse> processAddMenu(@RequestBody MenuModel request) throws Exception, IllegalArgumentException {
        log.info("MenuController :: processAddMenu() :: FoodID :: {} :: Request :: {}", request.getFoodID(), request);
        BaseResponse response = menuService.processAddMenu(request);
        log.info("MenuController :: processAddMenu() :: FoodID :: {} :: Response :: {}", request.getFoodID(), response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.getMenu.URL)
    public ResponseEntity<BaseResponse> processGetMenuItems() throws Exception, IllegalArgumentException {
        // log.info("MenuController :: processGetMenuItems() :: FoodID :: {} :: Request :: {}",request.getFoodID(),request);
        BaseResponse response = menuService.processMenuDetails();
        //    log.info("MenuController :: processGetMenuItems() :: FoodID :: {} :: Response :: {}",request.getFoodID(),response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.deletemenu.URL)
    public ResponseEntity<BaseResponse> processDeleteMenu(@RequestParam("FoodID") String FoodID) throws Exception, IllegalArgumentException {
        log.info("MenuController :: processAddMenu() :: FoodID :: {} ", FoodID);
        BaseResponse response = menuService.processDeleteMenu(FoodID);
        log.info("MenuController :: processAddMenu() :: FoodID :: {} :: Response :: {}", FoodID, response);
        return ResponseEntity.ok(response);
    }

}
