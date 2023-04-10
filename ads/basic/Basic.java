package jsoft.ads.basic;

import java.sql.*;
import jsoft.*;

public interface Basic {
	
	//PreparedStatement pre - Câu lệnh thực thi này đã được biên dịch,
	// được truyền dữ liệu đầy đủ.
	
	public boolean add(PreparedStatement pre);
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);
	
	public ResultSet get(String sql, int id);
	public ResultSet get(String sql, String name, String pass);
	public ResultSet gets(String sql);
	public ResultSet[] gets(String[] sql);
	
	
	// Phương thức chia sẻ bộ quản lý kết nối giữa các Basic với nhau
	public ConnectionPool getCP();
	
	//Phương thức yêu cầu các đối tượng phải trả lại kết nối khi xong
	public void releaseConnection();
}
