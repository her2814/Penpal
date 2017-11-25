package Board_dao;


import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Board_vo.BoardVO;
import Scarch_vo.Friend;

public class BoardDao {
	Connection connection;
	
	public void getConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.connection = conn;
	}

	public ArrayList<BoardVO> selectborad(String like) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null;
			try {
				stmt = connection.prepareStatement(
						"SELECT postNo,hits,writerID,like_a,postname,uploadDay,postContent,postphoto"
						+ " FROM board"
						+ " where like_a=?");
				stmt.setString(1,like);
				rs = stmt.executeQuery();
				ArrayList<BoardVO> boards = new ArrayList<BoardVO>();	
				
				while(rs.next()) { 
					 boards.add(new BoardVO()
							.setPostNo(rs.getInt("postNo"))
							.setHits(rs.getString("hits"))
							.setWriterID(rs.getString("writerID"))
							.setLike(rs.getString("like_a"))
							.setPostname(rs.getString("postname"))
							.setUploadDay(rs.getString("uploadDay"))
							.setPostContent(rs.getString("postContent"))
							.setPhoto(rs.getString("postphoto")));
						}
				Collections.reverse(boards);
				
					       return boards;

		} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	}
	
	
	public BoardVO selectDetailborad(String id) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null;
			try {
				stmt = connection.prepareStatement(
						"SELECT postNo,hits,writerID,like_a,postname,uploadDay,postContent,postphoto"
						+ " FROM board"
						+ " where PostNo=?");
				stmt.setString(1,id);
				rs = stmt.executeQuery();
		
				
				if (rs.next()) {
					return new BoardVO().setPostNo(rs.getInt("postNo"))
							.setHits(rs.getString("hits"))
							.setWriterID(rs.getString("writerID"))
							.setLike(rs.getString("like_a"))
							.setPostname(rs.getString("postname"))
							.setUploadDay(rs.getString("uploadDay"))
							.setPostContent(rs.getString("postContent"))
							.setPhoto(rs.getString("postphoto"));
				}	
				
		} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
			return null;
	}
	
	
	public void insertBoard(BoardVO board) throws Exception {
		PreparedStatement stmt = null; 
		ResultSet rs = null; 

		
		try {

			stmt = connection.prepareStatement("insert into board (hits,writerID,like_a,postname,uploadDay,postContent,postphoto) values(1,?,?,?,now(),?,?)");
			stmt.setString(1,board.getWriterID());
			stmt.setString(2,board.getLike());
			stmt.setString(3,board.getPostname());
			stmt.setString(4,board.getPostContent());
			stmt.setString(5,"./Photo/"+board.getPhoto());		
			stmt.executeUpdate();
			   
			
			
	} catch (Exception e) {
		throw e;
	} finally {
		try {if (rs != null) rs.close();} catch(Exception e) {}
		try {if (stmt != null) rs.close();} catch(Exception e) {}
		}
	}
}

