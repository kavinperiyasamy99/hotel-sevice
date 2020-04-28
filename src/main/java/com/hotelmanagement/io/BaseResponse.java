package com.hotelmanagement.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
    private StatusMessage statusMessage;
    private Object data;

}