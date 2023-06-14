package com.hi1237.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url= "jdbc:oracle:thin:@localhost:1521:xe";
	private String id="hi1237";
	private String pw= "1234";
	// db로 넘기는 과정..
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	// MVC -> design pattern
	
	private void getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void close() {
		try {
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int writeBoard(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,sysdate,0)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserID());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public ArrayList<BoardDto> getList() {
		ArrayList<BoardDto> boardList = null;
		
		getConnection();
		String sql = "select * from board order by id desc";		// 최신글이 맨 위로 올라오게 만들어줌...
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			boardList= new ArrayList<BoardDto>();  					// <> 안에는 안써도 됨
			
			while(rs.next()) {
				BoardDto boardDto= new BoardDto();
				boardDto.setId(rs.getInt("id")); 					// 값을 담는거니까 set
				boardDto.setUserID(rs.getString("userId"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regDate")); 		// column명은 대소문자 구분 없어서 걍 써도된다
				boardDto.setHit(rs.getInt("hit"));
				boardList.add(boardDto); // 위 boardList에 BoardDto를 넣어준다!
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public void updateHit(int id) {
		String sql = "update board set hit = hit + 1 where id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			close();
		}
		
		
	}

	public BoardDto getView(int id) {
		updateHit(id);						// 위의 updateHit(id)를 불러와서 실행이 되고나서 close 되고.. 아래 다시 BoardDto가 실행되면서 게시판 글도 나옴
		BoardDto boardDto = null;
			getConnection();
			String sql= "select * from board where id = ?";
			
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					boardDto= new BoardDto();
					boardDto.setId(rs.getInt("id"));
					boardDto.setUserID(rs.getString("userId"));
					boardDto.setName(rs.getString("name"));
					boardDto.setTitle(rs.getString("title"));
					boardDto.setContents(rs.getString("contents"));
					boardDto.setRegDate(rs.getString("regDate")); 		// column명은 대소문자 구분 없어서 걍 써도된다
					boardDto.setHit(rs.getInt("hit"));
				
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				close();
			}
		
		return boardDto;
	}
	
	
	
	
	
	
	
	
	
}
