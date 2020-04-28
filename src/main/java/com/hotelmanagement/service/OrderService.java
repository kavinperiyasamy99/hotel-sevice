package com.hotelmanagement.service;


import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.BillModel;
import com.hotelmanagement.io.OrderModel;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public interface OrderService {
    public BaseResponse processAddOrder(OrderModel request)throws JAXBException, Exception;
    public BaseResponse processUpdateOrder(OrderModel request)throws JAXBException, Exception;
    public BaseResponse processFetchOrderDetails(String tableID)throws JAXBException, Exception;
    public BaseResponse processBillingOrder(BillModel request)throws JAXBException, Exception;



}
