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
import Scarch_dao.UserDao;
import Scarch_vo.Friend;


@WebServlet("/BoardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
			ServletContext sc = this.getServletContext();
			HttpSession session = request.getSession();
			response.setContentType("text/html; charset=UTF-8"); 
			RequestDispatcher rd = request.getRequestDispatcher(
				"/Borad/BoradList.jsp");	
		rd.include(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

