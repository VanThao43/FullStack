package jsoft;

import java.sql.*;


/**
 * Giao tiếp / giao diện cung cấp các chức năng làm việc với kết nối (<b>connection</b>)<br>
 * 
 * @author Acer
 *
 */

public interface ConnectionPool {
	// Xin kết nối để làm việc với CSDL
	public Connection getConnection(String objectName) throws SQLException;
	
	// Yêu cầu trả lại kết nối cho các đối tượng khác dùng
	public void releaseConnection(Connection con, String objectName) throws SQLException;
	
}
