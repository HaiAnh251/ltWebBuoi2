package j.haianh.dao;

import java.util.List;

import j.haianh.models.User;
import j.haianh.models.userModels;

public interface IuserDao {
	
	List<userModels> findAll();
	
	List<userModels> findById(int id);
	
	List<userModels> findByName(String username);
	
	void insert(User user);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);


	

}
