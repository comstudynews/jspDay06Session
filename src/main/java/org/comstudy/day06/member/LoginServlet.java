package org.comstudy.day06.member;

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
	
	HttpSession session;
	private String viewName = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - LoginServlet");
		
		session = request.getSession();
		
		// 기존에 로그인 된 정보 초기화 하기 (logout)
		// 속성을 일일이 지우기
		session.removeAttribute("username");
		// 전체 session을 한번에 초기화 
		session.invalidate();
		
		viewName = "/WEB-INF/views/member/login.jsp";
		dispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost - LoginServlet");
		// 파라미터 정보를 가져 온다.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("user01".equals(username) && "12345".equals(password)) {
			// 로그인이 되면 session에 로그인 정보 바인딩하기
			session = request.getSession();
			session.setAttribute("username", username);
		}
		
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
