package Board_dao;


import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Board_vo.BoardVO;

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
						"SELECT postNo,hits,writerID,like,postname,uploadDay,postContent,postphoto"
						+ " FROM board"
						+ " where like=?");
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

}

