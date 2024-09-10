package j.haianh.controller;

import java.io.IOException;

import j.haianh.models.userModels;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			userModels u=(userModels) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if(u.getId()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin/home");
			}else if(u.getId()==2) {
				resp.sendRedirect(req.getContextPath()+"/manager/home");
			}else {
				resp.sendRedirect(req.getContextPath()+"/home");
				}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
			}
		}
}
