package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GiangVienDao;
import models.GiangVien;
import models.TaiKhoan;

/**
 * Servlet implementation class dean_rating
 */
@WebServlet("/dean_rating.html")
public class dean_rating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dean_rating() {
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
		
		TaiKhoan tk = new TaiKhoan();
		tk = (TaiKhoan) session.getAttribute("tk");
		String matk = tk.getTenTaiKhoan();
		GiangVienDao gvd = new GiangVienDao();
		ArrayList<GiangVien> gvds;
		
		gvds = gvd.getGV_DTTrung(matk);
		
		request.setAttribute("tentaikhoan", matk);
		session.setAttribute("list_gv_detaitrung", gvds); 
		
		request.getRequestDispatcher("/views/TK-xeplich.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
