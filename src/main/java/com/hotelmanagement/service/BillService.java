package com.hotelmanagement.service;

import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.MenuModel;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public interface BillService {
    public BaseResponse processGetBilledDetails()throws JAXBException, Exception;

}
