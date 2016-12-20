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
import dao.TaiKhoanDao;

/**
 * Servlet implementation class updateGiangVien
 */
@WebServlet("/updategiangvien")
public class updateGiangVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGiangVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		
		ArrayList<GiangVien> gvs ;
		GiangVienDao gvd = new GiangVienDao();
		TaiKhoanDao tkd = new TaiKhoanDao();
		
		String magv = request.getParameter("input-magv");
		String matKhau = request.getParameter("input-matkhau");
		String hoTen = new String(request.getParameter("input-hoten").getBytes("ISO-8859-1"),"utf-8");
		String sdt = request.getParameter("input-sdt");
		
		gvd.updateGiangVien(magv, hoTen, sdt);
		tkd.updateTaiKhoan(magv, matKhau);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		gvs = gvd.getGVs();
		session.setAttribute("list_gv", gvs);
		request.getRequestDispatcher("/views/ad-instructor-manager.jsp").forward(request,response);
		
	}

}
