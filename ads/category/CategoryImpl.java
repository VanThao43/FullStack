package jsoft.ads.category;

import java.sql.*;
import org.javatuples.*;
import jsoft.*;
import jsoft.ads.section.*;
import jsoft.library.*;
import jsoft.objects.*;

public class CategoryImpl extends SectionImpl implements Category {
	
	public CategoryImpl(ConnectionPool cp) {
		super(cp, "Category");
	}
	
	public CategoryImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}

	@Override
	public boolean addCategory(CategoryObject item) {
		
		if (this.isExisting(item))
			return false;
		
		String sql = "INSERT INTO tblcategory(";
		sql += "category_name,";
		sql += "category_section_id,";
		sql += "category_notes,";
		sql += "category_created_date,";
		sql += "category_created_author_id,";
		sql += "category_last_modified,";
		sql += "category_manager_id,";
		sql += "category_enable,";
		sql += "category_delete,";
		sql += "category_image,";
		sql += "category_name_en,";
		sql += "category_language) ";
		sql += "VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getCategory_name());
			pre.setShort(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			pre.setString(4, item.getCategory_created_date());
			pre.setInt(5, item.getCategory_created_author_id());
			pre.setString(6, item.getCategory_last_modified());
			pre.setInt(7, item.getCategory_manager_id());
			pre.setBoolean(8, item.isCategory_enable());
			pre.setBoolean(9, item.isCategory_delete());
			pre.setString(10, item.getCategory_image());
			pre.setString(11, item.getCategory_name_en());
			pre.setByte(12, item.getCategory_language());
			
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean isExisting(CategoryObject item) {
		boolean flag = false;
		
		String sql = "SELECT category_id FROM tblcategory WHERE category_name = '"+item.getCategory_name()+"'";
		
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
	public boolean editCategory(CategoryObject item) {
		String sql = "UPDATE tblcategory SET ";
		sql += "category_name = ?,";
		sql += "category_section_id= ?,";
		sql += "category_notes= ?,";
		sql += "category_last_modified= ?,";
		sql += "category_manager_id= ?,";
		sql += "category_enable= ?,";
		sql += "category_delete= ?,";
		sql += "category_image= ?,";
		sql += "category_name_en= ?,";
		sql += "category_language= ? ";
		sql += "WHERE category_id = ?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getCategory_name());
			pre.setShort(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			
			//pre.setString(4, item.getCategory_created_date());
			//pre.setInt(5, item.getCategory_created_author_id());
			
			pre.setString(4, item.getCategory_last_modified());
			pre.setInt(5, item.getCategory_manager_id());
			pre.setBoolean(6, item.isCategory_enable());
			pre.setBoolean(7, item.isCategory_delete());
			pre.setString(8, item.getCategory_image());
			pre.setString(9, item.getCategory_name_en());
			pre.setByte(10, item.getCategory_language());
			pre.setInt(11, item.getCategory_id());
			
			return this.edit(pre);
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delCategory(CategoryObject item) {
		if (!isEmpty(item))
			return false;
		
		String sql = "DELETE FROM tblcategory WHERE category_id = ?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getCategory_id());
			
			this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	private boolean isEmpty(CategoryObject item) {
		String sql = "SELECT article_id FROM tblarticle WHERE article_category_id = ?";
		
		boolean flag = true;
		
		ResultSet rs = this.get(sql, item.getCategory_id());
		
		if(rs!= null) {
			try {
				if (rs.next()) {
					flag = false;
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
	public ResultSet getCategory(short id) {
		String sql = "SELECT * FROM tblcategory ";
		sql += "LEFT JOIN tblsection ON category_section_id = section_id ";
		sql += "WHERE category_id = ?";
		
		return this.gets(sql);
	}

	@Override
	public ResultSet getCategories(CategoryObject similar, int at, byte total) {
//		String sql = "SELECT * FROM tblcategory ";
//		sql += "LEFT JOIN tblsection ON category_section_id = section_id ";
//		sql += "";
//		sql += "ORDER BY category_name ASC ";
//		sql += "LIMIT "+at+", "+total;
	
		return this.getCategories(similar, at, total, CATE_ORDER.NAME, ORDER.ASC);
	}
	
	@Override
	public ResultSet getCategories(CategoryObject similar, int at, byte total, CATE_ORDER co, ORDER o) {
		String sql = "SELECT * FROM tblcategory ";
		sql += "LEFT JOIN tblsection ON category_section_id = section_id ";
		sql += "";
		
		
		switch (co) {
		case ID:
			sql += "ORDER BY category_id "+o;
			break;
		case NAME:
			sql += "ORDER BY category_name "+o;
			break;
		case AUTHOR:
			sql += "ORDER BY category_created_author_id "+o;						// break cuối cùng được bỏ đi 
																					// vì đằng sau không còn case
		default:
			break;
		}
		
		
		sql += " LIMIT "+at+", "+total;
		
		return this.gets(sql);
	}

	@Override
	public ResultSet getCategories(CategoryObject similar, int at, byte total, Pair<CATE_ORDER, ORDER> order) {
		String sql = "SELECT * FROM tblcategory ";
		sql += "LEFT JOIN tblsection ON category_section_id = section_id ";
		sql += "";
		
		CATE_ORDER co = order.getValue0();
		ORDER o = order.getValue1();
		
		switch (co) {
		case ID:
			sql += "ORDER BY category_id "+o;
			break;
		case NAME:
			sql += "ORDER BY category_name "+o;
			break;
		case AUTHOR:
			sql += "ORDER BY category_created_author_id "+o;						// break cuối cùng được bỏ đi 
																					// vì đằng sau không còn case
		default:
			break;
		}
		
		
		sql += " LIMIT "+at+", "+total;
		
		return this.gets(sql);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		Category c = new CategoryImpl(cp);
		ResultSet rs = c.getCategories(null, 10, (byte)20);
		
		String row;
		if (rs!=null) {
			try {
				while (rs.next()) {
					row = "\tID: "+rs.getString("category_id");
					row += "\tName: "+rs.getString("category_name");
					row += "\tNotes: "+rs.getString("category_notes");
					row += "\tCreated_date: "+rs.getString("category_created_date");
					
					
					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
