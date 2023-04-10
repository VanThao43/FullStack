package jsoft.ads.user;

import jsoft.objects.*;
import jsoft.*;
import jsoft.library.ORDER;

import java.sql.*;
import java.util.*;

import org.javatuples.Pair;

public class UserModel {
	
	private User u;
	
	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.u = null;
	}
	
	
	
	//**************************************************************************
	public boolean addUser(UserObject item) {
		return this.u.addUser(item);
	}
	
	public boolean editUser(UserObject item) {
		return this.u.editUser(item);
	}
	
	public boolean delUser(UserObject item) {
		return this.u.delUser(item);
	}
	
	//***************************************************************************
	
	
	
	public UserObject getUserObject(int id) {
		UserObject item = null;
		
		ResultSet rs = this.u.getUser(id);
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_logined(rs.getShort("user_logined"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public UserObject getUserObject(String username, String userpass) {
		UserObject item = null;
		
		ResultSet rs = this.u.getUser(username, userpass);
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_logined(rs.getShort("user_logined"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<UserObject> getUserObjects(UserObject similar, short page, byte total, USER_ORDER uso, ORDER o) {
		
		ArrayList<UserObject> items = new ArrayList<UserObject>();
		
		UserObject item = null;
		
		int at = (page-1)*total;			//1		2	3
		
		ResultSet rs = this.u.getUsers(similar, at, total, uso, o);
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_logined(rs.getShort("user_logined"));
					
					items.add(item);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
	
public ArrayList<UserObject> getUserObjects(UserObject similar, short page, byte total, Pair<USER_ORDER, ORDER> order) {
		
		ArrayList<UserObject> items = new ArrayList<UserObject>();
		
		UserObject item = null;
		
		int at = (page-1)*total;			//1		2	3
		
		ResultSet rs = this.u.getUsers(similar, at, total, order);
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_logined(rs.getShort("user_logined"));
					
					items.add(item);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		UserModel um = new UserModel(cp);
		
		ArrayList<UserObject> items = um.getUserObjects(null, (short)1, (byte)20, USER_ORDER.BIRTHDAY, ORDER.ASC);
		items.forEach(uso -> System.out.println(uso));
	}
}
