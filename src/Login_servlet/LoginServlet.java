package Login_servlet;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

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

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			RequestDispatcher rd = request.getRequestDispatcher(
					"/Login/LoginPage.jsp");
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
		String id, password;
		
		ServletContext sc = this.getServletContext();
		UserDao userDao = (UserDao)sc.getAttribute("userDao");

		try {
		id = request.getParameter("id");
		password = request.getParameter("password");
		
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("loginInfo",  userDao.loginCheck(id, password));
			if(session.getAttribute("loginInfo")!=null) {
				response.sendRedirect("Main");
			}
			else {
				JOptionPane.showMessageDialog(null, "아이디/비밀번호가 일치하지 않습니다.");
				response.sendRedirect("Login");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}

}
