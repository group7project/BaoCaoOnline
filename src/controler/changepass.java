package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaiKhoanDao;
import models.TaiKhoan;


@WebServlet("/changpass.html")
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		
		String tentk = tk.getTenTaiKhoan();
		request.setAttribute("tentaikhoan", tentk);
		
		String old_pass = request.getParameter("old_pass");
		String new_pass = request.getParameter("new_pass");
		String re_newpass = request.getParameter("re_newpass");
		String jspName = request.getParameter("jspName");

		TaiKhoanDao tkd = new TaiKhoanDao();
		if (tkd.checkpass(tentk,old_pass)) {
			if (new_pass.equals(re_newpass)) {
				tkd.updatePass(tentk, new_pass);

				request.setAttribute("changepass-mess", "doi mat khau thanh cong");
				request.getRequestDispatcher("/views/"+jspName).forward(request,response);
			} else {
				request.getRequestDispatcher("/views/"+jspName).forward(request,response);
			}
		} else {
			request.setAttribute("changepass-mess", "mat khau cu ko chinh xac");
			request.getRequestDispatcher("/views/"+jspName).forward(request,response);
		}
	}

}
