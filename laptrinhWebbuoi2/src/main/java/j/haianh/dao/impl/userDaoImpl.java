package j.haianh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import j.haianh.configs.DBConnectMySQL;
import j.haianh.dao.IuserDao;
import j.haianh.models.User;
import j.haianh.models.userModels;

public class userDaoImpl extends DBConnectMySQL implements IuserDao 
{
	
	
	public Connection conn=null;
	public PreparedStatement ps =null;
	public ResultSet rs=null;
	

	@Override
	public List<userModels> findAll() {
		String sql="select * from user";
		List<userModels> list =new ArrayList<>();//list de truyen du lieu
		try {
			conn =super.getConnection();//ket noi database
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new userModels(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("fullname"), rs.getString("image")));
			}
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

	

	@Override
	public void insert(User user) {
		String sql ="INSERT INTO `ltwebbuoi2`.`user` (`id`, `username`, `email`, `fullname`, `avatar`, `password`,'roleid','phone') VALUES (?, ?, ?, ?, ?, ?,?,?)";
		try 
		{
			conn =super.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getAvatar());
			ps.setString(6, user.getPassWord());
			ps.setString(7, user.getPhone());
			
					
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		userDaoImpl userDao=new userDaoImpl();
		List<userModels> list=userDao.findAll();
	//	List<userModels> list1=userDao.findById(126);
		for(userModels user:list)
		{
			System.out.println(user);
		}
	}



	public List<userModels> findById (int id) 
	{
		String sql="SELECT* FROM user WHERE id=?";
		List<userModels> list =new ArrayList<userModels>();
		try {
			conn=super.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				userModels model1=new userModels();
				list.add(new userModels(model1.getId(), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("fullname"), rs.getString("image")));
			}
			return list;

		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public List<userModels> findByName(String username) {
		String sql="SELECT* FROM user WHERE username=?";
		List<userModels> list =new ArrayList<userModels>();
		try {
			conn=super.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				userModels model1=new userModels();
				list.add(new userModels(model1.getId(), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("fullname"), rs.getString("image")));
			}
			return list;

		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
		conn = new DBConnectMySQL().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}



	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
		conn = new DBConnectMySQL().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
		
	}



	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

}
