package jsoft.ads.product;

import java.util.*;
import jsoft.objects.*;
import org.javatuples.*;

public class ProductLibrary {
	public static Pair<String, String> viewProducts(ArrayList<ProductObject> items){
		
		String tmp = "";
		tmp += "<div class=\"card\">\n";
		tmp += "<div class=\"card-body\">\n";
		tmp += "<h5 class=\"card-title\">DANH SÁCH các chuyên mục</h5>\n";

		tmp += "<table class=\"table table-striped\">\n";
		tmp += "<thead>\n";
		tmp += "<tr>\n";
		tmp += "<th scope=\"col\">#</th>";
		tmp += "<th scope=\"col\">Tên sản phẩm</th>";
		tmp += "<th scope=\"col\">Ngày tạo</th>";
		tmp += "<th scope=\"col\">Ngày chỉnh sửa</th>";
		tmp += "<th scope=\"col\">Mã số quản lý</th>";
		tmp += "<th scope=\"col\">Số lượt xem</th>";
		tmp += "<th scope=\"col\">Giá bán</th>";
		tmp += "<th scope=\"col\">Ghi chú</th>";
		tmp += "<th scope=\"col\" colspan = \"3\">Thực hiện</th>\n";
		tmp += "</tr>\n";
		tmp += "</thead>\n";
		tmp += "<tbody>\n";
		for (ProductObject item : items) {
			tmp += "<tr>";
			tmp += "<th scope=\"row\">"+item.getProduct_id()+"</th>";
			tmp += "<td>"+item.getProduct_name()+"</td>";
			tmp += "<td>"+item.getProduct_created_date()+"</td>";
			tmp += "<td>"+item.getProduct_modified_date()+"</td>";
			tmp += "<td>"+item.getProduct_manager_id()+"</td>";
			tmp += "<td>"+item.getProduct_visited()+"</td>";
			tmp += "<td>"+item.getProduct_price()+"</td>";
			tmp += "<td>"+item.getProduct_notes()+"</td>";
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
