package j.haianh.service;

import j.haianh.models.User;

public interface userService {
	User login(String Username, String Password);

	User get(String Username);

	void insert(User user);

	boolean register(String username, String fullname, String email, String password, String phone, String code);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	
	void updatePassword(String password, String email);

}
