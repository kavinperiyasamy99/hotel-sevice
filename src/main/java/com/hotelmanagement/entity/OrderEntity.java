package com.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;



@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name = "order_details")
@AllArgsConstructor

public class OrderEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "food_id",referencedColumnName = "id")
    @JsonProperty("Food")
    private FoodmenuEntity foodmenuEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_id",referencedColumnName = "id",nullable=false)
   @JsonBackReference
    @JsonProperty("Table")
    private TableEntity tableEntity;

    @Column(name = "track_id")
    @JsonProperty("trackID")
    private String trackID;
    @Column(name = "quantity")
    @JsonProperty("Quantity")
    private String quantity;
    @Column(name = "orderstatus")
    @JsonProperty("OrderStatus")
    private String orderStatus;
    @Column(name = "total_product_amount")
    @JsonProperty("TotalProductAmount")
    private float totalProductAmount;
}
