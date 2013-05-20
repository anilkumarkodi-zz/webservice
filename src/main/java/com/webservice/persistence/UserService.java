package com.webservice.persistence;


import com.webservice.domain.User;

public interface UserService {
	public void saveUser(User user);
	public String getAllUser();
}
