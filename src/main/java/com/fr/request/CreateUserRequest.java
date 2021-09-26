package com.fr.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fr.entity.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
public class CreateUserRequest {

    @JsonProperty("name")
    @NotBlank
    private String name;


    @JsonProperty("phone_number")
    @Min(10)
    private String phone_number;


    @JsonProperty("email")
    @Email
    private String email;

    @JsonProperty("addresses")
    private List<CreateAddressRequest> addresses;

}
