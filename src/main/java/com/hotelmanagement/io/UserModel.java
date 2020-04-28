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
public class UserModel {

    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("UserName")
    private String username;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("Role")
    private String role;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Age")
    private String age;
    @JsonProperty("CreatedOn")
    private String createdOn;
    @JsonProperty("UpdatedOn")
    private String updatedOn;

}
