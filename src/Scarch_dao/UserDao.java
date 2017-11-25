package Scarch_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Scarch_vo.User;


public class UserDao {
	Connection connection;

	public User selectUserID(String email) throws Exception {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.prepareStatement(
					"SELECT id FROM user WHERE email=?"
					);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new User().setId(rs.getString("id"));
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			try { if(rs!=null) rs.close(); } catch (Exception e) {}
			try { if(stmt!=null) stmt.close(); } catch (Exception e) {}
		}
	}
	
	
	
	public User loginCheck(String id, String password) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		
		try {
			stmt = connection.prepareStatement(
					"SELECT id,name FROM user WHERE id=? and password=?"
					);
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new User().setId(rs.getString("id")).setName(rs.getString("name"));
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			try { if(rs!=null) rs.close(); } catch (Exception e) {}
			try { if(stmt!=null) stmt.close(); } catch (Exception e) {}
		}
		
	}
	
	public User selectFiendProFile(String id) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null;
	try {
		stmt = connection.prepareStatement(
				"SELECT id,name,age,hobby,nationality,message,address,language,religion,job,admin_flag,email,suspension,photo"
						+ " FROM user"
						+ " where id=?");
				stmt.setString(1,id);
				rs = stmt.executeQuery();
		
				if (rs.next()) {
					User users = new User()
							.setId(rs.getString("id"))
					        .setName(rs.getString("name"))
					        .setAge(rs.getInt("age"))
					        .setHobby(rs.getString("hobby"))
					        .setNationality(rs.getString("nationality"))
					        .setMessage(rs.getString("message"))
					        .setAddress(rs.getString("address"))
					        .setLanguage(rs.getString("language"))
					        .setReligion(rs.getString("religion"))
					        .setJob(rs.getString("job"))
					        .setAdmin_flag(rs.getString("admin_flag"))
					        .setEmail(rs.getString("email"))
					        .setSuspension(rs.getString("suspension"))
					        .setPhoto(rs.getString("photo")); 
					return users;
				}
	
	} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	return null;
	}
	
	public List<User> friendselectList(String hobby, String nationalty) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		try {
			stmt = connection.prepareStatement(
					"SELECT id,name,age,hobby,nationality,message,address,language,religion,job,admin_flag,email,suspension,photo"
					+ " FROM user"
					+ " where hobby=? and nationality=?");
			stmt.setString(1,hobby);
			stmt.setString(2,nationalty);
							
			rs = stmt.executeQuery();
			ArrayList<User> users = new ArrayList<User>();			
			   
			while(rs.next()) { 
				        users.add(new User() 
				        .setId(rs.getString("id"))
				        .setName(rs.getString("name"))
				        .setAge(rs.getInt("age"))
				        .setHobby(rs.getString("hobby"))
				        .setNationality(rs.getString("nationality"))
				        .setMessage(rs.getString("message"))
				        .setAddress(rs.getString("address"))
				        .setLanguage(rs.getString("language"))
				        .setReligion(rs.getString("religion"))
				        .setJob(rs.getString("job"))
				        .setAdmin_flag(rs.getString("admin_flag"))
				        .setEmail(rs.getString("email"))
				        .setSuspension(rs.getString("suspension"))
				        .setPhoto(rs.getString("photo"))); 
				       }
			long seed = System.nanoTime();
			Collections.shuffle(users,new Random(seed));
		return users;
	} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	}

	public void getConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.connection = conn;
	}
	
	public void insertUser(User user) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null; 

		
		try {
			stmt = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?,?,'0',?,?,?,'0',?)");
			stmt.setString(1,user.getId());
			stmt.setString(2,user.getName());
			stmt.setString(3,user.getPassword());
			stmt.setInt(4,user.getAge());
			stmt.setString(5,user.getHobby());
			stmt.setString(6,user.getNationality());
			stmt.setString(7,user.getMessage());
			stmt.setString(8,user.getAddress());
			stmt.setString(9,user.getLanguage());
			stmt.setString(10,user.getReligion());
			stmt.setString(11,user.getJob());
			stmt.setString(12,user.getEmail());
			stmt.setInt(13,user.getQuestion());
			stmt.setString(14,user.getAnswer());
			stmt.setString(15,"./Photo/"+user.getPhoto());
			
			stmt.executeUpdate();
			   
			
			
	} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	}
	


}
