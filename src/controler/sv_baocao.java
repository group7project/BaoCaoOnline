package controler;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeTaiDao;
import models.DeTai;

/**
 * Servlet implementation class sv_baocao
 */
@WebServlet("/sv_baocao.html")
public class sv_baocao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sv_baocao() {
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
		DeTaiDao dtd = new DeTaiDao();
		String dangBC ="0";
		try {
			if (dtd.ktBaoCao(dt.getMaDeTai())== true)
			{
				dangBC ="1";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		System.out.println(dangBC);
		session.setAttribute("dangBC", dangBC);
		request.getRequestDispatcher("/views/student-baocao.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
