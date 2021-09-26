package com.fr.response;

import com.fr.entity.Address;
import com.fr.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UserResponse {

	private long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("phone_number")
	private String phone_number;

	@JsonProperty("email")
	private String email;

	@JsonProperty("addresses")
	private List<AddressResponse> addresses;
	
	public UserResponse(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.phone_number = user.getPhone_number();
		this.email = user.getEmail();

		if (user.getAddresses() != null){
			addresses = new ArrayList<AddressResponse>();
			for(Address address: user.getAddresses()) {
				addresses.add(new AddressResponse(address));
			}
		}
	}

}
