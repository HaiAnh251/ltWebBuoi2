package j.haianh.controller.admin;

import java.io.IOException;
import java.util.List;

import j.haianh.models.CatergoryModel;
import j.haianh.service.IcatergoryService;
import j.haianh.serviceImpl.CatergoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/views/admin/catergories","/admin/category/edit","/admin/catergory/update" })

public class CatergoryController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	public IcatergoryService cateService=new CatergoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url=req.getRequestURI();
		if(url.contains("catergories"))
		{
			List<CatergoryModel> list=cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/catergory-list.jsp").forward(req, resp);
					
		} else if(url.contains("/admin/catergory/edit"))
		{
			int id=Integer.parseInt(req.getParameter("id"));
			CatergoryModel catergory=cateService.findById(id);
			req.setAttribute("cate", catergory);
			req.getRequestDispatcher("/views/admin/catergory-edits.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url=req.getRequestURI();
		if(url.contains("/admin/catergory/update")) {
			int catergoryid= Integer.parseInt(req.getParameter("catergory_id"));
			String catergoryname=req.getParameter("catergory_namme");
			int status= Integer.parseInt(req.getParameter("status"));
			String image=req.getParameter("image");
		}
	}
	
	

}
