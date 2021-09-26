package com.fr.response;

import com.fr.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressResponse {

    private Long id;

    private String address;

    public AddressResponse (Address address_){
        this.id = address_.getId();
        this.address = address_.getAddress();
    }

}
