package jsoft.ads.article;

import java.util.*;
import jsoft.objects.*;
import org.javatuples.*;

public class ArticleLibrary {
	public static Pair<String, String> viewArticles (ArrayList<ArticleObject> items){
		
		String tmp = "";
		tmp += "<div class=\"card\">\n";
		tmp += "<div class=\"card-body\">\n";
		tmp += "<h5 class=\"card-title\">DANH SÁCH các chuyên mục</h5>\n";

		tmp += "<table class=\"table table-striped\">\n";
		tmp += "<thead>\n";
		tmp += "<tr>\n";
		tmp += "<th scope=\"col\">#</th>";
		tmp += "<th scope=\"col\">Tiêu đề</th>";
		tmp += "<th scope=\"col\">Thể loại</th>";
		tmp += "<th scope=\"col\">Tên chuyên mục</th>";
		tmp += "<th scope=\"col\">Ngày khởi tạo</th>";
		tmp += "<th scope=\"col\">Ngày sửa</th>";
		tmp += "<th scope=\"col\">Tác giả</th>";
		tmp += "<th scope=\"col\">Số lượt xem</th>";
		tmp += "<th scope=\"col\">Tóm tắt</th>";
		tmp += "<th scope=\"col\" colspan = \"3\">Thực hiện</th>\n";
		tmp += "</tr>\n";
		tmp += "</thead>\n";
		tmp += "<tbody>\n";
		for (ArticleObject item : items) {
			tmp += "<tr>";
			tmp += "<th scope=\"row\">"+item.getArticle_id()+"</th>";
			tmp += "<td>"+item.getArticle_title()+"</td>";
			tmp += "<td>"+item.getSection_name()+"</td>";
			tmp += "<td>"+item.getArticle_type()+"</td>";
			tmp += "<td>"+item.getArticle_created_date()+"</td>";
			tmp += "<td>"+item.getArticle_last_modified()+"</td>";
			tmp += "<td>"+item.getArticle_author_name()+"</td>";
			tmp += "<td>"+item.getArticle_visited()+"</td>";
			tmp += "<td>"+item.getArticle_summary()+"</td>";
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
