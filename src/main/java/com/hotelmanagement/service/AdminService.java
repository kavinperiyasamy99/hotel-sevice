package com.hotelmanagement.service;

import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.LoginModel;
import com.hotelmanagement.io.UserModel;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public interface AdminService {

    public BaseResponse processLogin(LoginModel request)throws JAXBException, Exception;
    public BaseResponse processAddUser(UserModel request)throws JAXBException, Exception;
    public BaseResponse processDeleteUser(String userID)throws JAXBException, Exception;
    public BaseResponse processRetrieveUsers()throws JAXBException, Exception;

}
