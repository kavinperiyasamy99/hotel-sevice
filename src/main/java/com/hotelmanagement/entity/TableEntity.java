package com.hotelmanagement.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name = "table_details")
@AllArgsConstructor
public class TableEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "tableEntity", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonProperty("Order")
    private List<OrderEntity> OrderEntityset;

    @Column(name = "table_id",unique=true)
    @JsonProperty("TableID")
    private String tableID;

    @Column(name = "table_name")
    @JsonProperty("TableName")
    private String tableName;

    @JsonProperty("CreatedOn")
    @Column(name = "createdOn")
    private Date createdOn;

    @JsonProperty("UpdatedOn")
    @Column(name = "updatedOn")
    private Date updatedOn;

}
