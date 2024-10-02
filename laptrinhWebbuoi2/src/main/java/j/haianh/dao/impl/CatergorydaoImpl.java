package j.haianh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import j.haianh.configs.DBConnectMySQL;
import j.haianh.dao.ICatergoryDao;
import j.haianh.models.CatergoryModel;

public  class CatergorydaoImpl  implements ICatergoryDao{

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	@Override
	public List<CatergoryModel> findAll() {
		String sql="select* from catergory";
		List<CatergoryModel> list=new ArrayList<>();
		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				CatergoryModel catergory= new CatergoryModel();
				catergory.setCatergory_id(rs.getInt("catergory_id"));
				catergory.setCatergory_name(rs.getString("catergory_name"));
				catergory.setImage(rs.getString("image"));
				catergory.setStatus(rs.getInt("status"));
				list.add(catergory);
				return list;
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CatergoryModel findById(int id) {
		String sql="select* from catergory wher catergory_is=?";
		
		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				CatergoryModel catergory= new CatergoryModel();
				catergory.setCatergory_id(rs.getInt("catergory_id"));
				catergory.setCatergory_name(rs.getString("catergory_name"));
				catergory.setImage(rs.getString("image"));
				catergory.setStatus(rs.getInt("status"));
				
				return catergory;
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CatergoryModel category) {
		String sql="insert into ltweb.catergory ( catergory_name, image,status) values (?,?,?)";
		List<CatergoryModel> list=new ArrayList<>();
		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1,category.getCatergory_name());
			ps.setString(1,category.getImage());
			ps.setInt(1,category.getStatus());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(CatergoryModel category) {
		String sql="update caterggory set catergory_name=?, image=?, status=? where catergory_id=?";
		
		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, category.getCatergory_name());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCatergory_id());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from catergory where catergory_id=?";
		
		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CatergoryModel> findByName(String keyword) {
		String sql="select* from catergory wher catergory_name like ?";
		List<CatergoryModel> list=new ArrayList<>();
		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+ keyword +"%");
			rs=ps.executeQuery();
			while(rs.next())
			{
				CatergoryModel catergory= new CatergoryModel();
				catergory.setCatergory_id(rs.getInt("catergory_id"));
				catergory.setCatergory_name(rs.getString("catergory_name"));
				catergory.setImage(rs.getString("image"));
				catergory.setStatus(rs.getInt("status"));
				list.add(catergory);
				return list;
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void softdelete(CatergoryModel category) {
		String sql="update catergory set status=? where catergory_id=?";

		try {
			new DBConnectMySQL();
			conn=DBConnectMySQL.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, category.getStatus());
			ps.setInt(2, category.getCatergory_id());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
