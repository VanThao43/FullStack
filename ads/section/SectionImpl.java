package jsoft.ads.section;

import java.sql.*;

import org.javatuples.Pair;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.*;

public class SectionImpl extends BasicImpl implements Section {
	
	public SectionImpl(ConnectionPool con) {
		super(con, "Section");
	}

	public SectionImpl(ConnectionPool con, String objectName) {
		super(con, objectName);
	}
	
	@Override
	public boolean addSection(SectionObject item) {
		if (this.isExisting(item))
			return false;
		
		String sql = "INSERT INTO tblsection (";
		sql += "section_name,";
		sql += "section_notes,section_created_date,";
		sql += "section_manager_id,section_enable,section_delete,";
		sql += "section_last_modified,section_created_author_id,";
		sql += "section_name_en,section_language) ";
		sql += "VALUE (?,?,?,?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			pre.setString(3, item.getSection_created_date());
			pre.setInt(4, item.getSection_manager_id());
			pre.setBoolean(5, item.isSection_enable());
			pre.setBoolean(6, item.isSection_delete());
			pre.setString(7, item.getSection_last_modified());
			pre.setInt(8, item.getSection_created_author_id());
			pre.setString(9, item.getSection_name_en());
			pre.setByte(10, item.getSection_language());
			
			return this.add(pre);
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
	
	
	private boolean isExisting(SectionObject item) {
		boolean flag = false;
		
		String sql = "SELECT section_id FROM tblsection WHERE section_name = '"+item.getSection_name()+"'";
		ResultSet rs = this.gets(sql);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public boolean editSection(SectionObject item) {
		String sql = "UPDATE tblsection SET ";
		sql += "section_name = ?,";
		sql += "section_notes = ?,";
		sql += "section_manager_id = ?,section_enable = ?,section_delete = ?,";
		sql += "section_last_modified = ?,";
		sql += "section_name_en = ?,section_language = ? ";
		sql += "WHERE section_id = ?";
		
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			
			//pre.setString(3, item.getSection_created_date());
			
			pre.setInt(3, item.getSection_manager_id());
			pre.setBoolean(4, item.isSection_enable());
			pre.setBoolean(5, item.isSection_delete());
			pre.setString(6, item.getSection_last_modified());
			
			//pre.setInt(8, item.getSection_created_author_id());
			
			pre.setString(7, item.getSection_name_en());
			
			pre.setByte(8, item.getSection_language());
			pre.setInt(9, item.getSection_id());
			
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
	public boolean delSection(SectionObject item) {
		if(!isEmpty(item))
			return false;
		
		String sql = "DELETE FROM tblsection WHERE section_id = ?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setShort(1, item.getSection_id());
			
			return this.del(pre);
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
	
	private boolean isEmpty(SectionObject item) {
		String sql1= "SELECT category_id FROM tblcategory WHERE category_section_id = ?";
		String sql2 = "SELECT article_id FROM tblarticle WHERE article_section_id = ?";
		
		
		ResultSet rs1 = this.get(sql1, item.getSection_id());
		ResultSet rs2 = this.get(sql2, item.getSection_id());
		
		boolean flag = true;
		
		if (rs1!=null || rs2!= null) {
			try {
				if(rs1.next() || rs2.next()) {
					flag = false;
				}
				rs1.close();
				rs2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public ResultSet getSection(short id) {
		String sql = "SELECT * FROM tblsection section_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getSections(SectionObject similar, int at, byte total) {
//		String sql = "SELECT * FROM tblsection ";
//		sql += " ";
//		sql += "ORDER BY section_name ASC ";
//		sql += "LIMIT "+at +", "+total;
		return this.getSections(similar, at, total, SECTION_ORDER.NAME, ORDER.ASC);
	}
	
	@Override
	public ResultSet getSections(SectionObject similar, int at, byte total, SECTION_ORDER so, ORDER o) {
		String sql = "SELECT * FROM tblsection ";
		sql += " ";
		
		
		switch (so) {
		case ID:
			sql += "ORDER BY section_id "+o;
			break;
		case NAME:
			sql += "ORDER BY section_name "+o;
			break;
		case AUTHOR:
			sql += "ORDER BY section_created_author_id "+o;
			break;
		case MANAGER:
			sql += "ORDER BY section_manager_id "+o;
		}
		
		
		sql += " LIMIT "+at +", "+total;
		return this.gets(sql);
	}
	
	@Override
	public ResultSet getSections(SectionObject similar, int at, byte total, Pair<SECTION_ORDER, ORDER> order) {
		String sql = "SELECT * FROM tblsection ";
		sql += " ";
		
		SECTION_ORDER so = order.getValue0();
		ORDER o = order.getValue1();
		
		switch (so) {
		case ID:
			sql += "ORDER BY section_id "+o;
			break;
		case NAME:
			sql += "ORDER BY section_name "+o;
			break;
		case AUTHOR:
			sql += "ORDER BY section_created_author_id "+o;
			break;
		case MANAGER:
			sql += "ORDER BY section_manager_id "+o;
		}
		
		
		sql += " LIMIT "+at +", "+total;
		return this.gets(sql);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		Section s = new SectionImpl(cp);
		
		SectionObject sObject = new SectionObject();
		sObject.setSection_name("admin");
		sObject.setSection_notes("abc1345");
		sObject.setSection_id((short)15);
		sObject.setSection_manager_id(30);
		
		boolean result;
		result = s.editSection(sObject);
		if (!result) {
			System.out.println("\n--------------------------Không thành công-----------------------\n\n");
		}
		
		ResultSet rs = s.getSections(null, 0, (byte)20);	
		String row;
		if (rs!=null) {
			try {
				while (rs.next()) {
					row = "\tID: "+rs.getInt("section_id");
					row += "\tname: "+rs.getString("section_name");
					row += "\tsection_created_date: " +rs.getString("section_created_date");
					row += "\tManager ID: "+rs.getInt("section_manager_id");
					row += "\tNotes: "+rs.getString("section_notes");
					
					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
