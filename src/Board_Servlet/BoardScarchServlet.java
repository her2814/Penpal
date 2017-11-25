package Board_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board_dao.BoardDao;

import Scarch_vo.User;

@WebServlet("/BoardFree")
public class BoardScarchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String free = request.getParameter("no");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
		
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute("loginInfo");
			
			request.setAttribute("boards",boardDao.selectborad(free));
			request.setAttribute("board",free);
			request.setAttribute("User1", userInfo);
	
			
			if(free.equals("free")) {
			RequestDispatcher rd = request.getRequestDispatcher(
					"/Borad/FreeBoard.jsp");			
			rd.include(request, response);					
			
			} else if (free.equals("hobby")){
				RequestDispatcher rd = request.getRequestDispatcher(
						"/Borad/HobbyBoard.jsp");			
				rd.include(request, response);
			}
	} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String free = request.getParameter("no");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("loginInfo");
		request.setAttribute("User1", userInfo);
		
		
		try {
			
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			String count = request.getParameter("page");
			
			request.setAttribute("boards",boardDao.selectborad(free));
			request.setAttribute("board",free);

			request.setAttribute("page",count);
			if(free.equals("free")) {
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"/Borad/FreeBoard.jsp");			
			rd.include(request, response);					
			
			} else if (free.equals("hobby")){
			
				RequestDispatcher rd = request.getRequestDispatcher(
						"/Borad/HobbyBoard.jsp");			
				rd.include(request, response);
			}
	} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}
	
	
	
	
		
}
