package MyPage_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Scarch_dao.UserDao;
import Scarch_vo.User;

/**
 * Servlet implementation class MyPageservlet
 */
@WebServlet("/MyPage")
public class MyPageservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			request.setCharacterEncoding("UTF-8");
			String id;
			
			ServletContext sc = this.getServletContext();
			UserDao userDao = (UserDao)sc.getAttribute("userDao");
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute("loginInfo");
			if(userInfo.getId()==null) {
				JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.");
				response.sendRedirect("Login");
			}			
			request.setAttribute("users", userDao.selectFiendProFile(userInfo.getId()));
			
			response.setContentType("text/html; charset=UTF-8"); 
	
			RequestDispatcher rd = request.getRequestDispatcher(
					"/MyPage/MyPage.jsp");
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
