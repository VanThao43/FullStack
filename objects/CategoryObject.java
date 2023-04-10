package jsoft.objects;

public class CategoryObject extends SectionObject{
	private short category_id;
	private String category_name;
	private short category_section_id;
	private String category_notes;
	private String category_created_date;
	private int category_created_author_id;
	private String category_last_modified;
	private int category_manager_id;
	private boolean category_enable;
	private boolean category_delete;
	private String category_image;
	private String category_name_en;
	private byte category_language;
	
	public CategoryObject() {
		
	}

	public short getCategory_id() {
		return category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public short getCategory_section_id() {
		return category_section_id;
	}

	public String getCategory_notes() {
		return category_notes;
	}

	public String getCategory_created_date() {
		return category_created_date;
	}

	public int getCategory_created_author_id() {
		return category_created_author_id;
	}

	public String getCategory_last_modified() {
		return category_last_modified;
	}

	public int getCategory_manager_id() {
		return category_manager_id;
	}

	public boolean isCategory_enable() {
		return category_enable;
	}

	public boolean isCategory_delete() {
		return category_delete;
	}

	public String getCategory_image() {
		return category_image;
	}

	public String getCategory_name_en() {
		return category_name_en;
	}

	public byte getCategory_language() {
		return category_language;
	}

	public void setCategory_id(short category_id) {
		this.category_id = category_id;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public void setCategory_section_id(short category_section_id) {
		this.category_section_id = category_section_id;
	}

	public void setCategory_notes(String category_notes) {
		this.category_notes = category_notes;
	}

	public void setCategory_created_date(String category_created_date) {
		this.category_created_date = category_created_date;
	}

	public void setCategory_created_author_id(int category_created_author_id) {
		this.category_created_author_id = category_created_author_id;
	}

	public void setCategory_last_modified(String category_last_modified) {
		this.category_last_modified = category_last_modified;
	}

	public void setCategory_manager_id(int category_manager_id) {
		this.category_manager_id = category_manager_id;
	}

	public void setCategory_enable(boolean category_enable) {
		this.category_enable = category_enable;
	}

	public void setCategory_delete(boolean category_delete) {
		this.category_delete = category_delete;
	}

	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	public void setCategory_name_en(String category_name_en) {
		this.category_name_en = category_name_en;
	}

	public void setCategory_language(byte category_language) {
		this.category_language = category_language;
	}
	
	public String toString() {
		return "ID: "+this.category_id+"\tName: "+this.category_name+"\tAuthor ID: "+this.category_created_author_id;
	}
	
}
