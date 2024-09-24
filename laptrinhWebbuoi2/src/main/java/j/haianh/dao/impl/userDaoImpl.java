package j.haianh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import j.haianh.configs.DBConnectMySQL;
import j.haianh.dao.IuserDao;
import j.haianh.models.User;

public class userDaoImpl extends DBConnectMySQL implements IuserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		List<User> list = new ArrayList<>();// list de truyen du lieu
		try {
			conn = super.getConnection();// ket noi database
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add((new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("image"), rs.getInt("roleid"),
						rs.getString("phone"), rs.getDate("createdate"), rs.getString("code"))));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(User user) {
		String sql = "insert into ltweb.user (username,fullname,password,email,phone) values (?,?,?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getFullName());
			ps.setString(3, user.getPassWord());
			ps.setString(4, user.getEmail());
			

			ps.setString(5, user.getPhone());
			

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			IuserDao userDao = new userDaoImpl();
			System.out.println(userDao.findAll());
			// System.out.println(userDao.findById(1));
			// System.out.println(userDao.findByName("haianh"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User findById(int id) {
		String sql = "SELECT* FROM user WHERE id=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("image"), rs.getInt("roleid"),
						rs.getString("phone"), rs.getDate("createdate"), rs.getString("code"));

				return user;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User findByName(String username) {
		String sql = "SELECT* FROM user WHERE username=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("image"), rs.getInt("roleid"),
						rs.getString("phone"), rs.getDate("createdate"), rs.getString("code"));
				return user;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from user where username = ?";
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
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from user where email = ?";
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
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String email, String password) {
		String sql = "UPDATE user SET password = ? WHERE email = ?;";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, password);
			ps.setString(2, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
