package com.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.usermanagement.bean.Admin;
import com.usermanagement.bean.UserBean;

public class Dao
{
	static Connection con= null;
	static Statement s = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url ="jdbc:mysql://localhost:3306/usermanagement";
	static String user = "root";
	static String pass = "Suraj@123";
	static String match = "select * from admin";
	static String insert = "insert into user (name,email,city) values(?,?,?)";
	static String display = "select * from user";
	static String delete = "delete from user where id = ?";
	static int count = 0;
	private static String selectUser = "select * from user where id = ?";
	private static String update = "update user set name=?,email=?,city=? where id=?";
	public static String doMatch(Admin a)
	{
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			s = con.createStatement();
			rs = s.executeQuery(match);
			while(rs.next())
			{
				String u = rs.getString("username");
				String p = rs.getString("password");
				if(u.equals(a.getUsername()) && p.equals(a.getPassword()))
				{
					return "successful";
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "failed";
		
	}
	public static int insert(UserBean u)
	{
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(insert);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			count =  ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
		
	}
	public static ArrayList<UserBean> display()
	{
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			s = con.createStatement();
			rs = s.executeQuery(display);
			while(rs.next())
			{
				int uid = rs.getInt("id");
				String uname = rs.getString("name");
				String uemail = rs.getString("email");
				String ucity = rs.getString("city");
				UserBean u = new UserBean(uid, uname, uemail, ucity);
				al.add(u);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	public static void delete(int uid)
	{
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(delete);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static UserBean selectUser(int id)
	{
		UserBean u = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(selectUser);
			ps.setInt(1, id);
			rs =ps.executeQuery();
			if(rs.next())
			{
				id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				u = new UserBean(id, name, email, city);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	public static void update(UserBean u)
	{
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(update);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			ps.setInt(4, u.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	 

}
