package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.GiangVien;
import dao.GiangVienDao;

/**
 * Servlet implementation class dean_listteach
 */
@WebServlet("/dean_listteach.html")
public class dean_listteach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dean_listteach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		
		String matk = session.getAttribute("maTK").toString();
		GiangVienDao gvd = new GiangVienDao();
		ArrayList<GiangVien> gvs;
		
		gvs = gvd. getGV_Khoa(matk);
		
		request.setAttribute("tentaikhoan", matk);
		session.setAttribute("list_gv_khoa", gvs);
		
		request.getRequestDispatcher("/views/dean-listteach.jsp").forward(request,response);
	}

}
