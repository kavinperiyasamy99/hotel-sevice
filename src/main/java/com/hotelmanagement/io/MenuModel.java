package com.hotelmanagement.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Configuration
public class MenuModel {

    @JsonProperty("FoodID")
    private String foodID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Image")
    private String image;
    @JsonProperty("BaseAmount")
    private String baseAmount;
    @JsonProperty("Discount")
    private String discount;
    @JsonProperty("Tax")
    private String tax;
    @JsonProperty("TotalAmount")
    private String totalAmount;
    @JsonProperty("FoodType")
    private String foodType;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("CreatedOn")
    private Date createdOn;
    @JsonProperty("UpdatedOn")
    private Date updatedOn;
}
