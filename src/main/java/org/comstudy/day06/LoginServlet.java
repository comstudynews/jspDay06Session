package org.comstudy.day06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String viewName = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - LoginServlet");
		
		viewName = "/WEB-INF/views/member/login.jsp";
		dispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost - LoginServlet");
		
		// 로그인이 되면 session에 로그인 정보 바인딩하기
		HttpSession session = request.getSession();
		session.setAttribute("username", "Hong");
		
		viewName = "redirect:" + request.getContextPath() + "/jsp/welcome.jsp";
		System.out.println("viewName >>> " + viewName);
		dispatcher(request, response);
	}
	
	protected void dispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(viewName.indexOf("redirect:") == 0) {
			response.sendRedirect(viewName.substring("redirect:".length()));
		} else {
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}
	}
}
