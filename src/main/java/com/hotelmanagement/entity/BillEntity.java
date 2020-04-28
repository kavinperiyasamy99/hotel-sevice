package com.hotelmanagement.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name = "bill_details")
@AllArgsConstructor
public class BillEntity {

    @Id
    @Column(name = "order_id")
    @JsonProperty("OrderID")
    private String orderID;


    @Column(name = "table_id")
    @JsonProperty("TableID")
    private String tableID;





    @Column(name = "payment_status")
    @JsonProperty("PaymentStatus")
    private String paymentStatus;


    @Column(name = "total_amount")
    @JsonProperty("TotalAmount")
    private float totalAmount;

    @Column(name = "customer_name")
    @JsonProperty("CustomerName")
    private String customerName;

    @Column(name = "gender")
    @JsonProperty("Gender")
    private String gender;

    @Column(name = "mobile_number")
    @JsonProperty("MobileNumber")
    private String mobileNumber;

    @OneToMany(mappedBy = "billEntity", cascade = CascadeType.ALL)
    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    @JsonManagedReference
    @JsonProperty("Order")
    private List<BillItemEntity> billItemEntityList;
}
