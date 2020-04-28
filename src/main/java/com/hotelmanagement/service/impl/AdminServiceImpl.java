package com.hotelmanagement.service.impl;

import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.LoginModel;
import com.hotelmanagement.io.UserModel;
import com.hotelmanagement.repository.impl.UserRepositoryImpl;
import com.hotelmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class AdminServiceImpl implements AdminService {
   @Autowired
    UserRepositoryImpl userRepository;

    @Override
    public BaseResponse processLogin(LoginModel request) throws JAXBException, Exception {
        return userRepository.login(request);
    }

    @Override
    public BaseResponse processAddUser(UserModel request) throws JAXBException, Exception {
        return userRepository.addUser(request);
    }

    @Override
    public BaseResponse processDeleteUser(String userID) throws JAXBException, Exception {
        return userRepository.deleteUser(userID);
    }

    @Override
    public BaseResponse processRetrieveUsers() throws JAXBException, Exception {
        return userRepository.getUser();
    }
}
