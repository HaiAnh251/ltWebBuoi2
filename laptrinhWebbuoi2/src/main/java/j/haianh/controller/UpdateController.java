package j.haianh.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import j.haianh.service.userService;
import j.haianh.serviceImpl.userServiceImpl;
import j.haianh.utils.constant.constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/views/update" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 


maxFileSize = 1024 * 1024 * 5, 


maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdateController extends HttpServlet {
	userService service = new userServiceImpl();
	

	 private String getFileName(Part part) {


		 for (String content : part.getHeader("content-disposition").split(";")) {


		 if (content.trim().startsWith("filename"))


		 return content.substring(content.indexOf("=") + 2, content.length() - 1);


		 }
		 return constant.DEFAULT_FILENAME;
	 }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploadPath = File.separator + constant.UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ


		 //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào thư mục project


		 File uploadDir = new File(uploadPath);


		 if (!uploadDir.exists())


		 uploadDir.mkdir();



		 try {


		 String fileName = "";


		 for (Part part : req.getParts()) {


		 fileName = getFileName(part);


		 part.write(uploadPath + File.separator + fileName);


		 }


		 


		 req.setAttribute("message", "File " + fileName + " has uploaded successfully!");


		 } catch (FileNotFoundException fne) {


		 req.setAttribute("message", "There was an error: " + fne.getMessage());


		 }


		 req.getRequestDispatcher("/views/result.jsp").forward(req, resp);


	


	}

	

}
