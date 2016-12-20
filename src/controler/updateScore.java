package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DeTai;
import models.TaiKhoan;
import dao.VaiTroDao;

/**
 * Servlet implementation class updateScore
 */
@WebServlet("/updateScore")
public class updateScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateScore() {
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
		

		
		DeTai dt = (DeTai)session.getAttribute("detaibaocao");
		String topicid = dt.getMaDeTai();
		String score = request.getParameter("input-score"); // lấy bằng parameter thì lấy bằng cái name nha. ko phải id. kêu ảnh đừng ho nữa
		String comment = request.getParameter("input-comment");
		TaiKhoan tk = (TaiKhoan)session.getAttribute("tk");
		
		String id= tk.getTenTaiKhoan();
		VaiTroDao vtd = new VaiTroDao();
		vtd.InsertScore(id,topicid, score, comment);
		String k ="1";
		session.setAttribute("hasCheck", k);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		request.getRequestDispatcher("/views/GV_XemBaoCao.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
