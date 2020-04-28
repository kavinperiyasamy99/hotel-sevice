package com.hotelmanagement.service.impl;


import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.BillModel;
import com.hotelmanagement.io.OrderModel;
import com.hotelmanagement.repository.impl.OrderRepositoryImpl;
import com.hotelmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepositoryImpl orderRepository;
    @Override
    public BaseResponse processAddOrder(OrderModel request) throws JAXBException, Exception {
        return orderRepository.addOrder(request);
    }

    @Override
    public BaseResponse processUpdateOrder(OrderModel request) throws JAXBException, Exception {
        return orderRepository.updateOrder(request);
    }

    @Override
    public BaseResponse processFetchOrderDetails(String  tableID) throws JAXBException, Exception {
        return orderRepository.orderDetails(tableID);
    }

    @Override
    public BaseResponse processBillingOrder(BillModel request) throws JAXBException, Exception {
        return orderRepository.billingOrder(request);
    }
}
