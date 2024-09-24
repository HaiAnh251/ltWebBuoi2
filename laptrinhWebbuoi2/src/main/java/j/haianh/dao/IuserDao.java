package j.haianh.dao;

import java.util.List;

import j.haianh.models.User;

public interface IuserDao {

	List<User> findAll();

	User findById(int id);

	User findByName(String username);

	void insert(User user);



	void update(User user);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	void update(String email, String password);

}
