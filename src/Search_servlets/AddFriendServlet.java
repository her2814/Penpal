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

import Scarch_vo.Friend;
import Scarch_vo.User;

@WebServlet("/addfriend")
public class AddFriendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			ServletContext sc = this.getServletContext();
	
			FriendDao friendDao = (FriendDao) sc.getAttribute("friendDao");		

			HttpSession session = request.getSession();
			
			User userInfo = (User) session.getAttribute("loginInfo");
			
			if(userInfo.getId()==null) {
				JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.");
				response.sendRedirect("Login");
			}
			String userId = userInfo.getId();
			String fr_id = request.getParameter("no");
			response.setContentType("text/html; charset=UTF-8");
		
			Friend f = friendDao.selectFriend(userId, fr_id);
			
			if(f==null) {	
			friendDao.insertFriend(userId, fr_id);
			JOptionPane.showMessageDialog(null, "친구추가가 되었습니다.");
			RequestDispatcher rd = request.getRequestDispatcher(
					"searchDetail");
			rd.include(request, response);
			}
			
			else {
				JOptionPane.showMessageDialog(null, "이미 친구입니다.");
		
				RequestDispatcher rd = request.getRequestDispatcher(
						"searchDetail");
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
