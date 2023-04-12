package jsoft.ads.category;

import java.sql.*;
import java.util.*;
import org.javatuples.*;
import jsoft.*;
import jsoft.library.*;
import jsoft.objects.*;

public class CategoryModel {
	
	private Category c;
	
	public CategoryModel(ConnectionPool cp) {
		this.c = new CategoryImpl(cp);
	}
	
	
	protected void finallize() throws Throwable{
		this.c = null;
	}
	
	//-------------------------------------------------------------
	public boolean addCategoryObject(CategoryObject item) {
		return this.c.addCategory(item);
	}
	
	public boolean editCategoryObject(CategoryObject item) {
		return this.c.editCategory(item);
	}
	
	public boolean delCategoryObject(CategoryObject item) {
		return this.c.delCategory(item);
	}
	//--------------------------------------------------------------
	
	
	
	public CategoryObject getCategoryObject(short id) {
		CategoryObject item = null;
		
		ResultSet rs = this.c.getCategory(id);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_language(rs.getByte("category_language"));
					item.setCategory_manager_id(rs.getInt("category_manager_id"));
					item.setCategory_notes(rs.getString("category_notes"));
					item.setCategory_section_id(rs.getShort("category_section_id"));
					
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return item;
	}
	
	public ArrayList<CategoryObject> getCategoryObjects(CategoryObject similar, short page, byte total, CATE_ORDER co, ORDER o) {
		ArrayList<CategoryObject> items = new ArrayList<CategoryObject>();

		CategoryObject item = null;
		
		int at = (page-1)*total;
		ResultSet rs = this.c.getCategories(similar, at, total, co, o);
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_language(rs.getByte("category_language"));
					item.setCategory_manager_id(rs.getInt("category_manager_id"));
					item.setCategory_notes(rs.getString("category_notes"));
					item.setCategory_section_id(rs.getShort("category_section_id"));
					
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					
					items.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return items;
	}
	
	public ArrayList<CategoryObject> getCategoryObjects(CategoryObject similar, short page, byte total, Pair<CATE_ORDER, ORDER> order) {
		ArrayList<CategoryObject> items = new ArrayList<CategoryObject>();

		CategoryObject item = null;
		
		int at = (page-1)*total;
		ResultSet rs = this.c.getCategories(similar, at, total, order);
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_language(rs.getByte("category_language"));
					item.setCategory_manager_id(rs.getInt("category_manager_id"));
					item.setCategory_notes(rs.getString("category_notes"));
					item.setCategory_section_id(rs.getShort("category_section_id"));
					
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					
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
		
		// Tạo đối tượng thực thi chức năng mức model
		CategoryModel cm = new CategoryModel(cp);
		
		// Lấy tập đối tượng
		ArrayList<CategoryObject> items = cm.getCategoryObjects(null, (short)1, (byte)20, CATE_ORDER.ID, ORDER.DESC);
		
		items.forEach(cate -> System.out.println(cate));
		
	}
}
