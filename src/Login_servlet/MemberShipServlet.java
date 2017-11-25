package Login_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.oreilly.servlet.MultipartRequest;

import Scarch_dao.UserDao;
import Scarch_vo.User;


@WebServlet("/MemberShip" )
public class MemberShipServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/Login/MemberShip.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/Photo");
			
		MultipartRequest multi = new MultipartRequest(request, path);
		ServletContext sc = this.getServletContext();
		
		String id = multi.getParameter("id");
		String password = multi.getParameter("password");
		String name = multi.getParameter("name");
		String age = multi.getParameter("age");
		String hobby = multi.getParameter("hobby");
		String nationality = multi.getParameter("nationality");
		String message = multi.getParameter("message");
		String address = multi.getParameter("address");
		String language = multi.getParameter("language");
		String religion = multi.getParameter("religion");
		String job = multi.getParameter("job");
		String email = multi.getParameter("email");
		String question = multi.getParameter("question");
		String answer = multi.getParameter("answer");
	
		
		String user[] = {id,name,hobby,nationality,message,address,language,religion,job,answer};
		for(int i = 0; i < user.length; i++) {
			user[i] = new String(user[i].getBytes("8859_1"), "utf-8");
		}


		User users = new User()
		.setId(user[0])
		.setPassword(password)
		.setName(user[1])
		.setAge(Integer.parseInt(age))
		.setHobby(user[2])
		.setNationality(user[3])
		.setMessage(user[4])
		.setAddress(user[5])
		.setLanguage(user[6])
		.setReligion(user[7])
		.setJob(user[8])
		.setEmail(email)
		.setQuestion(Integer.parseInt(question))
		.setAnswer(user[9])
		.setPhoto(multi.getFilesystemName("photo"));
		
		UserDao userDao = (UserDao)sc.getAttribute("userDao");
		
		
		try {
			userDao.insertUser(users);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		PrintWriter out1 = response.getWriter(); //선언
   
		   String str="";
		   str = "<script language='javascript'>";
		   str += "self.close();";   // 창닫기
		    str += "</script>";
		   out1.print(str);

	}

}
