package jsoft.ads.basic;

import java.sql.*;
import jsoft.*;

public class BasicImpl implements Basic {
	// Bộ quản lý kết nối của riêng Basic
	private ConnectionPool cp;

	// Kết nối được Basic sử dụng để làm việc với CSDL
	protected Connection con;						//Protected cho phép các lớp trong 1 package truy cập

	// Tên đối tượng làm việc với Basic
	private String objectName;

	public BasicImpl(ConnectionPool cp, String objectName) {
		// Xác định đối tượng làm việc
		this.objectName = objectName;

		// Xác định bộ quản lý kết nối cho Basic
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection(this.objectName);

			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean exe(PreparedStatement pre) {
		if (pre != null) {

			// Thực thi câu lệnh
			try {
				int results = pre.executeUpdate();

				// Kiểm tra kết quả
				if (results == 0) {
					this.con.rollback();
					return false;
				}

				// Xác nhận thực thi sau cùng
				this.con.commit();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();

				// Trở lại vùng an toàn của kết nối
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				pre = null;
			}
		}

		return false;
	}

	@Override
	public boolean add(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean edit(PreparedStatement pre) {
		return this.exe(pre);
	}

	@Override
	public boolean del(PreparedStatement pre) {
		return this.exe(pre);
	}

	@Override
	public ResultSet get(String sql, int id) {
		
		//Biên dịch câu lệnh sql
		try {						// 2
			PreparedStatement pre = this.con.prepareStatement(sql);			// 1
			
			if (id>0) {
				pre.setInt(1, id);						// 3
			}
			
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();										// 4
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public ResultSet get(String sql, String name, String pass) {
		
		// Đăng nhập vào hệ thống
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, pass);
			
			return pre.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ResultSet gets(String sql) {
		return this.get(sql, 0);
	}

	@Override
	public ResultSet[] gets(String[] sql) {
		
		ResultSet[] rs = new ResultSet[sql.length];
		for (int i = 0; i<sql.length; i++) {
			rs[i] = this.get(sql[i], 0);
		}
		return rs;
	}

	@Override
	public ConnectionPool getCP() {
		
		return this.cp;
	}

	@Override
	public void releaseConnection() {
		try {
			this.cp.releaseConnection(this.con, this.objectName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
