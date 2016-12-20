package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/downloadFileBaoCao")
public class downloadFileBaoCao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		
		String fileName = request.getParameter("fileName");
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		
		
		 // reads input file from an absolute path
		 String filePath = getServletContext().getRealPath("") + File.separator + "pdf"+ File.separator + fileName;
       
		 File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();     
		
        String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		if(flag  == 1)
			request.getRequestDispatcher("/gv_trangchu.html").forward(request,response);
		else if(flag  == 2)
			request.getRequestDispatcher("/gv_detaiphancongphanbien.html").forward(request,response);
		else if(flag  == 3)
			request.getRequestDispatcher("/gv_detaiphancongphanbien.html").forward(request,response);

	}

}