package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeTaiDao;

@WebServlet("/updateThoiGian.html")
public class updateThoiGian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		
		String madt = request.getParameter("madt");
		String ngaybc = request.getParameter("ngaybc");
		String giobc =request.getParameter("giobc");
		String tgbctd =request.getParameter("tgbctd");
		
		DeTaiDao dtd = new DeTaiDao();
		dtd.updateThoiGian(madt, ngaybc, giobc, tgbctd);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		request.getRequestDispatcher("dean_topic_detail.html").forward(request,response);
	}

}
