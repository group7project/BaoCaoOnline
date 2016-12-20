package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeTaiDao;
import dao.GiangVienDao;
import models.DeTai;
import models.GiangVien;
import models.TaiKhoan;


@WebServlet("/dean_topic_detail.html")
public class dean_topic_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dean_topic_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
			
		// code here
		String madt = request.getParameter("madt");
		//System.out.println(madt);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		DeTai dt = new DeTai();
		DeTaiDao dtd = new DeTaiDao();
		dt = dtd.getDeTai(madt);
		//System.out.println(dt.getTenDeTai());
//		for(Iterator<SinhVien> i = dt.getSvths().iterator(); i.hasNext(); ) {
//		    SinhVien item = i.next();
//		    System.out.println(item.getHoTen());
//		}
		
		session.setAttribute("detai", dt);
		
		
		// chu tich
		GiangVien gv = new GiangVien();
		GiangVienDao gvd = new GiangVienDao();

		gv = gvd.getGV(madt, "Chủ tịch");
		session.setAttribute("chutich", gv);
		gv = gvd.getGV(madt, "Phản biện");
		session.setAttribute("phanbien", gv);
		gv = gvd.getGV(madt, "Ủy viên");
		session.setAttribute("uyvien", gv);
		System.out.println(gv.getHoTen());
		// lay danh sach gv theo khoa
		ArrayList<GiangVien> gv_khoa;
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		
		gv_khoa = gvd.getGV_Khoa(tk.getTenTaiKhoan());
		session.setAttribute("list_gv_khoa", gv_khoa);
		request.getRequestDispatcher("/views/deen_topic_detail.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
}
