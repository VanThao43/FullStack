package jsoft.ads.section;

import java.util.*;
import jsoft.objects.*;
import org.javatuples.*;

public class SectionLibrary {
	public static Pair<String, String> viewSections(ArrayList<SectionObject> items){
		
		String tmp = "";
		tmp += "<div class=\"card\">\n";
		tmp += "<div class=\"card-body\">\n";
		tmp += "<h5 class=\"card-title\">DANH SÁCH các chuyên mục</h5>\n";

		tmp += "<table class=\"table table-striped\">\n";
		tmp += "<thead>\n";
		tmp += "<tr>\n";
		tmp += "<th scope=\"col\">#</th>";
		tmp += "<th scope=\"col\">Tên chuyên mục</th>";
		tmp += "<th scope=\"col\">Ngày khởi tạo</th>";
		tmp += "<th scope=\"col\">Mã số tác giả</th>";
		tmp += "<th scope=\"col\">Mã số quản lý</th>";
		tmp += "<th scope=\"col\">Ngày chỉnh sửa</th>";
		tmp += "<th scope=\"col\" colspan = \"3\">Ghi chú</th>\n";
		tmp += "</tr>\n";
		tmp += "</thead>\n";
		tmp += "<tbody>\n";
		for (SectionObject item : items) {
			tmp += "<tr>";
			tmp += "<th scope=\"row\">"+item.getSection_id()+"</th>";
			tmp += "<td>"+item.getSection_name()+"</td>";
			tmp += "<td>"+item.getSection_created_date()+"</td>";
			tmp += "<td>"+item.getSection_created_author_id()+"</td>";
			tmp += "<td>"+item.getSection_manager_id()+"</td>";
			tmp += "<td>"+item.getSection_last_modified()+"</td>";
			tmp += "<td>"+item.getSection_notes()+"</td>";
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
