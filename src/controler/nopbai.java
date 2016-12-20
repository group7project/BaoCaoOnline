package controler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.DeTaiDao;
import dao.GiangVienDao;


@WebServlet("/nopbai.html")
public class nopbai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "pdf";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	 	request.setCharacterEncoding("utf-8");
	 	response.setCharacterEncoding("utf-8");
	 	
		final HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);

		String madt = request.getParameter("madt");
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		// checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
		
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
    		String magvhd="";
    		String hotengvhd ="";
    		String mota="" ;
    		String fileName="";
 
        	 List<FileItem> formItems = upload.parseRequest(request);
             if (formItems != null && formItems.size() > 0) {
             	for (FileItem item : formItems) {
            	    // processes only fields that are not form fields
            	    if (item.isFormField()) {// not is input type="file"
            	        String fieldname = item.getFieldName();
            	        String fieldvalue = new String(item.getString().getBytes("ISO-8859-1"),"utf-8");
            	        if (fieldname.equals("gvhd")) {
            	        	hotengvhd = fieldvalue;
            	        } else if (fieldname.equals("mota")) {
            	        	mota = fieldvalue;
            	        }
            	    } 
            	        else {
            	    	  fileName = new File(item.getName()).getName();
            	    	  String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
          	    	 // creates the directory if it does not exist
          		        File uploadDir = new File(uploadPath);
          		        if (!uploadDir.exists()) {
          		            uploadDir.mkdir();
          		        }
          	    	  	
          	    	  	String filePath = uploadPath+ File.separator + fileName;
	            	        File storeFile = new File(filePath);
	            	        // saves the file on disk
	            	        item.write(storeFile);
            	    }
            	}
            }	
        		DeTaiDao dtd = new DeTaiDao();
        		GiangVienDao gvd = new GiangVienDao();
        		magvhd = gvd.getMaGV(hotengvhd);
        		
        		dtd.updateDeTai(madt, magvhd, mota,fileName);
        		
        		request.setAttribute("nopbaimess", "thanhcong");
        		
        		request.getRequestDispatcher("sv_nopbai.html").forward(request,response);
    		
        } catch (Exception ex){}
	}

}
