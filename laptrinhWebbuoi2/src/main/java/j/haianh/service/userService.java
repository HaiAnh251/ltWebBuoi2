package j.haianh.service;

import j.haianh.models.User;
import j.haianh.models.userModels;

public interface userService {
	userModels login(String Username, String Password);
	userModels get(String Username);
	
	void insert(User user);
	boolean register(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
}
