package jsoft.ads.article;

import java.sql.*;
import org.javatuples.*;
import jsoft.objects.*;
import jsoft.*;
import jsoft.ads.category.*;
import jsoft.library.*;

public class ArticleImpl extends CategoryImpl implements Article {
	
	public ArticleImpl(ConnectionPool cp) {
		super(cp, "Article");
	}

	@Override
	public boolean addArticle(ArticleObject item) {
		if (this.isExisting(item))
			return false;
		
		String sql = "INSERT INTO tblarticle(";
		sql += "article_title,article_summary,article_content,";
		sql += "article_created_date,article_last_modified,article_image,";
		sql += "article_category_id,article_section_id,";
		sql += "article_visited,article_author_name,";
		sql += "article_enable,article_url_link,article_tag,";
		sql += "article_title_en,article_summary_en,article_content_en,article_tag_en,";
		sql += "article_fee,article_isfee,article_delete,";
		sql += "article_deleted_date,article_restored_date,";
		sql += "article_modified_author_name,article_author_permission,article_source,";
		sql += "article_language,article_focus,article_type,article_forhome) ";
		sql += "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getArticle_title());
			pre.setString(2, item.getArticle_summary());
			pre.setString(3, item.getArticle_content());
			pre.setString(4, item.getArticle_created_date());
			pre.setString(5, item.getArticle_last_modified());
			pre.setString(6, item.getArticle_image());
			pre.setShort(7, item.getArticle_category_id());
			pre.setShort(8, item.getArticle_section_id());
			pre.setShort(9, item.getArticle_visited());
			pre.setString(10, item.getArticle_author_name());
			pre.setBoolean(11, item.isArticle_enable());
			pre.setString(12, item.getArticle_url_link());
			pre.setString(13, item.getArticle_tag());
			pre.setString(14, item.getArticle_title_en());
			pre.setString(15, item.getArticle_summary_en());
			pre.setString(16, item.getArticle_content_en());
			pre.setString(17, item.getArticle_tag_en());
			pre.setInt(18, item.getArticle_fee());
			pre.setBoolean(19, item.isArticle_isfee());
			pre.setBoolean(20, item.isArticle_delete());
			pre.setString(21, item.getArticle_deleted_date());
			pre.setString(22, item.getArticle_restored_date());
			pre.setString(23, item.getArticle_modified_author_name());
			pre.setString(24, item.getArticle_author_permission());
			pre.setString(25, item.getArticle_source());
			pre.setByte(26, item.getArticle_language());
			pre.setBoolean(27, item.isArticle_focus());
			pre.setByte(28, item.getArticle_type());
			pre.setBoolean(29, item.isArticle_forhome());
			
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean isExisting(ArticleObject item) {
		boolean flag = false;
		String sql = "SELECT article_id FROM tblarticle WHERE article_title = '"+item.getArticle_title()+"'";
		
		ResultSet rs = this.gets(sql);
		if (rs != null) {
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
	public boolean editArticle(ArticleObject item) {
		String sql = "UPDATE tblarticle SET ";
		sql += "article_title = ?,article_summary = ?,article_content = ?,";
		sql += "article_last_modified = ?,article_image = ?,";
		sql += "article_category_id = ?,article_section_id = ?,";
		sql += "article_visited = ?,";
		sql += "article_enable = ?,article_url_link = ?,article_tag = ?,";
		sql += "article_title_en = ?,article_summary_en = ?,article_content_en = ?,article_tag_en = ?,";
		sql += "article_fee = ?,article_isfee = ?,article_delete = ?,";
		sql += "article_deleted_date = ?,article_restored_date = ?,";
		sql += "article_author_permission = ?,article_source = ?,";
		sql += "article_language = ?,article_focus = ?,article_type = ?,article_forhome = ? ";
		sql += "WHERE article_id = ?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getArticle_title());
			pre.setString(2, item.getArticle_summary());
			pre.setString(3, item.getArticle_content());
			
			//pre.setString(4, item.getArticle_created_date());
			
			pre.setString(4, item.getArticle_last_modified());
			pre.setString(5, item.getArticle_image());
			pre.setShort(6, item.getArticle_category_id());
			pre.setShort(7, item.getArticle_section_id());
			pre.setShort(8, item.getArticle_visited());
			
			//pre.setString(10, item.getArticle_author_name());
			
			pre.setBoolean(9, item.isArticle_enable());
			pre.setString(10, item.getArticle_url_link());
			pre.setString(11, item.getArticle_tag());
			pre.setString(12, item.getArticle_title_en());
			pre.setString(13, item.getArticle_summary_en());
			pre.setString(14, item.getArticle_content_en());
			pre.setString(15, item.getArticle_tag_en());
			pre.setInt(16, item.getArticle_fee());
			pre.setBoolean(17, item.isArticle_isfee());
			pre.setBoolean(18, item.isArticle_delete());
			pre.setString(19, item.getArticle_deleted_date());
			pre.setString(20, item.getArticle_restored_date());
			
			//pre.setString(23, item.getArticle_modified_author_name());
			
			pre.setString(21, item.getArticle_author_permission());
			pre.setString(22, item.getArticle_source());
			pre.setByte(23, item.getArticle_language());
			pre.setBoolean(24, item.isArticle_focus());
			pre.setByte(25, item.getArticle_type());
			pre.setBoolean(26, item.isArticle_forhome());
			pre.setInt(27, item.getArticle_id());
			
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
	public boolean delArticle(ArticleObject item) {
		
		String sql = "DELETE FROM tblarticle WHERE article_id = ?";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, item.getArticle_id());
			
			return this.del(pre);
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

	@Override
	public ResultSet getArticle(int id) {
		String sql = "SELECT * FROM tblarticle ";
		sql += "LEFT JOIN tblcategory ON article_category_id = category_id ";
		sql += "WHERE article_id = ?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getArticles(ArticleObject similar, int at, byte total) {
//		String sql = "SELECT * FROM tblarticle ";
//		sql += "LEFT JOIN tblcategory ON article_category_id = category_id ";
//		sql += "";
//		sql += "ORDER BY article_title ASC ";
//		sql += "LIMIT "+at+", "+total;
		return this.getArticles(similar, at, total, ARTICLE_ORDER.TITLE, ORDER.ASC);
	}
	
	@Override
	public ResultSet getArticles(ArticleObject similar, int at, byte total, ARTICLE_ORDER aro, ORDER o) {
		String sql = "SELECT * FROM tblarticle ";
		sql += "LEFT JOIN tblcategory ON article_category_id = category_id ";
		sql += "";
		
		switch (aro) {
		case ID:
			sql += "ORDER BY article_id "+o;
			break;
		case TITLE:
			sql += "ORDER BY article_title "+o;
			break;
		case VISITED:
			sql += "ORDER BY article_visited "+o;
			break;
		case CATEGORY: 
			sql += "ORDER BY article_category_id "+o;
			break;
		case SECTION:
			sql += "ORDER BY article_section_id "+o;
		}
		
		sql += " LIMIT "+at+", "+total;
		return this.gets(sql);
	}
	
	@Override
	public ResultSet getArticles(ArticleObject similar, int at, byte total, Pair<ARTICLE_ORDER, ORDER> order) {
		String sql = "SELECT * FROM tblarticle ";
		sql += "LEFT JOIN tblcategory ON article_category_id = category_id ";
		sql += "";
		
		ARTICLE_ORDER aro = order.getValue0();
		ORDER o = order.getValue1();
		
		switch (aro) {
		case ID:
			sql += "ORDER BY article_id "+o;
			break;
		case TITLE:
			sql += "ORDER BY article_title "+o;
			break;
		case VISITED:
			sql += "ORDER BY article_visited "+o;
			break;
		case CATEGORY: 
			sql += "ORDER BY article_category_id "+o;
			break;
		case SECTION:
			sql += "ORDER BY article_section_id "+o;
		}
		
		sql += " LIMIT "+at+", "+total;
		return this.gets(sql);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		
		Article a = new ArticleImpl(cp);
		
		ArticleObject nA = new ArticleObject();
		nA.setArticle_id(209);
		nA.setArticle_title("abc123");
		nA.setArticle_visited((short) 10);
		nA.setArticle_tag("inform");
		nA.setArticle_fee(100000);
		nA.setArticle_author_name("Mr.Leon");
		
		boolean result;
		result = a.delArticle(nA);
		
		if(!result) {
			System.out.println("\n-------------Không thành công---------\n\n");
		}
		
		ResultSet rs = a.getArticles(null, 0, (byte)20);
		
		String row;
		if (rs!=null) {
			try {
				while (rs.next()) {
					row = "\tID: "+rs.getInt("article_id");
					row += "\tTitle: "+rs.getString("article_title");
					row += "\tAuthor: "+rs.getString("article_author_name");
					row += "\tArticle_visited: "+rs.getShort("article_visited");
					row += "\tArticle_tag: "+rs.getString("article_tag");
					row += "\tArticle_fee: "+rs.getInt("article_fee");
					
					System.out.println(row);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
