package jsoft.ads.category;

import java.util.*;
import jsoft.objects.*;
import org.javatuples.*;

public class CategoryLibrary {
	public static Pair<String, String> viewCategories(ArrayList<CategoryObject> items){
		
		String tmp = "";
		tmp += "<div class=\"card\">\n";
		tmp += "<div class=\"card-body\">\n";
		tmp += "<h5 class=\"card-title\">DANH SÁCH các chuyên mục</h5>\n";

		tmp += "<table class=\"table table-striped\">\n";
		tmp += "<thead>\n";
		tmp += "<tr>\n";
		tmp += "<th scope=\"col\">#</th>";
		tmp += "<th scope=\"col\">Tên thể loại</th>";
		tmp += "<th scope=\"col\">Ngày khởi tạo</th>";
		tmp += "<th scope=\"col\">Mã số chuyên mục</th>";
		tmp += "<th scope=\"col\">Mã số tác giả</th>";
		tmp += "<th scope=\"col\">Mã số quản lý</th>";
		tmp += "<th scope=\"col\">Ngày chỉnh sửa</th>";
		tmp += "<th scope=\"col\">Ghi chú</th>";
		tmp += "<th scope=\"col\" colspan = \"3\">Thực hiện</th>\n";
		tmp += "</tr>\n";
		tmp += "</thead>\n";
		tmp += "<tbody>\n";
		for (CategoryObject item : items) {
			tmp += "<tr>";
			tmp += "<th scope=\"row\">"+item.getCategory_id()+"</th>";
			tmp += "<td>"+item.getCategory_name()+"</td>";
			tmp += "<td>"+item.getCategory_created_date()+"</td>";
			tmp += "<td>"+item.getCategory_section_id()+"</td>";
			tmp += "<td>"+item.getCategory_created_author_id()+"</td>";
			tmp += "<td>"+item.getCategory_manager_id()+"</td>";
			tmp += "<td>"+item.getCategory_last_modified()+"</td>";
			tmp += "<td>"+item.getCategory_notes()+"</td>";
			tmp += "<td>Chi tiết</td>";
			tmp += "<td>sửa</td>";
			tmp += "<td>xoá</td>";
			tmp += "</tr>\n";
		}
		tmp += "</tbody>\n";
		tmp += "</table>\n";
		
		tmp += "</div>\n";
		tmp += "</div>";
		
		Pair<String, String> result = new Pair<>(tmp, "");
		
		return result;
	}
}
