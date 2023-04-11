package jsoft;

import java.sql.*;
import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {

	// Trình điều khiển làm việc với CSDL
	private String driver;

	// Đường dẫn thực thi của CSDL
	private String url;

	// Tài khoản kết nối vào MySQL
	private String userName;
	private String userPass;
	
	//Đối tượng lưu trữ kết nối tới CSDL
	private Stack<Connection> pool;

	public ConnectionPoolImpl() {
		// Xác định trình điều khiển
		this.driver = "com.mysql.jdbc.Driver";

		// Xác định đường dẫn thực thi của MySQL
		this.url = "jdbc:mysql://localhost:3306/jp210301_data";

		// Xác định tài khoản làm việc với CSDL
		this.userName = "root";
		this.userPass = "123456";
		
		// Nạp trình điều khiển
		this.loadDriver();
		
		//Khởi tạo bộ nhớ cho đối tượng lưu trữ kết nối
		this.pool = new Stack<Connection>();
	}

	
	private void loadDriver() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// Xin kết nối để làm việc với CSDL
		if (this.pool.isEmpty()) {
			// Khởi tạo kết nối mới
			System.out.print(objectName + " have created a new Connection.");
			return DriverManager.getConnection(this.url, this.userName, this.userPass);
		}
		else {
			// Lấy kết nối đã tồn tại
			System.out.print(objectName + " have popped the Connection.");
			return this.pool.pop();
		}
		
	}

	
	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// Yêu cầu trả lại kết nối cho các đối tượng khác dùng
		System.out.print(objectName + " have pushed the Connection.");
		this.pool.push(con);
	}
	
	protected void finalize() throws Throwable{
		this.pool.clear();
		this.pool = null;
		System.gc();
	}

}
