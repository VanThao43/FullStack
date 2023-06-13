package jsoft.ads.category;

import jsoft.ShareControl;
import jsoft.library.*;
import jsoft.objects.*;
import java.sql.*;
import org.javatuples.*;

public interface Category extends ShareControl{
	public boolean addCategory(CategoryObject item);
	public boolean editCategory(CategoryObject item);
	public boolean delCategory(CategoryObject item);
	
	public ResultSet getCategory(short id);
	public ResultSet getCategories(CategoryObject similar, int at, byte total);
	
	
	// 03/04/2023
	public ResultSet getCategories(CategoryObject similar, int at, byte total, CATE_ORDER co, ORDER o);
	public ResultSet getCategories(CategoryObject similar, int at, byte total, Pair<CATE_ORDER, ORDER> order);
}
