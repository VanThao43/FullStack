package jsoft.ads.basic;

import java.sql.*;
import jsoft.*;

public interface Basic extends ShareControl{
	
	//PreparedStatement pre - Câu lệnh thực thi này đã được biên dịch,
	// được truyền dữ liệu đầy đủ.
	
	public boolean add(PreparedStatement pre);
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);
	
	public ResultSet get(String sql, int id);
	public ResultSet get(String sql, String name, String pass);
	public ResultSet gets(String sql);
	public ResultSet[] gets(String[] sql);
	
}
