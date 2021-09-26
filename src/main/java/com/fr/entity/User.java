package com.fr.entity;

import javax.persistence.*;

import com.fr.request.CreateUserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Address> addresses;

	public User(CreateUserRequest createUserRequest) {
		this.name = createUserRequest.getName();
		this.phone_number = createUserRequest.getPhone_number();
		this.email = createUserRequest.getEmail();
		//this.addresses = createUserRequest.getAddresses();
	}
}
