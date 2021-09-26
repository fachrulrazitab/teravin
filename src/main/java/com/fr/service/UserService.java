package com.fr.service;

import java.util.ArrayList;
import java.util.List;

import com.fr.entity.Address;
import com.fr.repository.AddressRepository;
import com.fr.request.CreateAddressRequest;
import com.fr.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.entity.User;
import com.fr.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	public List<User> getAllStudents () {
		return userRepository.findAll();
	}

	public User createUser (CreateUserRequest createUserRequest){
		User user = new User(createUserRequest);
		userRepository.save(user);

		List<Address> addressList = new ArrayList<Address>();
		if(createUserRequest.getAddresses() != null) {
			for (CreateAddressRequest createAddressRequest : createUserRequest.getAddresses()) {
				Address address = new Address();
				address.setAddress(createAddressRequest.getAddress());
				address.setUser(user);

				addressList.add(address);
			}

			addressRepository.saveAll(addressList);
		}

		user.setAddresses(addressList);
		return user;
	}
}
