package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DeTai;
import dao.DeTaiDao;

/**
 * Servlet implementation class gv_detaiphanconglamuyvien
 */
@WebServlet("/gv_detaiphanconglamuyvien.html")
public class gv_detaiphanconglamuyvien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
			

		String maTK = session.getAttribute("maTK").toString();
		String flag = request.getParameter("flag");
		ArrayList<DeTai> gv_dts;
		DeTaiDao gvd = new DeTaiDao();
		gv_dts = gvd.getDeTais_GV(maTK,flag );
		
		request.setAttribute("tentaikhoan", maTK);
		session.setAttribute("list_dt", gv_dts);
		
		request.getRequestDispatcher("/views/GV_detaiPCUV.jsp").forward(request,response);
	}

}