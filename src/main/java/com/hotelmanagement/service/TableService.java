package com.hotelmanagement.service;

import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.MenuModel;
import com.hotelmanagement.io.TableModel;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public interface TableService {

    public BaseResponse processAddTable(TableModel request)throws JAXBException, Exception;
    public BaseResponse processDeleteTable(String tableID)throws JAXBException, Exception;
    public BaseResponse processFetchTabledata()throws JAXBException, Exception;

}
