package com.hotelmanagement.io;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Configuration
public class BillModel {
    @JsonProperty("TableID")
    private String tableID;

    @JsonProperty("PaymentStatus")
    private String paymentStatus;
    @JsonProperty("CustomerName")
    private String customerName;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("MobileNumber")
    private String mobileNumber;
}
