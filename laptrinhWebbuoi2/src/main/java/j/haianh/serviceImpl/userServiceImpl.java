package j.haianh.serviceImpl;

import j.haianh.dao.IuserDao;
import j.haianh.dao.impl.userDaoImpl;
import j.haianh.models.User;
import j.haianh.models.userModels;
import j.haianh.service.userService;

public class userServiceImpl  implements userService
{
	IuserDao userDao=new userDaoImpl();
	@Override
	public userModels login(String Username, String Password) {
		userModels user=this.findByname(Username);
		if(user !=null && Password.equals(user.getPassword()))
		{
			return user;
		}
		return null;
	}

	public userModels findByname(String username) {
		
		return (userModels) userDao.findByName(username);
	}

	@Override
	public userModels get(String Username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) 
	{
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new User(1, email, username, fullname,password, null,5,phone));
			return true;
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
	
	
	

	
	

}
