package jsoft.ads.product;

import java.util.*;
import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.*;
import org.javatuples.*;

public class ProductControl {

	private ProductModel pm;

	public ProductControl(ConnectionPool cp) {
		this.pm = new ProductModel(cp);
	}

	protected void finallize() throws Throwable {
		this.pm = null;
	}
	
	
	public ConnectionPool getCP() {
		return this.pm.getCP();
	}
	
	public void releaseConnection() {
		this.pm.releaseConnection();
	}
	

	// --------------------------------------------------------------
	public boolean addProduct(ProductObject item) {
		return this.pm.addProduct(item);
	}

	public boolean editProduct(ProductObject item) {
		return this.pm.editProduct(item);
	}

	public boolean delProduct(ProductObject item) {
		return this.pm.delProduct(item);
	}
	// ----------------------------------------------------------------

	public ProductObject getProductObject(short id) {
		return this.pm.getProductObject(id);
	}

	public Pair<String, String> viewProducts(Triplet<ProductObject, Short, Byte> infos,
			Pair<PRODUCT_ORDER, ORDER> order) {
		ArrayList<ProductObject> items = this.pm.getProductObjects(infos.getValue0(), infos.getValue1(),
				infos.getValue2(), order.getValue0(), order.getValue1());

		return ProductLibrary.viewProducts(items);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();

		ProductControl pc = new ProductControl(cp);

		Triplet<ProductObject, Short, Byte> infos = new Triplet<>(null, (short) 1, (byte) 20);
		Pair<PRODUCT_ORDER, ORDER> order = new Pair<PRODUCT_ORDER, ORDER>(PRODUCT_ORDER.NAME, ORDER.DESC);

		Pair<String, String> view = pc.viewProducts(infos, order);
		
		pc.releaseConnection();

		System.out.println(view.getValue0());
	}
}
