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
import dao.VaiTroDao;

/**
 * Servlet implementation class sv_xemketqua
 */
@WebServlet("/sv_xemketqua.html")
public class sv_xemketqua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sv_xemketqua() {
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
		ArrayList<VaiTro>  vts = new ArrayList<>();
		VaiTroDao vtd = new VaiTroDao();
		DeTai detai = (DeTai)session.getAttribute("detai");
		String madetai = detai.getMaDeTai();
		vts = vtd.get_VaiTros(madetai);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		session.setAttribute("detai_ketqua", vts);
		
		request.getRequestDispatcher("/views/student-xemketqua.jsp").forward(request,response);
	}

}
