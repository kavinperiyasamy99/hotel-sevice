package com.hotelmanagement.repository.impl;

import com.hotelmanagement.constant.MessageCodes;
import com.hotelmanagement.entity.UserEntity;
import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.LoginModel;
import com.hotelmanagement.io.StatusMessage;
import com.hotelmanagement.io.UserModel;
import com.hotelmanagement.repository.UserRepository;
import com.hotelmanagement.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserRepositoryImpl {

    @Autowired
    CommonUtils commonUtils;
    @Autowired
    UserRepository userRepository;
    String status = "";
    StatusMessage statusMessage = null;
    Object data;

    public BaseResponse login(LoginModel request) {
        status = MessageCodes.ERROR_MSG;
        statusMessage = StatusMessage.builder()
                .code(MessageCodes.ERROR)
                .description(MessageCodes.INVALID_CREDENTIAL_DESC)
                .build();
        try {
            List<UserEntity> userEntity= userRepository.findAll();
            for(int i=0;i<userEntity.size();i++){
               if(userEntity.get(i).getUsername().equals(request.getUserName()) && userEntity.get(i).getPassword().equals(request.getPassword())){
                   status = MessageCodes.SUCCESS_MSG;
                   statusMessage = StatusMessage.builder()
                           .code(MessageCodes.SUCCESS)
                           .description(MessageCodes.LOGIN_SUCCESS_DESC)
                           .build();
               }
            }

        }catch (Exception e) {
            log.error("Error while logging user, Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.LOGIN_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }



    public BaseResponse addUser(UserModel request){
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserID(commonUtils.generateUUID());
            userEntity.setFirstName(request.getFirstName());
            userEntity.setLastName(request.getLastName());
            userEntity.setUsername(request.getUsername());
            userEntity.setPassword(request.getPassword());
            userEntity.setRole(request.getRole());
            userEntity.setGender(request.getGender());
            userEntity.setAge(request.getAge());
            userEntity.setCreatedOn(new Date());
            userRepository.save(userEntity);
            status = MessageCodes.SUCCESS_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.SUCCESS)
                    .description(MessageCodes.ADD_USER_SUCCESS_DESC)
                    .build();
            data = userEntity;
        } catch (Exception e) {
            log.error("Error while adding new user, Exception: {}", e);
            status = MessageCodes.ERROR_MSG;
            statusMessage = StatusMessage.builder()
                    .code(MessageCodes.ERROR)
                    .description(MessageCodes.ADD_USER_ERROR_DESC)
                    .build();
        }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }
    public BaseResponse deleteUser(String userID){
      try{
          UserEntity userEntity= userRepository.findByUserID(userID);
          userRepository.delete(userEntity);
          status = MessageCodes.SUCCESS_MSG;
          statusMessage = StatusMessage.builder()
                  .code(MessageCodes.SUCCESS)
                  .description(MessageCodes.DELETE_USER_SUCCESS_DESC)
                  .build();
          data = userEntity;
      }catch (Exception e) {
          log.error("Error while deleting user, Exception: {}", e);
          status = MessageCodes.ERROR_MSG;
          statusMessage = StatusMessage.builder()
                  .code(MessageCodes.ERROR)
                  .description(MessageCodes.DELETE_USER_ERROR_DESC)
                  .build();
      }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }


   public BaseResponse getUser(){
  try{
      List<UserEntity> userEntityList=userRepository.findAll();
      status = MessageCodes.SUCCESS_MSG;
      statusMessage = StatusMessage.builder()
              .code(MessageCodes.SUCCESS)
              .description(MessageCodes.FETCH_USER_SUCCESS_DESC)
              .build();
      data = userEntityList;
  }catch (Exception e) {
      log.error("Error while retrieving user details, Exception: {}", e);
      status = MessageCodes.ERROR_MSG;
      statusMessage = StatusMessage.builder()
              .code(MessageCodes.ERROR)
              .description(MessageCodes.FETCH_USER_ERROR_DESC)
              .build();
  }
        return BaseResponse.builder()
                .status(status)
                .statusMessage(statusMessage)
                .data(data)
                .build();
    }

}
