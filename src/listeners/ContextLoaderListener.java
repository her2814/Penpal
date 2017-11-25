package listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;

import javax.servlet.annotation.WebListener;

import Board_dao.BoardDao;
import Scarch_dao.FriendDao;
import Scarch_dao.MailDao;
import Scarch_dao.UserDao;




@WebListener
public class ContextLoaderListener implements ServletContextListener {
  Connection conn;
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext sc = event.getServletContext();

      Class.forName(sc.getInitParameter("driver"));
      conn = DriverManager.getConnection(
          sc.getInitParameter("url"),
          sc.getInitParameter("username"),
          sc.getInitParameter("password"));

      UserDao userDao = new UserDao();
      userDao.getConnection(conn);
      sc.setAttribute("userDao", userDao);
      
      FriendDao friendDao = new FriendDao();
      friendDao.getConnection(conn);
      sc.setAttribute("friendDao", friendDao);

      MailDao mailDao = new MailDao();
      mailDao.getConnection(conn);
      sc.setAttribute("mailDao", mailDao);
      
      BoardDao boardDao = new BoardDao();
      boardDao.getConnection(conn);
      sc.setAttribute("boardDao", boardDao);
      
      
      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    try {
      conn.close();
    } catch (Exception e) {}
  }
}