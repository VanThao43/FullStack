package jsoft.ads.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;

import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;

public class ArticleModel {
	private Article a;
	
	public ArticleModel(ConnectionPool cp) {
		this.a = new ArticleImpl(cp);
	}
	
	
	//--------------------------------------------------------
	public boolean addArticleObject(ArticleObject item) {
		return this.a.addArticle(item);
	}
	
	public boolean editArticleObject(ArticleObject item) {
		return this.a.editArticle(item);
	}
	
	public boolean delArticleObject(ArticleObject item) {
		return this.a.delArticle(item);
	}
	//--------------------------------------------------------
	
	
	public ArticleObject getArticleObject(int id) {
		ArticleObject item = null;
		
		ResultSet rs = this.a.getArticle(id);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					item.setArticle_category_id(rs.getShort("article_category_id"));
					
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return item;
	}
	
	
	public ArrayList<ArticleObject> getArticleObjects(ArticleObject similar, short page, byte total, ARTICLE_ORDER aro, ORDER o) {
		ArrayList<ArticleObject> items = new ArrayList<ArticleObject>();
		
		ArticleObject item = null;
		
		int at = (page-1)*total;
		
		ResultSet rs = this.a.getArticles(similar, at, total, aro, o);
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					item.setArticle_category_id(rs.getShort("article_category_id"));
					
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					
					items.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return items;
	}
	
	public ArrayList<ArticleObject> getArticleObjects(ArticleObject similar, short page, byte total, Pair<ARTICLE_ORDER, ORDER> order) {
		ArrayList<ArticleObject> items = new ArrayList<ArticleObject>();
		
		ArticleObject item = null;
		
		int at = (page-1)*total;
		
		ResultSet rs = this.a.getArticles(similar, at, total, order);
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					item.setArticle_category_id(rs.getShort("article_category_id"));
					
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					
					items.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return items;
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		ArticleModel am = new ArticleModel(cp);
		
		ArrayList<ArticleObject> items = am.getArticleObjects(null, (short)1, (byte)20, ARTICLE_ORDER.VISITED, ORDER.ASC);
		items.forEach(aro -> System.out.println(aro));
	}
}
