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
import dao.KhoaDao;
import models.DeTai;
import models.GiangVien;
import models.Khoa;

/**
 * Servlet implementation class sv_nopbai
 */
@WebServlet("/sv_nopbai.html")
public class sv_nopbai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sv_nopbai() {
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
			
		DeTai dt = (DeTai)session.getAttribute("detai");
		
		Khoa k;
		KhoaDao kd = new KhoaDao();
		k = kd.getKhoa(dt.getMaKhoa());
		
		ArrayList<GiangVien> gvs = new ArrayList<>();
		GiangVienDao gvd = new GiangVienDao();
		gvs = gvd.getGV_Khoa(dt.getMaKhoa());
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		session.setAttribute("dsgiangvien", gvs);
		session.setAttribute("khoa", k);
		
		request.getRequestDispatcher("/views/student-nopbai.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
