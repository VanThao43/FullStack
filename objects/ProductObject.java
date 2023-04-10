package jsoft.objects;

public class ProductObject {
	public short product_id;
	public String product_name;
	public String product_image;
	public String product_price;
	public String product_discount_price;
	public boolean product_enable;
	public boolean product_delete;
	public short product_visited;
	public String product_total;
	public int product_manager_id;
	public String product_intro;
	public String product_notes;
	public String product_code;
	public String product_created_date;
	public String product_modified_date;
	public short product_pc_id;
	public short product_pg_id;
	public short product_ps_id;
	public boolean product_is_detail;
	public String product_deleted_date;
	public String product_deleted_author;
	public String product_promotion_price;
	public String product_sold;
	public String product_best_seller;
	public String product_promotion;
	public String product_price_calc_description;
	public short product_size;
	public String product_name_en;
	public int product_customer_id;
	public int product_perspective_id;
	
	public ProductObject() {
		
	}

	public short getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public String getProduct_price() {
		return product_price;
	}

	public String getProduct_discount_price() {
		return product_discount_price;
	}

	public boolean isProduct_enable() {
		return product_enable;
	}

	public boolean isProduct_delete() {
		return product_delete;
	}

	public short getProduct_visited() {
		return product_visited;
	}

	public String getProduct_total() {
		return product_total;
	}

	public int getProduct_manager_id() {
		return product_manager_id;
	}

	public String getProduct_intro() {
		return product_intro;
	}

	public String getProduct_notes() {
		return product_notes;
	}

	public String getProduct_code() {
		return product_code;
	}

	public String getProduct_created_date() {
		return product_created_date;
	}

	public String getProduct_modified_date() {
		return product_modified_date;
	}

	public short getProduct_pc_id() {
		return product_pc_id;
	}

	public short getProduct_pg_id() {
		return product_pg_id;
	}

	public short getProduct_ps_id() {
		return product_ps_id;
	}

	public boolean isProduct_is_detail() {
		return product_is_detail;
	}

	public String getProduct_deleted_date() {
		return product_deleted_date;
	}

	public String getProduct_deleted_author() {
		return product_deleted_author;
	}

	public String getProduct_promotion_price() {
		return product_promotion_price;
	}

	public String getProduct_sold() {
		return product_sold;
	}

	public String getProduct_best_seller() {
		return product_best_seller;
	}

	public String getProduct_promotion() {
		return product_promotion;
	}

	public String getProduct_price_calc_description() {
		return product_price_calc_description;
	}

	public short getProduct_size() {
		return product_size;
	}

	public String getProduct_name_en() {
		return product_name_en;
	}

	public int getProduct_customer_id() {
		return product_customer_id;
	}

	public int getProduct_perspective_id() {
		return product_perspective_id;
	}

	public void setProduct_id(short product_id) {
		this.product_id = product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public void setProduct_discount_price(String product_discount_price) {
		this.product_discount_price = product_discount_price;
	}

	public void setProduct_enable(boolean product_enable) {
		this.product_enable = product_enable;
	}

	public void setProduct_delete(boolean product_delete) {
		this.product_delete = product_delete;
	}

	public void setProduct_visited(short product_visited) {
		this.product_visited = product_visited;
	}

	public void setProduct_total(String product_total) {
		this.product_total = product_total;
	}

	public void setProduct_manager_id(int product_manager_id) {
		this.product_manager_id = product_manager_id;
	}

	public void setProduct_intro(String product_intro) {
		this.product_intro = product_intro;
	}

	public void setProduct_notes(String product_notes) {
		this.product_notes = product_notes;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public void setProduct_created_date(String product_created_date) {
		this.product_created_date = product_created_date;
	}

	public void setProduct_modified_date(String product_modified_date) {
		this.product_modified_date = product_modified_date;
	}

	public void setProduct_pc_id(short product_pc_id) {
		this.product_pc_id = product_pc_id;
	}

	public void setProduct_pg_id(short product_pg_id) {
		this.product_pg_id = product_pg_id;
	}

	public void setProduct_ps_id(short product_ps_id) {
		this.product_ps_id = product_ps_id;
	}

	public void setProduct_is_detail(boolean product_is_detail) {
		this.product_is_detail = product_is_detail;
	}

	public void setProduct_deleted_date(String product_deleted_date) {
		this.product_deleted_date = product_deleted_date;
	}

	public void setProduct_deleted_author(String product_deleted_author) {
		this.product_deleted_author = product_deleted_author;
	}

	public void setProduct_promotion_price(String product_promotion_price) {
		this.product_promotion_price = product_promotion_price;
	}

	public void setProduct_sold(String product_sold) {
		this.product_sold = product_sold;
	}

	public void setProduct_best_seller(String product_best_seller) {
		this.product_best_seller = product_best_seller;
	}

	public void setProduct_promotion(String product_promotion) {
		this.product_promotion = product_promotion;
	}

	public void setProduct_price_calc_description(String product_price_calc_description) {
		this.product_price_calc_description = product_price_calc_description;
	}

	public void setProduct_size(short product_size) {
		this.product_size = product_size;
	}

	public void setProduct_name_en(String product_name_en) {
		this.product_name_en = product_name_en;
	}

	public void setProduct_customer_id(int product_customer_id) {
		this.product_customer_id = product_customer_id;
	}

	public void setProduct_perspective_id(int product_perspective_id) {
		this.product_perspective_id = product_perspective_id;
	}
	
	public String toString() {
		return "ID: "+this.product_id+"\tName: "+this.product_name+"\tManager ID: "+this.product_manager_id+"\tVisited: "+this.product_visited;
	}
	
}
