package com.hotelmanagement.service.impl;

import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.MenuModel;
import com.hotelmanagement.repository.impl.FoodmenuRepositoryImpl;
import com.hotelmanagement.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    FoodmenuRepositoryImpl foodmenuRepository;

    @Override
    public BaseResponse processAddMenu(MenuModel request) throws JAXBException, Exception {
        return foodmenuRepository.addMenu(request);
    }

    @Override
    public BaseResponse processMenuDetails() throws JAXBException, Exception {
        return foodmenuRepository.getMenuDetails();
    }

    @Override
    public BaseResponse processDeleteMenu(String FoodID) throws JAXBException, Exception {
        return foodmenuRepository.deleteMenuItem(FoodID);
    }
}
