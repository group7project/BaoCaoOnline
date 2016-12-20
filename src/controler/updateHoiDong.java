package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GiangVienDao;
import dao.VaiTroDao;


@WebServlet("/updateHoiDong.html")
public class updateHoiDong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		
		String chutich = new String(request.getParameter("chutich").getBytes("ISO-8859-1"),"utf-8");
		String uyvien = new String(request.getParameter("uyvien").getBytes("ISO-8859-1"),"utf-8");
		String phanbien = new String(request.getParameter("phanbien").getBytes("ISO-8859-1"),"utf-8");
		String madt = request.getParameter("madt");
		
		// xoa vai tro co ma de tai la madt truoc.
		VaiTroDao vtd = new VaiTroDao();
		GiangVienDao gvd = new GiangVienDao();
		
		vtd.DeleteVaiTro(madt);
		String maChuTich = gvd.getMaGV(chutich);
		String maUyVien = gvd.getMaGV(uyvien);
		String maPhanBien = gvd.getMaGV(phanbien);
		vtd.InsertChuTich(madt, maChuTich);
		vtd.InsertUyVien(madt, maUyVien);
		vtd.InsertPhanBien(madt, maPhanBien);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		request.getRequestDispatcher("dean_topic_detail.html").forward(request,response);
	}

}
