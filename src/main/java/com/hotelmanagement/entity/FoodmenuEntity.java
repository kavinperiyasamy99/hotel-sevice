package com.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Entity
@NoArgsConstructor
@Table(name = "food_menu_list")
@AllArgsConstructor
public class FoodmenuEntity  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("FoodID")
    @Column(name = "food_id")
    private String foodID;

    @JsonProperty("Name")
    @Column(name = "food_name")
    private String name;

    @JsonProperty("Image")
    @Column(name = "image")
    private String image;

    @JsonProperty("BaseAmount")
    @Column(name = "base_amount")
    private String baseAmount;

    @JsonProperty("Discount")
    @Column(name = "discount")
    private String discount;

    @JsonProperty("Tax")
    @Column(name = "tax")
    private String tax;

    @JsonProperty("TotalAmount")
    @Column(name = "total_amount")
    private String totalAmount;

    @JsonProperty("FoodType")
    @Column(name = "food_type")
    private String foodType;

    @JsonProperty("Status")
    @Column(name = "status")
    private String status;

    @JsonProperty("Description")
    @Column(name = "description")
    private String description;

    @JsonProperty("CreatedOn")
    @Column(name = "createdOn")
    private Date createdOn;

    @JsonProperty("UpdatedOn")
    @Column(name = "updatedOn")
    private Date updatedOn;
}


