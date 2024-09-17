package j.haianh.service;

import j.haianh.models.User;

public interface userService {
	User login(String Username, String Password);

	User get(String Username);

	void insert(User user);

	boolean register(String email, String password, String username, String fullname, String phone, String code);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	boolean insertregister(String email, String password, String username, String fullname, String code);
	void updatePassword(String password, String email);

}
