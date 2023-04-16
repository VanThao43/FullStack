package jsoft.ads.category;

import java.util.*;
import jsoft.*;
import jsoft.objects.*;
import org.javatuples.*;

public class CategoryControl {

	private CategoryModel cm;

	public CategoryControl(ConnectionPool cp) {
		this.cm = new CategoryModel(cp);
	}
	
	protected void finallize() throws Throwable{
		this.cm = null;
	}

	
	// -------------------------------------------------------------
	public boolean addCategory(CategoryObject item) {
		return this.cm.addCategory(item);
	}

	public boolean editCategory(CategoryObject item) {
		return this.cm.editCategory(item);
	}

	public boolean delCategory(CategoryObject item) {
		return this.cm.delCategory(item);
	}
	// --------------------------------------------------------------
	
	
	
	// --------------------------------------------------------------
	public CategoryObject getCategoryObject(short id) {
		return this.cm.getCategoryObject(id);
	}
	// --------------------------------------------------------------
	
	
	
	public Pair<String, String> viewCategories(Triplet<CategoryObject, Short, Byte> infos){
		ArrayList<CategoryObject> items = this.cm.getCategoryObjects(infos.getValue0(), infos.getValue1(), infos.getValue2());
		
		return CategoryLibrary.viewCategories(items);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		CategoryControl c = new CategoryControl(cp);
		
		Triplet<CategoryObject, Short, Byte> infos = new Triplet<CategoryObject, Short, Byte>(null, (short)1, (byte)20);
		
		Pair<String, String> view = c.viewCategories(infos);
		
		System.out.println(view.getValue0());
	}
}
