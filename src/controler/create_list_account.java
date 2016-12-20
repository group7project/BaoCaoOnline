package controler;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import javax.servlet.http.Part;

import dao.GiangVienDao;
import dao.SinhVienDao;
import dao.TaiKhoanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;


@WebServlet("/create_list_account.html")
@MultipartConfig
public class create_list_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private XSSFWorkbook workbook;

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		
		String matk = session.getAttribute("maTK").toString();
		request.setAttribute("tentaikhoan", matk);
		
		Part filePart = request.getPart("file"); 
	   String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
	   if(fileName == null || fileName == "")
		{
			request.setAttribute("alertMsg", "chonfile");
       	request.getRequestDispatcher("createlistaccount.html").forward(request, response);
		}
		
		workbook = new XSSFWorkbook(filePart.getInputStream());

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isFirstRow = true;
        TaiKhoanDao	tkd = new TaiKhoanDao();
        String vaitro = request.getParameter("vaitro");
        System.out.println(vaitro);
        while (rowIterator.hasNext()) 
        {
        	Row row = rowIterator.next();
        	if(isFirstRow == true)   		// khong đoc dong dau tien
        	{
        		isFirstRow = false;
        		continue;
        	}
            Iterator<Cell> cellIterator = row.cellIterator();
            String cellContent = "";
            String tentaikhoan = "";
            String hoTen = "";
            String sdt ="";
            int i  = 0;
            while (cellIterator.hasNext()) 
	        {
	                Cell cell = cellIterator.next(); 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        //cellContent = URLEncoder.encode(cell.getStringCellValue(),"UTF-8");
	                    	//byte temp[] = cell.getStringCellValue().getBytes();
	                       //cellContent = new String(temp);
	                    	cellContent = cell.getStringCellValue();
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                    	cell.setCellType(Cell.CELL_TYPE_STRING);
	                        cellContent = String.valueOf(cell.getStringCellValue());
	                        break;
	                }
	                
	                switch(i)
	               {
	                case 0: 
	                	tentaikhoan = cellContent;
	                	break;
	                case 1:
	                	hoTen = cellContent;
	                	break;
	                case 2:
	                	sdt = cellContent;
	                	break;
	               }
	               i++;
            }
            
         // System.out.print(tentaikhoan+ "\t" + hoTen+"\t"+ sdt+"\n");
          if(vaitro.equals("GV"))
          {
          	GiangVienDao  gvd = new GiangVienDao();
          	gvd.insertGiangVien(tentaikhoan, hoTen, sdt);
          }
          if(vaitro.equals("SV"))
          {
          	SinhVienDao  svd = new SinhVienDao();
          	svd.insertSinhVien(tentaikhoan, hoTen, sdt);
          }
         tkd.insertTaiKhoan(tentaikhoan, sdt, vaitro);
        }

        if(vaitro.equals("GV"))
        {
        	request.setAttribute("alertMsg", "insert thanh cong"); // them thanh cong
        	request.getRequestDispatcher("instructormanager.html").forward(request, response);
        }
        else if(vaitro.equals("SV"))
        {
        	request.setAttribute("alertMsg", "insert thanh cong");
        	request.getRequestDispatcher("studentmanager.html").forward(request, response);
        }
	}
}
