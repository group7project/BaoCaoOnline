package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DeTai;
import models.VaiTro;
import dao.DeTaiDao;
import dao.VaiTroDao;

/**
 * Servlet implementation class gv_xemtongket
 */
@WebServlet("/gv_xemtongket.html")
public class gv_xemtongket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gv_xemtongket() {
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
		dtd.set_Diem(madt);
		detai = dtd.getDeTai(madt);
		
		ArrayList<VaiTro> vts = new ArrayList<>();
		VaiTroDao vtd = new VaiTroDao();
		System.out.println(madt);
		System.out.println("-------------------------");
		vts = vtd.get_VaiTros(madt);
		
		String maTK = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", maTK);
		
		System.out.println(detai.getDiem());
		session.setAttribute("dshoidong", vts);
		session.setAttribute("detaidiem", detai);
		request.getRequestDispatcher("/views/GV_XemTongKet.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
