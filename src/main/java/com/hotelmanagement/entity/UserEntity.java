package com.hotelmanagement.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "user_details")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    @JsonProperty("UserID")
    private String userID;

    @JsonProperty("FirstName")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("LastName")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("UserName")
    @Column(name = "username")
    private String username;

    @JsonProperty("Password")
    @Column(name = "password")
    private String password;

    @JsonProperty("Role")
    @Column(name = "role")
    private String role;

    @JsonProperty("Gender")
    @Column(name = "gender")
    private String gender;

    @JsonProperty("Age")
    @Column(name = "age")
    private String age;

    @JsonProperty("CreatedOn")
    @Column(name = "createdOn")
    private Date createdOn;

    @JsonProperty("UpdatedOn")
    @Column(name = "updatedOn")
    private Date updatedOn;
}
