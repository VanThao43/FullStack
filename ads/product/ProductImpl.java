package jsoft.ads.product;

import java.sql.*;

import org.javatuples.Pair;

import jsoft.*;
import jsoft.ads.basic.*;
import jsoft.library.*;
import jsoft.objects.*;

public class ProductImpl extends BasicImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
	}

	private boolean isExisting(ProductObject item) {
		boolean flag = false;

		String sql = "SELECT product_id FROM tblproduct WHERE product_name = '" + item.getProduct_name() + "'";
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
	public boolean addProduct(ProductObject item) {
		if (isExisting(item))
			return false;
		
		String sql = "INSERT INTO tblproduct (";
		sql += "product_name,product_image,product_price,product_discount_price,";
		sql += "product_enable,product_delete,product_visited,product_total,";
		sql += "product_manager_id,product_intro,product_notes,product_code,";
		sql += "product_created_date,product_modified_date,";
		sql += "product_pc_id,product_pg_id,product_ps_id,";
		sql += "product_is_detail,product_deleted_date,product_deleted_author,";
		sql += "product_promotion_price,product_sold,product_best_seller,";
		sql += "product_promotion,product_price_calc_description,";
		sql += "product_size,product_name_en,product_customer_id,product_perspective_id) ";
		sql += "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getProduct_name());
			pre.setString(2, item.getProduct_image());
			pre.setString(3, item.getProduct_price());
			pre.setString(4, item.getProduct_discount_price());
			pre.setBoolean(5, item.isProduct_enable());
			pre.setBoolean(6, item.isProduct_delete());
			pre.setShort(7, item.getProduct_visited());
			pre.setString(8, item.getProduct_total());
			pre.setInt(9, item.getProduct_manager_id());
			pre.setString(10, item.getProduct_intro());
			pre.setString(11, item.getProduct_notes());
			pre.setString(12, item.getProduct_code());
			pre.setString(13, item.getProduct_created_date());
			pre.setString(14, item.getProduct_modified_date());
			pre.setShort(15, item.getProduct_pc_id());
			pre.setShort(16, item.getProduct_pg_id());
			pre.setShort(17, item.getProduct_ps_id());
			pre.setBoolean(18, item.isProduct_is_detail());
			pre.setString(19, item.getProduct_deleted_date());
			pre.setString(20, item.getProduct_deleted_author());
			pre.setString(21, item.getProduct_promotion_price());
			pre.setString(22, item.getProduct_sold());
			pre.setString(23, item.getProduct_best_seller());
			pre.setString(24, item.getProduct_promotion());
			pre.setString(25, item.getProduct_price_calc_description());
			pre.setShort(26, item.getProduct_size());
			pre.setString(27, item.getProduct_name_en());
			pre.setInt(28, item.getProduct_customer_id());
			pre.setInt(29, item.getProduct_perspective_id());
			
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

	@Override
	public boolean editProduct(ProductObject item) {
		String sql = "UPDATE tblproduct SET ";
		sql += "product_name = ?,product_image = ?,product_price = ?,product_discount_price = ?,";
		sql += "product_enable = ?,product_delete = ?,product_visited = ?,product_total = ?,";
		sql += "product_manager_id = ?,product_intro = ?,product_notes = ?,product_code = ?,";
		sql += "product_modified_date = ?,";
		sql += "product_pc_id = ?,product_pg_id = ?,product_ps_id = ?,";
		sql += "product_is_detail = ?,product_deleted_date = ?,product_deleted_author = ?,";
		sql += "product_promotion_price = ?,product_sold = ?,product_best_seller = ?,";
		sql += "product_promotion = ?,product_price_calc_description = ?,";
		sql += "product_size = ?,product_name_en = ?,product_customer_id = ? ";
		sql += "WHERE product_id = ?";
		
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getProduct_name());
			pre.setString(2, item.getProduct_image());
			pre.setString(3, item.getProduct_price());
			pre.setString(4, item.getProduct_discount_price());
			pre.setBoolean(5, item.isProduct_enable());
			pre.setBoolean(6, item.isProduct_delete());
			pre.setShort(7, item.getProduct_visited());
			pre.setString(8, item.getProduct_total());
			pre.setInt(9, item.getProduct_manager_id());
			pre.setString(10, item.getProduct_intro());
			pre.setString(11, item.getProduct_notes());
			pre.setString(12, item.getProduct_code());
			
			//pre.setString(13, item.getProduct_created_date());
			
			pre.setString(13, item.getProduct_modified_date());
			pre.setShort(14, item.getProduct_pc_id());
			pre.setShort(15, item.getProduct_pg_id());
			pre.setShort(16, item.getProduct_ps_id());
			pre.setBoolean(17, item.isProduct_is_detail());
			pre.setString(18, item.getProduct_deleted_date());
			pre.setString(19, item.getProduct_deleted_author());
			pre.setString(20, item.getProduct_promotion_price());
			pre.setString(21, item.getProduct_sold());
			pre.setString(22, item.getProduct_best_seller());
			pre.setString(23, item.getProduct_promotion());
			pre.setString(24, item.getProduct_price_calc_description());
			pre.setShort(25, item.getProduct_size());
			pre.setString(26, item.getProduct_name_en());
			pre.setInt(27, item.getProduct_customer_id());
			
			//pre.setInt(28, item.getProduct_perspective_id());
			
			pre.setShort(28, item.getProduct_id());
			
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
	public boolean delProduct(ProductObject item) {
		String sql = "DELETE FROM tblproduct WHERE product_id = ?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setShort(1, item.getProduct_id());
			
			return this.del(pre);
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public ResultSet getProduct(short id) {
		String sql = "SELECT * FROM tblproduct WHERE product_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total) {
//		String sql = "SELECT * FROM tblproduct ";
//		sql += " ";
//		sql += "ORDER BY product_name ASC ";
//		sql += "LIMIT " + at + ", " + total;
		return this.getProducts(similar, at, total, PRODUCT_ORDER.NAME, ORDER.ASC);
	}
	
	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total, PRODUCT_ORDER pro, ORDER o) {
		String sql = "SELECT * FROM tblproduct ";
		sql += " ";
		
		switch (pro) {
		case ID:
			sql += "ORDER BY product_id "+o;
			break;
		case NAME:
			sql += "ORDER BY product_name "+o;
			break;
		case MANAGER:
			sql += "ORDER BY product_manager_id "+o;
			break;
		case VISITED:
			sql += "ORDER BY product_visited "+o;
		}
		
		
		
		sql += " LIMIT " + at + ", " + total;
		return this.gets(sql);
	}
	
	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total, Pair<PRODUCT_ORDER, ORDER> order) {
		String sql = "SELECT * FROM tblproduct ";
		sql += " ";
		
		PRODUCT_ORDER pro = order.getValue0();
		ORDER o = order.getValue1();
		
		switch (pro) {
		case ID:
			sql += "ORDER BY product_id "+o;
			break;
		case NAME:
			sql += "ORDER BY product_name "+o;
			break;
		case MANAGER:
			sql += "ORDER BY product_manager_id "+o;
			break;
		case VISITED:
			sql += "ORDER BY product_visited "+o;
		}
		
		
		
		sql += " LIMIT " + at + ", " + total;
		return this.gets(sql);
	}

	public static void main(String[] args) {
		
		ConnectionPool cp = new ConnectionPoolImpl();
		
		Product p = new ProductImpl(cp);
		
		ProductObject pObject = new ProductObject();
		pObject.setProduct_name("admin");
		pObject.setProduct_id((short)1588);
		//pObject.setProduct_price("100.000.");
		pObject.setProduct_visited((short)60);
		
		boolean result;
		result = p.delProduct(pObject);
		
		if(!result) {
			System.out.println("\n---------------------Không thành công--------------------------\n\n");
		}
		
		
		
		ResultSet rs = p.getProducts(null, 0, (byte) 30);

		String row;
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "\tID: " + rs.getShort("product_id");
					row += "\tName: " + rs.getString("product_name");
					row += "\tPrice: " + rs.getString("product_price");
					row += "\tVisited: " + rs.getShort("product_visited");
					row += "\tTotal: " + rs.getString("product_total");

					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
