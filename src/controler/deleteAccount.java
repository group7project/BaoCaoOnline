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
import models.SinhVien;
import dao.GiangVienDao;
import dao.SinhVienDao;
import dao.TaiKhoanDao;

/**
 * Servlet implementation class deleteGiangVien
 */
@WebServlet("/deleteAccount.html")
public class deleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAccount() {
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
		
		TaiKhoanDao tkd = new TaiKhoanDao();
		
		String tentaikhoan = (String) request.getParameter("username");
		tkd.deleteTaiKhoan(tentaikhoan);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		String role = (String) request.getParameter("role-name");
		if(role.equals("GV"))
		{
			ArrayList<GiangVien> gvs ;
			GiangVienDao gvd = new GiangVienDao();
			gvs = gvd.getGVs();
			session.setAttribute("list_gv", gvs);
			request.getRequestDispatcher("/views/ad-instructor-manager.jsp").forward(request,response);
		}
		if(role.equals("SV"))
		{
			ArrayList<SinhVien> svs ;
			SinhVienDao gvd = new SinhVienDao();
			svs = gvd.getSVs();
			session.setAttribute("list_sv", svs);
			request.getRequestDispatcher("/views/ad-student-manager.jsp").forward(request,response);
		}
		
	}

}
