package j.haianh.controller;

import java.io.IOException;

import j.haianh.dao.impl.userDaoImpl;
import j.haianh.models.User;
import j.haianh.service.userService;
import j.haianh.serviceImpl.userServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/views/update" })
public class UpdateController extends HttpServlet {
	userService service = new userServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user;
		if (session != null && session.getAttribute("account") != null) {
			user= (User) session.getAttribute("account");
			
			req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
			return;
		}
		
		
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("account");

		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		
		if(fullname!=null && fullname.length()>0)
		{
			user.setFullName(fullname);
		}
		
		if(phone!=null && phone.length()>0)
		{
			user.setPhone(phone);
		}
		

		System.out.println(fullname+phone);
		userDaoImpl dao= new userDaoImpl();
		if(dao.update(user)) {
			System.out.println("Update successfully!");
			session.setAttribute("account", user);

			
		} else {
			System.out.println("Update Fail!");
			
		}
		req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
	}

	

}
