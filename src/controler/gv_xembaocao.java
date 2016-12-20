package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeTaiDao;
import dao.VaiTroDao;
import models.DeTai;
import models.TaiKhoan;

/**
 * Servlet implementation class gv_xembaocao
 */
@WebServlet("/gv_xembaocao.html")
public class gv_xembaocao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gv_xembaocao() {
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
			
		String madt = request.getParameter("madetai");
		DeTai detai = new DeTai();
		DeTaiDao dtd = new DeTaiDao();
		detai  = dtd.getDeTai(madt);
		TaiKhoan tk = ((TaiKhoan)session.getAttribute("tk"));
		String matk = tk.getTenTaiKhoan();
		String laCT = "0";
		VaiTroDao vtd = new VaiTroDao();
		if (vtd.LaChuTich(matk, detai.getMaDeTai())==1)
		{
			laCT ="1";
		}
		System.out.println(laCT);
		System.out.println("-------------------------");
		
		String daCD ="0";
		if (vtd.daChamDiem(matk, detai.getMaDeTai())==1)
			daCD="1";
		
		String maTK = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", maTK);
		session.setAttribute("laChuTich", laCT);
		session.setAttribute("daCD", daCD);
		session.setAttribute("detaibaocao", detai);
		request.getRequestDispatcher("/views/GV_XemBaoCao.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
