package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import dao.TaiKhoanDao;
import models.TaiKhoan;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TaiKhoan tk = new TaiKhoan();
		TaiKhoanDao tkd = new TaiKhoanDao();
		
		String userid = request.getParameter("username");
		String pwd = request.getParameter("password");
		String rolename= request.getParameter("rolename");
		
		tk = tkd.login(userid, pwd, rolename);
		if(tk != null){
			if(tk.getMatt().equals("1")) // tai khoan dang su dung
			{
				HttpSession session =  request.getSession();
				session.setAttribute("tk",tk);
				
				String remember = request.getParameter("remember");
				Cookie ckId = new Cookie("uid", tk.getTenTaiKhoan());
				Cookie ckPw = new Cookie("pwd", tk.getMatKhau());
				if (remember == "true") {
					ckId.setMaxAge(30 * 24 * 60 * 60);
					ckPw.setMaxAge(30 * 24 * 60 * 60);
					
				} else {
					ckId.setMaxAge(0);
					ckPw.setMaxAge(0);
				}
				response.addCookie(ckId);
				response.addCookie(ckPw);

				session.setAttribute("maTK",tk.getTenTaiKhoan());
				
				if(rolename.equals("SV"))
				{
					response.sendRedirect("sv_xemlichbaocao.html");
				}
				else if(rolename.equals("GV"))
				{
					response.sendRedirect("gv_trangchu.html");
				}
				else if(rolename.equals("TK"))
				{
					
					response.sendRedirect("dean_listtopic.html");
				}
				else
				{
					//request.getRequestDispatcher("").forward(request,response);
					response.sendRedirect("instructormanager.html");
				}	
			}
			else { // tk bi khoa
				request.setAttribute("alertMsg", "tk bi khoa");
	        	request.getRequestDispatcher("home.html").forward(request, response);
			}
		}
		else{ // sai ten dang nhap hoac mat khau
			request.setAttribute("alertMsg", "sai ten dang nhap hoac mat khau");
        	request.getRequestDispatcher("home.html").forward(request, response);
		}
	}

}
