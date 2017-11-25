package Search_servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Scarch_dao.UserDao;


@WebServlet("/SearchFriend")
public class SearchFriendListServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			
			
			response.setContentType("text/html; charset=UTF-8"); 
			RequestDispatcher rd = request.getRequestDispatcher(
					"/SerachFriend/SerachFriendListPage.jsp");
			rd.include(request, response);
			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
			String hobby,nationalty;
			
			ServletContext sc = this.getServletContext();
			UserDao userDao = (UserDao)sc.getAttribute("userDao");
			
	
			hobby = request.getParameter("hobby");
			nationalty = request.getParameter("nationalty");
			request.setAttribute("users", userDao.friendselectList(hobby,nationalty));
			response.setContentType("text/html; charset=UTF-8"); 
			RequestDispatcher rd = request.getRequestDispatcher(
					"/SerachFriend/SerachFriendListPage.jsp");
			rd.include(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	
		
	}

}
