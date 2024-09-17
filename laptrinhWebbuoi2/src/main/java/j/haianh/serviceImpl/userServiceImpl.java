package j.haianh.serviceImpl;

import j.haianh.dao.IuserDao;
import j.haianh.dao.impl.userDaoImpl;
import j.haianh.models.User;
import j.haianh.service.userService;

public class userServiceImpl implements userService {
	IuserDao userDao = new userDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.findByname(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	public User findByname(String username) {

		return userDao.findByName(username);
	}

	@Override
	public User get(String username) {

		return null;
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);

	}



	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);

	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone,String code) {
		if(userDao.checkExistEmail(email))
		{
			return false;
		}
		
		
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new User(username,email,fullname,password,0,code));
			return true;

	}

	@Override
	public boolean insertregister(String email, String password, String username, String fullname, String code) {
		// TODO Auto-generated method stub
		return false;
	}

}
