package com.hotelmanagement.controller;


import com.hotelmanagement.constant.NameSpaceConstants;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.LoginModel;
import com.hotelmanagement.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillController {
   @Autowired
    BillService billService;

    @PostMapping(value = NameSpaceConstants.get_billed_details.URL)
    public ResponseEntity<BaseResponse> processGetBilledDetails() throws Exception, IllegalArgumentException {
        log.info("BillController :: processGetBilledDetails()");
        BaseResponse response = billService.processGetBilledDetails();
        log.info("BillController :: processGetBilledDetails():: Response :: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = NameSpaceConstants.filter_billed_details.URL)
    public ResponseEntity<BaseResponse> processGetFilterBilledDetails(String orderID) throws Exception, IllegalArgumentException {
        log.info("BillController :: processGetFilterBilledDetails()");
        BaseResponse response = billService.processGetFilterBilledDetails(orderID);
        log.info("BillController :: processGetFilterBilledDetails():: Response :: {}", response);
        return ResponseEntity.ok(response);
    }


}
