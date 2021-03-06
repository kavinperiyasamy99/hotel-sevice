package com.hotelmanagement.handlers;


import com.hotelmanagement.constant.MessageCodes;
import com.hotelmanagement.io.ExceptionResponseModel;
import com.hotelmanagement.io.StatusMessage;
import io.netty.channel.ConnectTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.client.WebServiceIOException;

import java.io.IOException;
import java.text.ParseException;



@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	
	/**
	 * This method used to throw server internal error at global level
	 * @author Kavin periyasamy
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseModel> generalException(Exception e) throws Exception{
		log.error("Exception type Exception in generalException() in  class GlobalExceptionHandler and exception is " +  e);
		ExceptionResponseModel model = new ExceptionResponseModel();
		model.setStatus(MessageCodes.INTERNAL_SERVER_ERROR);
		model.setStatusMessage(new StatusMessage(MessageCodes.INTERNAL_SERVER_ERROR_MSG, "Internal Server Error. Please try again later."));
		return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	/**
	 * This method used to send bad request response error at global level
	 * @author Kavin Periyasamy
	 * @param e
	 * @return
	 * @throws IOExceptionParseException
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseModel> badRequest(MethodArgumentNotValidException e) throws IOException{
		log.error("Exception type MethodArgumentNotValidException in badRequest() in  class GlobalExceptionHandler and exception is " +  e);
		ExceptionResponseModel model = new ExceptionResponseModel();
		model.setStatus(MessageCodes.BAD_REQUEST);
		model.setStatusMessage(new StatusMessage(MessageCodes.BAD_REQUEST, e.getMessage()));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.BAD_REQUEST);
    }
	
	
	/**
	 * This method used to send bad request response error at global level
	 * @author Kavin Periyasamy
	 * @param e
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionResponseModel> handleIllegalArgumentException(IllegalArgumentException e) throws IOException {
		log.error("Exception type IllegalArgumentException in handleIllegalArgumentException() in  class GlobalExceptionHandler and exception is " +  e);
		ExceptionResponseModel model = new ExceptionResponseModel();
		model.setStatus(MessageCodes.BAD_REQUEST);
		model.setStatusMessage(new StatusMessage(MessageCodes.BAD_REQUEST, e.getMessage()));
		return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * This method used to send gateway time out error. The time out is defined in application.properties file.
	 * @author Kavin Periyasamy
	 * @param ce
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler({ConnectTimeoutException.class, WebServiceIOException.class})
    public ResponseEntity<ExceptionResponseModel> invalidResponse(ConnectTimeoutException ce) throws IOException {
		log.error("Exception type ConnectTimeoutException ||WebServiceIOException in invalidResponse() in  class GlobalExceptionHandler and exception is " +  ce);
		ExceptionResponseModel model = new ExceptionResponseModel();
		model.setStatus(MessageCodes.GATEWAY_TIMEOUT);
		model.setStatusMessage(new StatusMessage(MessageCodes.GATEWAY_TIMEOUT_MSG, MessageCodes.GATEWAY_TIMEOUT_DESC));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.GATEWAY_TIMEOUT);
    }
	

	/**
	 * This method used to send gateway time out error. The time out is defined in application.properties file.
	 * @author Kavin Periyasamy
	 * @param ce
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler({ParseException.class})
    public ResponseEntity<ExceptionResponseModel> unsupportedMediaType(ParseException e) throws IOException {
		log.error("Exception type ParseException in unsupportedMediaType() in  class GlobalExceptionHandler and exception is " +  e);
		ExceptionResponseModel model = new ExceptionResponseModel();
		model.setStatus(MessageCodes.UNSUPPORTED_MEDIA_TYPE);
		model.setStatusMessage(new StatusMessage(MessageCodes.UNSUPPORTED_MEDIA_TYPE_MSG, MessageCodes.UNSUPPORTED_MEDIA_TYPE_DESC));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
	
	
}
