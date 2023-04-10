package jsoft.ads.user;

import java.sql.*;

import org.javatuples.Pair;

import jsoft.objects.*;

import jsoft.ads.basic.*;
import jsoft.library.ORDER;
import jsoft.*;

public class UserImpl extends BasicImpl implements User {
	
	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	@Override
	public boolean addUser(UserObject item) {
		
		if (this.isExisting(item))
			return false;
		
		String sql = "INSERT INTO tbluser (";
		sql += "user_name,user_pass,user_fullname,user_birthday,";
		sql += "user_mobilephone,user_homephone,user_officephone,";
		sql += "user_email,user_address,user_jobarea,user_job,";
		sql += "user_position,user_applyyear,user_permission,";
		sql += "user_notes,user_roles,user_logined,";
		sql += "user_created_date,user_last_modified,user_last_logined,";
		sql += "user_parent_id,user_actions) ";
		sql += "VALUE(?,md5(?),md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setShort(17, item.getUser_logined());
			pre.setString(18, item.getUser_created_date());
			pre.setString(19, item.getUser_last_modified());
			pre.setString(20, item.getUser_last_logined());
			pre.setInt(21, item.getUser_parent_id());
			pre.setByte(22, item.getUser_actions());
			
			
			return this.add(pre);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}
	
	private boolean isExisting(UserObject item) {
		boolean flag = false;
		String sql = "SELECT user_id FROM tbluser WHERE user_name = '"+item.getUser_name()+"'";
		
		ResultSet rs = this.gets(sql);
		if (rs!=null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public boolean editUser(UserObject item) {
		String sql = "UPDATE tbluser SET ";
		sql += "user_pass = md5(?),user_fullname=md5(?),user_birthday=?,";
		sql += "user_mobilephone=?,user_homephone=?,user_officephone=?,";
		sql += "user_email=?,user_address=?,user_jobarea=?,user_job=?,";
		sql += "user_position=?,user_applyyear=?,user_permission=?,";
		sql += "user_notes=?,user_roles=?,";
		sql += "user_last_modified=?,user_last_logined=?,";
		sql += "user_actions=? ";
		sql += "WHERE user_id = ?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getUser_pass());
			pre.setString(2, item.getUser_fullname());
			pre.setString(3, item.getUser_birthday());
			pre.setString(4, item.getUser_mobilephone());
			pre.setString(5, item.getUser_homephone());
			pre.setString(6, item.getUser_officephone());
			pre.setString(7, item.getUser_email());
			pre.setString(8, item.getUser_address());
			pre.setString(9, item.getUser_jobarea());
			pre.setString(10, item.getUser_job());
			pre.setString(11, item.getUser_position());
			pre.setShort(12, item.getUser_applyyear());
			pre.setByte(13, item.getUser_permission());
			pre.setString(14, item.getUser_notes());
			pre.setString(15, item.getUser_roles());
			
			
			pre.setString(16, item.getUser_last_modified());
			pre.setString(17, item.getUser_last_logined());
			
			pre.setByte(18, item.getUser_actions());
			pre.setInt(19, item.getUser_id());
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delUser(UserObject item) {
		
		if (!this.isEmpty(item))
			return false;
		
		String sql = "DELETE FROM tbluser WHRE user_id = ?";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, item.getUser_id());
			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}
	
	
	private boolean isEmpty(UserObject item) {
		boolean flag = true;
		String sql1 = "SELECT user_id FROM tbluser WHERE user_parent_id = ?";
		String sql2 = "SELECT article_id FROM tblarticle WHERE article_author_name ='"+item.getUser_name()+"'";
		String sql3 = "SELECT product_id FROM tblproduct WHERE product_manager_id = ?";
		
		ResultSet rs1 = this.get(sql1, item.getUser_id());
		ResultSet rs2 = this.gets(sql1);
		ResultSet rs3 = this.get(sql3, item.getUser_id());
		
		if (rs1!=null || rs2!=null || rs3!=null) {
			try {
				if (rs1.next() || rs2.next() || rs3.next()) {
					flag = false;
				}
				rs1.close();
				rs2.close();
				rs3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public ResultSet getUser(int id) {
		String sql = "SELECT * FROM tbluser WHERE user_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		String sql = "SELECT * FROM tbluser WHERE (user_name=?) AND (user_pass=md5(?))";
		return this.get(sql, username, userpass);
	}

	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total) {
//		String sql = "SELECT * FROM tbluser ";
//		sql += " ";
//		sql += "ORDER BY user_name ASC ";
//		sql += "LIMIT "+at+", " + total;
				
		return this.getUsers(similar, at, total, USER_ORDER.NAME, ORDER.ASC);
	}
	
	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total, USER_ORDER uso, ORDER o) {
		String sql = "SELECT * FROM tbluser ";
		sql += " ";
		
		
		switch (uso) {
		case ID:
			sql += "ORDER BY user_id"+o;
			break;
		case NAME:
			sql += "ORDER BY user_name "+o;
			break;
		case FULLNAME:
			sql += "ORDER BY user_fullname "+o;
			break;
		case BIRTHDAY:
			sql += "ORDER BY user_birthday "+o;
		}
		
		
		sql += " LIMIT "+at+", " + total;
				
		return this.gets(sql);
	}
	
	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total, Pair<USER_ORDER, ORDER> order) {
		String sql = "SELECT * FROM tbluser ";
		sql += " ";
		
		USER_ORDER uso = order.getValue0();
		ORDER o = order.getValue1();
		
		switch (uso) {
		case ID:
			sql += "ORDER BY user_id"+o;
			break;
		case NAME:
			sql += "ORDER BY user_name "+o;
			break;
		case FULLNAME:
			sql += "ORDER BY user_fullname "+o;
			break;
		case BIRTHDAY:
			sql += "ORDER BY user_birthday "+o;
		}
		
		
		sql += " LIMIT "+at+", " + total;
				
		return this.gets(sql);
	}
	
	public static void main(String[] args) {
		// Khởi tạo bộ quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();
		
		// Khởi tạo đối tượng thực thi chức năng mức Interface
		User u = new UserImpl(cp);
		
		
		
		
		
		//Tạo đối tượng lưu trữ thông tin
		UserObject nUser = new UserObject();
		nUser.setUser_id(54);
		nUser.setUser_name("admin1234");
		nUser.setUser_pass("123456");
		nUser.setUser_fullname("admin123@");
		nUser.setUser_email("admin@gmail.com");
		nUser.setUser_created_date("22/03/2023");
		nUser.setUser_parent_id(20);
		
		boolean result;
		
		// Thêm mới
		result = u.editUser(nUser);
		
		if(!result) {
			System.out.println("\n-------------Không thành công---------\n\n");
		}
		
		
		
		// Lấy danh sách bản ghi Người sử dụng
		ResultSet rs = u.getUsers(null, 0, (byte)20);
		
		//Duyệt và hiển thị những bản ghi trên màn hình ảo
		String row;
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "\tID: "+rs.getInt("user_id");
					row += "\tname: "+rs.getString("user_name");
					row += "\tFullName: "+rs.getString("user_fullname");
					row += "\t\t\t\t\tPass: "+rs.getString("user_pass");
					row += "\tPhone: "+rs.getString("user_homephone");
					
					System.out.println(row);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
