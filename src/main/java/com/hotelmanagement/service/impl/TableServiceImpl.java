package com.hotelmanagement.service.impl;


import com.hotelmanagement.io.BaseResponse;
import com.hotelmanagement.io.TableModel;
import com.hotelmanagement.repository.TableRepository;
import com.hotelmanagement.repository.impl.TableRepositoryImpl;
import com.hotelmanagement.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    TableRepositoryImpl tableRepository;
    @Override
    public BaseResponse processAddTable(TableModel request) throws JAXBException, Exception {
        return tableRepository.addtable(request);
    }

    @Override
    public BaseResponse processDeleteTable(String tableID) throws JAXBException, Exception {
        return tableRepository.deletetable(tableID);
    }

    @Override
    public BaseResponse processFetchTabledata() throws JAXBException, Exception {
        return null;
    }
}
