package com.hotelmanagement.controller;


import com.hotelmanagement.constant.NameSpaceConstants;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.LoginModel;
import com.hotelmanagement.io.MenuModel;
import com.hotelmanagement.io.UserModel;
import com.hotelmanagement.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = NameSpaceConstants.login.URL)
    public ResponseEntity<BaseResponse> processLogin(@RequestBody LoginModel request) throws Exception, IllegalArgumentException {
        log.info("AdminController :: processAddUser() :: Request :: {}", request);
        BaseResponse response = adminService.processLogin(request);
        log.info("AdminController :: processAddUser():: Response :: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.add_user.URL)
    public ResponseEntity<BaseResponse> processAddUser(@RequestBody UserModel request) throws Exception, IllegalArgumentException {
        log.info("AdminController :: processAddUser() :: Request :: {}", request);
        BaseResponse response = adminService.processAddUser(request);
        log.info("AdminController :: processAddUser():: Response :: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstants.delete_user.URL)
    public ResponseEntity<BaseResponse> processDeleteUser(@RequestParam("UserID") String userID) throws Exception, IllegalArgumentException {
        log.info("AdminController :: processDeleteUser() :: UserID :: {}", userID);
        BaseResponse response = adminService.processDeleteUser(userID);
        log.info("AdminController :: processDeleteUser():: Response :: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = NameSpaceConstants.get_user.URL)
    public ResponseEntity<BaseResponse> processRetrieveUsers() throws Exception, IllegalArgumentException {
        log.info("AdminController :: processAddUser()");
        BaseResponse response = adminService.processRetrieveUsers();
        log.info("AdminController :: processAddUser():: Response :: {}", response);
        return ResponseEntity.ok(response);
    }
}
