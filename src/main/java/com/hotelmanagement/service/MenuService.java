package com.hotelmanagement.service;

import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.MenuModel;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public interface  MenuService {

    public BaseResponse processAddMenu(MenuModel request)throws JAXBException, Exception;
    public BaseResponse processMenuDetails()throws JAXBException, Exception;
    public BaseResponse processDeleteMenu(String FoodID)throws JAXBException, Exception;


}
