package com.hotelmanagement.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name = "bill_item_details")
@AllArgsConstructor
public class BillItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id",referencedColumnName = "order_id")
    @JsonBackReference
    private BillEntity billEntity;

    @Column(name = "track_id")
    @JsonProperty("TrackID")
    private String trackID;

    @Column(name = "food_id")
    @JsonProperty("FoodID")
    private String foodID;

    @Column(name = "food_name")
    @JsonProperty("FoodName")
    private String foodName;

    @Column(name = "quantity")
    @JsonProperty("Quantity")
    private String quantity;

    @Column(name = "amount")
    @JsonProperty("Amount")
    private String amount;

    @Column(name = "total_amount")
    @JsonProperty("TotalAmount")
    private Float totalAmount;
}
