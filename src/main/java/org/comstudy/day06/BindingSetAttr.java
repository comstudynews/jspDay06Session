package org.comstudy.day06;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex01setattr")
public class BindingSetAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected ServletContext application;
	protected HttpSession session;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// ServletConext는 프로젝트 단위이다.
		// init()는 프로젝트 실행 시 한번만 호출 되기 때문에 
		// init()에서 ServletContext를 초기화 할 수 있다.
		application = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션은 브라우저 단위이기 때문에 요청(request)시 session을 받아온다.
		session = request.getSession();
		
		// 1. servetContext(application)에 데이터를 바인딩
		application.setAttribute("appName", "My Todo List");
		// 2. session에 바인딩
		session.setAttribute("userName", "홍길동");
		
		// 다른페이지로 이동한다.(redirect)
		response.sendRedirect("ex01getattr");
	}
}
