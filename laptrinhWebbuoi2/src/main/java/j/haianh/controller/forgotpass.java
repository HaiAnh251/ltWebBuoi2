package j.haianh.controller;

import java.io.IOException;

import j.haianh.serviceImpl.userServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/views/forgotpass")
public class forgotpass extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/forgotpass.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		userServiceImpl service = new userServiceImpl();
				
		String alertMsg = "";
		if (!service.checkExistEmail(email)) {
			alertMsg = "Email không tồn tại!";
		}
		else {
			String newPassword = service.RandomPassword();
			alertMsg = "Mật khẩu mới của bạn là " + newPassword;
			service.updatePassword(newPassword, email);
		}
		req.setAttribute("alert", alertMsg);
		req.getRequestDispatcher("/views/forgotpass.jsp").forward(req, resp);
	}
}
