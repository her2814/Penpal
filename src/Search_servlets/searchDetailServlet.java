package Search_servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Scarch_dao.FriendDao;
import Scarch_dao.UserDao;
import Scarch_vo.User;


@WebServlet("/searchDetail")
public class searchDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			String id;
			
			ServletContext sc = this.getServletContext();
			UserDao userDao = (UserDao)sc.getAttribute("userDao");
			
			id = request.getParameter("no");		
			request.setAttribute("users", userDao.selectFiendProFile(id));
			
			response.setContentType("text/html; charset=UTF-8"); 
	
			RequestDispatcher rd = request.getRequestDispatcher(
					"/SerachFriend/FriendProFilePage.jsp");
			rd.include(request, response);
			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
