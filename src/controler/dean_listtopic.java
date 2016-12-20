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
import models.DeTai;
import models.TaiKhoan;


@WebServlet("/dean_listtopic.html")
public class dean_listtopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dean_listtopic() {
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
		String tentk = tk.getTenTaiKhoan(); 		// ten tai khoan cua truong khoa giong ma khoa
		//System.out.println(tk.getTenTaiKhoan());
		
		DeTaiDao dtd = new DeTaiDao();
		ArrayList<DeTai> dts;
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		dts = dtd.getDeTais(tentk);
		
		session.setAttribute("list_dt", dts);
		request.getRequestDispatcher("/views/dean-listtopic.jsp").forward(request,response);
	}
	
}
