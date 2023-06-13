package jsoft.ads.user;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/user/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * Phương thức thường được sử dụng để cung câp một giao diện (GUI) <br>
	 * 
	 * Nó được gọi trong 2 trường hợp sau: <br>
	 * - Thông qua đường dẫn url của trình duyệt <br>
	 * - Thông qua sự kiện của form (method="get") <br><br>
	 * 
	 * <b>Tham số request</b> - chứa các yêu cầu và dữ liệu cần xử lý từ trình khách gửi lên <br>
	 * <b>Tham số reponse</b> - chứa các đáp ứng gửi về trình khách (client)
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);
		
		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();
		
		out.print("<!-- doctype html -->");
		out.print("<html lang=\"en\">");
		  out.print("<head>");
		    out.print("<meta charset=\"utf-8\">");
		    out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		    out.print("<title>Login</title>");
		    out.print("<link href=\"/adv/css/all.min.css\" rel=\"stylesheet\">");
		    out.print("<link href=\"/adv/css/bootstrap.min.css\" rel=\"stylesheet\">");
		    out.print("<link href=\"/adv/css/loginV3.css\" rel=\"stylesheet\">");
			out.print("<script language=\"javascript\" src=\"/adv/js/loginv3.js\"></script>");
		  out.print("</head>");
		out.print("  ");
		  out.print("<body>");
		out.print("");
		    out.print("<div class=\"container-lg\">");
		        out.print("<div class=\"row my-5\">");
		            out.print("<div class=\"col-lg-6 offset-lg-3 text-bg-light\">");
		                out.print("<!-- form -->");
		                out.print("<form action=\"\" class=\"loginview\" name=\"\" method=\"\">");
		                    out.print("<!-- Login -->");
		                    out.print("<div class=\"row\">");
		                        out.print("<div class=\"col-12 text-bg-primary py-3 text-center fw-bolder text-uppercase\">");
		                            out.print("<i class=\"fa-solid fa-user\"></i> &nbsp;&nbsp;login");
		                        out.print("</div>");
		                    out.print("</div>");
	
		                    out.print("<!-- UserName / Email -->");
		                    out.print("<div class=\"row mb-3 mt-3\">");
		                        out.print("<label for=\"name\" class=\"col-sm-4 col-form-label text-end fw-semibold\">Username / Email</label>");
		                        out.print("<div class=\"col-sm-6\">");
									out.print("<input type=\"email\" class=\"form-control\" id=\"name\" onKeyup=\"checkValidLogin()\">");
									out.print("<div id=\"errName\"></div>");
		                        out.print("</div>");
		                    out.print("</div>");
		
		                    out.print("<!-- Password -->");
		                    out.print("<div class=\"row mb-3\">");
		                        out.print("<label for=\"pass\" class=\"col-sm-4 col-form-label text-end fw-semibold\">Password</label>");
		                        out.print("<div class=\"col-sm-6\">");
									out.print("<input type=\"password\" class=\"form-control\" id=\"pass\" onKeyup=\"checkValidLogin()\">");
									out.print("<div id=\"errPass\"></div>");
		                        out.print("</div>");
		                    out.print("</div>");
		
		                    out.print("<!-- check save account -->");
		                    out.print("<div class=\"row mb-3\">");
		                        out.print("<div class=\"col-sm-6 offset-sm-4\">");
		                        out.print("<div class=\"form-check\">");
		                            out.print("<input class=\"form-check-input\" type=\"checkbox\" id=\"chkSave\" onclick=\"checkValidLogin()\">");
		                            out.print("<label class=\"form-check-label\" for=\"chkSave\">");
		                                out.print("Save the account information?");
		                            out.print("</label>");
		                        out.print("</div>");
		                        out.print("</div>");
		                    out.print("</div>");
		
		                    out.print("<!-- Forget Password, help, sign up -->");
		                    out.print("<div class=\"row mb-3\">");
		                        out.print("<div class=\"col-12 text-center\">");
		                            out.print("<a href=\"#\">Forget password</a>&nbsp;&nbsp;|&nbsp;&nbsp;");
		                            out.print("<a href=\"#\">Help!</a>&nbsp;&nbsp;|&nbsp;&nbsp;");
		                            out.print("<a href=\"#\">Sign up!</a>");
		                        out.print("</div>");
		                    out.print("</div>");
		
		                    out.print("<!-- Button -->");
		                    out.print("<div class=\"row mb-3\">");
		                        out.print("<div class=\"col-12 text-center\">");
		                            out.print("<button type=\"button\" class=\"btn btn-primary\" disabled  id=\"btnReg\">"
		                            		+ "<i class=\"fa-solid fa-right-to-bracket\"></i>&nbsp;Sign in</button>&nbsp;&nbsp;");
		                            out.print("<button type=\"button\" class=\"btn btn-secondary\" onclick=\"window.close()\">Cancel</button>");
		                        out.print("</div>");
		                    out.print("</div>");
		
		                    out.print("<!-- Language -->");
		                    out.print("<div class=\"row mb-3\">");
		                        out.print("<div class=\"col-12 text-end\">");
		                            out.print("<a href=\"#\"><i class=\"fa-solid fa-language\"></i> &nbsp;Vietnamese</a>");
		                        out.print("</div>");
		                    out.print("</div>");
		                out.print("</form>");
		            out.print("</div>");
		        out.print("</div>");
		    out.print("</div>");
		out.print("");
		    out.print("<script src=\"js/bootstrap.bundle.min.js\"></script>");
		  out.print("</body>");
		out.print("</html>");
		
		// Đóng luồng xuất
		out.close();
	}

	/**
	 * 
	 * Phương thức thường được dùng để xử lý dữ liệu do các doGet gửi cho <br>
	 * 
	 * Được gọi chỉ trong trường hợp sự kiện của form: method="post" <br>
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
