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

	
	
	
	// 게시판에 댓글 추가할때..
	
	public int updateRelevel(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql = "update replyboard set relevel = relevel + 1 where regroup = ? and relevel > ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDto.getRegroup());
			pstmt.setInt(2, boardDto.getRelevel());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public int getMaxRegroup() {
		int result = 0;
		
		getConnection();
		
		String sql = "select nvl( max(regroup), 0 ) as regroupmax from replyboard";
		// 그룹에서 가장 큰 숫자를 가져오겠다. 하지만 null이면 1을 추가하겠다!!!!!!!!!!!!!!!!!!!!!!!!
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("regroupmax");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	public int writeBoard(BoardDto boardDto) {
		int result=0;
		int max= getMaxRegroup();
		//max++;
		getConnection();
		String sql = "insert into replyboard values(seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserID());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, max+1);
			pstmt.setInt(6, 1);
			pstmt.setInt(7, 1);
			
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public ArrayList<BoardDto> getList() {						// 원래 괄호에 int start, int end 가 들어가있었음
		ArrayList<BoardDto> boardList = null;
		
		getConnection();
//		String sql = "select * from"
//				+ "(select rownum as no,  b.* from "
//				+ "(select * from replyboard order by id desc) b) where no >= ? and no <= ?";		// 최신글이 맨 위로 올라오게 만들어줌... 정렬기능
		// id라는 것을 통해서 최신것부터 정렬하겠다..
		
		String sql = "select rownum as no,  b.* from (select * from replyboard order by regroup desc, relevel asc) b"; 
		
		
		try {
			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);									// 위에 int start, end를 넣어줘서 옆 코드에 매개변수를 쓸 수 있음...
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
				boardDto.setRegroup(rs.getInt("regroup"));
				boardDto.setRelevel(rs.getInt("relevel"));
				boardDto.setRestep(rs.getInt("restep"));
				boardDto.setAvailable(rs.getInt("available"));
				
				
				boardList.add(boardDto); // 위 boardList에 BoardDto를 넣어준다!
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public void updateHit(int id) {
		getConnection();
		String sql = "update replyboard set hit = hit + 1 where id = ?";
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
								
		BoardDto boardDto = null;
		updateHit(id); 					// 위의 updateHit(id)를 불러와서 실행이 되고나서 close 되고.. 아래 다시 연결되면서 게시판 글도 나옴
			getConnection();
			String sql= "select * from replyboard where id = ?";
			
			
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
					boardDto.setRegroup(rs.getInt("regroup"));
					boardDto.setRelevel(rs.getInt("relevel"));
					boardDto.setRestep(rs.getInt("restep"));
					boardDto.setAvailable(rs.getInt("available"));
				
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				close();
			}
		
		return boardDto;
	}

	public int deleteBoard(int id) {
		int result = 0;
		getConnection();
		
	//	String sql= "delete from replyboard where id = ?";
		String sql= "update replyboard set available = 0 where id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			result= pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int modifyBoard(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql = "update replyboard set title = ?, name = ?, contents = ? where id = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getContents());
			pstmt.setInt(4, boardDto.getId());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public double getTotal() {									//게시글 수 구함
		double total=0;
		getConnection();
		
		String sql = "select count(*) as total from replyboard";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return total;
	}

	public int replyBoard(BoardDto boardDto) {
		
		int result=0;
		int max= getMaxRegroup();
		max++;
		getConnection();
		String sql = "insert into replyboard values(seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserID());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getRegroup());
			pstmt.setInt(6, boardDto.getRelevel());
			pstmt.setInt(7, boardDto.getRestep());
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
}
