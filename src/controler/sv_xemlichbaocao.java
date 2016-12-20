package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DeTai;
import models.GiangVien;
import models.TaiKhoan;
import dao.DeTaiDao;
import dao.GiangVienDao;
import dao.SinhVienDao;

@WebServlet("/sv_xemlichbaocao.html")
public class sv_xemlichbaocao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
			
		TaiKhoan tk = new TaiKhoan();
		tk = (TaiKhoan) session.getAttribute("tk");
		String masv = tk.getTenTaiKhoan();
		
		SinhVienDao svd = new SinhVienDao();
		String madt = svd.getMaDeTai(masv);
		
		DeTai dt = new DeTai();
		DeTaiDao dtd = new DeTaiDao();
		
		dt = dtd.getDeTai(madt);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		//System.out.println(dt.getTenDeTai());
		session.setAttribute("detai", dt);
		
		GiangVien gv = new GiangVien();
		GiangVienDao gvd = new GiangVienDao();

		gv = gvd.getGV(madt, "Chủ tịch");
		session.setAttribute("chutich", gv);
		gv = gvd.getGV(madt, "Phản biện");
		session.setAttribute("phanbien", gv);
		gv = gvd.getGV(madt, "Ủy viên");
		session.setAttribute("uyvien", gv);
		
		request.getRequestDispatcher("/views/student-xemlichbaocao.jsp").forward(request,response);
	}

}
