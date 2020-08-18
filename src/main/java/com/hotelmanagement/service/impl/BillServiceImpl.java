package com.hotelmanagement.service.impl;


import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.repository.impl.BillRespositoryImpl;
import com.hotelmanagement.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRespositoryImpl billRespository;

    @Override
    public BaseResponse processGetBilledDetails() throws JAXBException, Exception {
        return billRespository.getBillDetails();
    }

    @Override
    public BaseResponse processGetFilterBilledDetails(String orderID) throws JAXBException, Exception {
        return billRespository.getFilterBillDetails(orderID);
    }
}
