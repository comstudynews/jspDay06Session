package org.comstudy.day06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex01getattr")
public class BindingGetAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletContext application;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException {
		application = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		session = request.getSession();
		
		// 페이지 이동 이전에 "/ex01setattr" 요청 할때 바인딩 된 데이터 읽어서 사용
		// setAttribute()에 저장 된것은 모두 Object 형
		// getAttribute() 할때 형변환 필수.
		String appName = (String)application.getAttribute("appName");
		String userName = (String)session.getAttribute("userName");
		
		// request는 같은 URL일 경우에 데이터가 보존된다.
		// request에 바인딩 데이터는 URL변경되면 사라진다.
		request.setAttribute("address", "서울시 강남구 신사동");
		
//		PrintWriter out = response.getWriter();
//		out.println("<DOCTYPE html>");
//		out.println("<html><body>");
//		out.println("App name은 " + appName + "<br/>");
//		out.println("User name은 " + userName + "<br/>");
//		out.println("주소는 " + request.getAttribute("address") + "<br/>");
//		out.println("<a href=\"BindingGet.jsp\">BidingGet.jsp로 이동</a>");
//		out.println("</body></html>");
//		out.close();
		
		// forward 될때도 URL은 동일하기 때문에 reuqest에 바인딩 된 데이터 사용 가능.
		RequestDispatcher view = request.getRequestDispatcher("BindingGet.jsp");
		view.forward(request, response);
	}
}
