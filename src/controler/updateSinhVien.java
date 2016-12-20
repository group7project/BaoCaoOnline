package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.SinhVien;
import dao.SinhVienDao;
import dao.TaiKhoanDao;

/**
 * Servlet implementation class updateSinhVien
 */
@WebServlet("/updateSinhVien.html")
public class updateSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSinhVien() {
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
		
		ArrayList<SinhVien> svs ;
		SinhVienDao svd = new SinhVienDao();
		TaiKhoanDao tkd = new TaiKhoanDao();
		
		String masv = request.getParameter("ma-sv");
		System.out.println(masv);
		String matKhau = request.getParameter("matkhau-sv");
		String hoTen = new String(request.getParameter("hoten-sv").getBytes("ISO-8859-1"),"utf-8");
		String sdt = request.getParameter("sdt-sv");
		System.out.println(hoTen);
		svd.updateSinhVien(masv, hoTen, sdt);
		tkd.updateTaiKhoan(masv, matKhau);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		svs = svd.getSVs();
		session.setAttribute("list_sv", svs);
		request.getRequestDispatcher("/views/ad-student-manager.jsp").forward(request,response);
	}

}
