package org.comstudy.day06.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shop/*")
public class ShopController extends HttpServlet {
	
	private String viewName = "";
	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	
	ProductDAO dao = new ProductDAOImpl();
	
	protected void dispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(viewName.indexOf("redirect:") == 0) {
			response.sendRedirect(viewName.substring("redirect:".length()));
		} else {
			String path = prefix + viewName + suffix;
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// process : doGet()과 doPost() 통합 처리
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// urlPattern 만들기
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length();
		String urlPattern = reqUri.substring(beginIndex);
		
		System.out.println("Url Pattern : " + urlPattern);
		
		if("POST".equals(req.getMethod() ) ) {
			// 상품 등록, 수정, 삭제 등의 기능
		} else {
			if("/shop/list.do".equals(urlPattern)) {
				List<ProductDTO> pList = (List<ProductDTO>)dao.selectAll();
				req.setAttribute("pList", pList);
				viewName = "shop/productList";
			} else if("/shop/cart.do".equals(urlPattern)) {
				// 상품 seq, 수량을 파라미터로 전달 받고
				// 목록에서 seq를 찾아서 해당 상품의 객체를 장바구니 목록에 저장
				// 장바구니 목록은 session에 바인딩 하고 장바구니 목록 뷰 보여주기.
				viewName = "shop/cartList";
			} else if("/shop/detail.do".equals(urlPattern)) {
				int seq = Integer.parseInt(req.getParameter("seq"));
				ProductDTO product = dao.findBySeq(seq);
				req.setAttribute("product", product);
				viewName = "shop/productDetail";
			}  else if("/shop/cart_add.do".equals(urlPattern)) {
				int seq = Integer.parseInt(req.getParameter("seq"));
				int ea = Integer.parseInt(req.getParameter("ea"));
				
				System.out.println("seq => " + seq);
				System.out.println("ea => " + ea);
				
				ProductDTO product = dao.findBySeq(seq);
				ProductDTO newProduct = (ProductDTO)product.clone();
				newProduct.setEa(ea);
				// 장바구니에 상품을 추가하고 새로고침
				HttpSession session = req.getSession();
				
				viewName = "redirect:cart.do";
			}
		}
		
		dispatcher(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
