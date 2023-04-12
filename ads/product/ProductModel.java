package jsoft.ads.product;

import java.sql.*;
import java.util.*;

import org.javatuples.Pair;

import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.*;

public class ProductModel {
	
	private Product p;
	
	public ProductModel(ConnectionPool cp) {
		this.p = new ProductImpl(cp);
	}
	
	protected void finallize() throws Throwable{
		this.p = null;
	}
	
	
	//--------------------------------------------------------------
	public boolean addProduct(ProductObject item) {
		return this.p.addProduct(item);
	}
	
	public boolean editProduct(ProductObject item) {
		return this.p.editProduct(item);
	}
	
	public boolean delProduct(ProductObject item) {
		return this.p.delProduct(item);
	}
	//----------------------------------------------------------------
	
	
	
	public ProductObject getProductObject(short id) {
		ProductObject item = null;
		
		ResultSet rs = this.p.getProduct(id);
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getShort("product_id"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_created_date(rs.getString("product_created_date"));
					item.setProduct_customer_id(rs.getInt("product_customer_id"));
					item.setProduct_manager_id(rs.getInt("product_manager_id"));
					item.setProduct_notes(rs.getString("product_notes"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return item;
	}
	
	
	public ArrayList<ProductObject> getProductObjects(ProductObject similar, short page, byte total, PRODUCT_ORDER pro, ORDER o){
		ArrayList<ProductObject> items = new ArrayList<ProductObject>();
		
		ProductObject item = null;
		
		int at = (page-1)*total;
		ResultSet rs = this.p.getProducts(similar, at, total, pro, o);
		
		
		if (rs!=null) {
			try {
				while(rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getShort("product_id"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_created_date(rs.getString("product_created_date"));
					item.setProduct_customer_id(rs.getInt("product_customer_id"));
					item.setProduct_manager_id(rs.getInt("product_manager_id"));
					item.setProduct_notes(rs.getString("product_notes"));
					
					items.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return items;
	}
	
	public ArrayList<ProductObject> getProductObjects(ProductObject similar, short page, byte total, Pair<PRODUCT_ORDER, ORDER> order){
		ArrayList<ProductObject> items = new ArrayList<ProductObject>();
		
		ProductObject item = null;
		
		int at = (page-1)*total;
		ResultSet rs = this.p.getProducts(similar, at, total, order);
		
		
		if (rs!=null) {
			try {
				while(rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getShort("product_id"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_created_date(rs.getString("product_created_date"));
					item.setProduct_customer_id(rs.getInt("product_customer_id"));
					item.setProduct_manager_id(rs.getInt("product_manager_id"));
					item.setProduct_notes(rs.getString("product_notes"));
					
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
		
		ProductModel pm = new ProductModel(cp);
		
		ArrayList<ProductObject> items = pm.getProductObjects(null, (short)1, (byte)20, PRODUCT_ORDER.ID, ORDER.DESC);
		items.forEach(pro -> System.out.println(pro));
	}
}
