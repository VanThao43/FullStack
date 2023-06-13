package jsoft.ads.user;

import jsoft.*;
import jsoft.ads.basic.*;
import jsoft.library.*;
import jsoft.objects.*;
import java.sql.*;
import org.javatuples.*;

public interface User extends ShareControl{
	// Nhóm các phương thức - chức năng cập nhật cho modun User
	public boolean addUser(UserObject item);
	public boolean editUser(UserObject item);
	public boolean delUser(UserObject item);
	
	
	// Nhóm các phương thức lấy thông tin
	public ResultSet getUser(int id);
	public ResultSet getUser(String username, String userpass);
	public ResultSet getUsers(UserObject similar, int at, byte total);
	
	public ResultSet getUsers(UserObject similar, int at, byte total, USER_ORDER uso, ORDER o);
	public ResultSet getUsers(UserObject similar, int at, byte total, Pair<USER_ORDER, ORDER> order);
}
