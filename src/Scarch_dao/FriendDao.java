package Scarch_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Scarch_vo.Friend;


public class FriendDao {
Connection connection;

	public Friend selectFriend(String id,String fr) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null;
			try {
				stmt = connection.prepareStatement(
						"SELECT userID,friendID"
						+ " FROM friend"
						+ " where userID=? and friendID=?");
				stmt.setString(1,id);
				stmt.setString(2,fr);
				rs = stmt.executeQuery();
	
				if (rs.next()) {
					return new Friend().setUserID(rs.getString("userID"))
					        .setFriendID(rs.getString("friendID"));
				}	
		} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	return null;
	}




	public void insertFriend(String userId,String freindId) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null; 

		try {
			stmt = connection.prepareStatement("insert into friend values(?,?)");
			stmt.setString(1, userId);
			stmt.setString(2, freindId);
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
