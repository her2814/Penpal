package Search_servlets;

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

import Scarch_dao.FriendDao;
import Scarch_dao.MailDao;
import Scarch_dao.UserDao;
import Scarch_vo.Mail;
import Scarch_vo.User;


@WebServlet("/sendMessage")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8"); 
		User userInfo = (User) session.getAttribute("loginInfo");
		if(userInfo.getId()==null) {
			JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.");
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
			return;
		}
		String recverID = request.getParameter("no");
		
		request.setAttribute("recverInfo", recverID);
		RequestDispatcher rd = request.getRequestDispatcher("/mail/MailPage.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext sc = this.getServletContext();
		MailDao mailDao = (MailDao)sc.getAttribute("mailDao");		
		
		HttpSession session = request.getSession();
	
		
		User user = (User) session.getAttribute("loginInfo");
		String senderID = user.getId(); 
		String recverID = request.getParameter("recvID"); 
		String title = request.getParameter("title"); 
		String content = request.getParameter("content"); 
		
		Mail mail = new Mail().setSenderld(senderID).setRecverld(recverID).setMailName(title).setMailContent(content);
		
		try {
			mailDao.sendMessage(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "메일이 전송되었습니다.");
		response.sendRedirect("Main");

	}

}
