package jsoft.ads.product;

import jsoft.library.*;
import jsoft.objects.*;
import java.sql.*;

import org.javatuples.Pair;

public interface Product {
	public boolean addProduct(ProductObject item);
	public boolean editProduct(ProductObject item);
	public boolean delProduct(ProductObject item);
	
	public ResultSet getProduct(short id);
	public ResultSet getProducts(ProductObject similar, int at, byte total);
	
	public ResultSet getProducts(ProductObject similar, int at, byte total, PRODUCT_ORDER pro, ORDER o);
	public ResultSet getProducts(ProductObject similar, int at, byte total, Pair<PRODUCT_ORDER, ORDER> order);
}
