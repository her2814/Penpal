package Scarch_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Scarch_vo.Mail;

public class MailDao {
	Connection connection;

	public void sendMessage(Mail mail) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null; 

		try {
			stmt = connection.prepareStatement("insert into mail(senderID,recverID,mailName,mailContent,sendDate) values(?,?,?,?,now())");
			
			stmt.setString(1, mail.getSenderld());
			stmt.setString(2, mail.getRecverld());
			stmt.setString(3, mail.getMailName());
			stmt.setString(4, mail.getMailContent());
			
			stmt.executeUpdate();
		  
			   
	} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	}
	
	public void getConnection(Connection conn) {
		this.connection = conn;
	}

}
