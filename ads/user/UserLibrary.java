package jsoft.ads.user;

import jsoft.objects.*;
import java.util.*;
import org.javatuples.*;

public class UserLibrary {
	public static Pair<String, String> viewUsers(ArrayList<UserObject> items) {

		String tmp = "";
		tmp += "<div class=\"card\">\n";
		tmp += "<div class=\"card-body\">\n";
		tmp += "<h5 class=\"card-title\">DANH SÁCH NGƯỜI SỬ DỤNG</h5>\n";

		tmp += "<table class=\"table table-striped\">\n";
		tmp += "<thead>\n";
		tmp += "<tr>\n";
		tmp += "<th scope=\"col\">#</th>";
		tmp += "<th scope=\"col\">Tài khoản</th>";
		tmp += "<th scope=\"col\">Họ tên</th>";
		tmp += "<th scope=\"col\">Điện thoại</th>";
		tmp += "<th scope=\"col\">Hộp thư</th>";
		tmp += "<th scope=\"col\">Lần đăng nhập</th>";
		tmp += "<th scope=\"col\">Ngày đăng nhập</th>";
		tmp += "<th scope=\"col\" colspan = \"3\">Thực hiện</th>\n";
		tmp += "</tr>\n";
		tmp += "</thead>\n";
		tmp += "<tbody>\n";
		for (UserObject item : items) {
			
			tmp += "<th scope=\"row\">"+item.getUser_id()+"</th>";
			tmp += "<td>"+item.getUser_name()+"</td>";
			tmp += "<td>"+item.getUser_fullname()+"</td>";
			tmp += "<td>"+item.getUser_mobilephone()+"</td>";
			tmp += "<td>"+item.getUser_email()+"</td>";
			tmp += "<td>"+item.getUser_logined()+"</td>";
			tmp += "<td>"+item.getUser_last_logined()+"</td>";
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
