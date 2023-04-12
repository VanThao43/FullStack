package jsoft.ads.section;

import java.sql.*;
import java.util.*;
import org.javatuples.*;
import jsoft.*;
import jsoft.library.*;
import jsoft.objects.*;

public class SectionModel {
	
	private Section s;
	
	public SectionModel(ConnectionPool cp) {
		this.s = new SectionImpl(cp);
	}
	
	
	protected void finallize() throws Throwable{
		this.s = null;
	}
	
	//-----------------------------------------------------------
	public boolean addSection(SectionObject item) {
		return this.s.addSection(item);
	}
	
	public boolean editSection(SectionObject item) {
		return this.s.editSection(item);
	}
	
	public boolean delSection(SectionObject item) {
		return this.s.delSection(item);
	}
	//--------------------------------------------------------------
	
	
	
	public SectionObject getSectionObject(short id) {
		SectionObject item = null;
		
		ResultSet rs = this.s.getSection(id);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_created_author_id(rs.getInt("section_created_author_id"));
					item.setSection_language(rs.getByte("section_language"));
					item.setSection_manager_id(rs.getInt("section_manager_id"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_name_en(rs.getString("section_name_en"));
					item.setSection_notes(rs.getString("section_notes"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return item;
	}
	
	public ArrayList<SectionObject> getSectionObjects(SectionObject similar, short page, byte total, SECTION_ORDER so, ORDER o) {
		ArrayList<SectionObject> items = new ArrayList<SectionObject>();
		
		SectionObject item = null;
		
		int at = (page-1)*total;
		
		ResultSet rs = this.s.getSections(similar, at, total, so, o);
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_created_author_id(rs.getInt("section_created_author_id"));
					item.setSection_language(rs.getByte("section_language"));
					item.setSection_manager_id(rs.getInt("section_manager_id"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_name_en(rs.getString("section_name_en"));
					item.setSection_notes(rs.getString("section_notes"));
					
					items.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return items;
	}
	
	public ArrayList<SectionObject> getSectionObjects(SectionObject similar, short page, byte total, Pair<SECTION_ORDER, ORDER> order) {
		ArrayList<SectionObject> items = new ArrayList<SectionObject>();
		
		SectionObject item = null;
		
		int at = (page-1)*total;
		
		ResultSet rs = this.s.getSections(similar, at, total, order);
		
		if (rs!=null) {
			try {
				while (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_created_author_id(rs.getInt("section_created_author_id"));
					item.setSection_language(rs.getByte("section_language"));
					item.setSection_manager_id(rs.getInt("section_manager_id"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_name_en(rs.getString("section_name_en"));
					item.setSection_notes(rs.getString("section_notes"));
					
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
		
		SectionModel sm = new SectionModel(cp);
		
		ArrayList<SectionObject> items = sm.getSectionObjects(null, (short)1, (byte)20, SECTION_ORDER.ID, ORDER.DESC);
		items.forEach(so -> System.out.println(so));
	}
}
