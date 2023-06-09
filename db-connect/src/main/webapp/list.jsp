<%@page import="com.hi1237.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="hi1237";
		String pw="1234";
		// string id, pw는 db의 사용자 이름을쓰는 것! 다른것과 오해 XX
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from board";
		
		Class.forName(driver);
		// 아래.. driver connection을 통해 jsp와 db를 연결시켜 줘야 한다!!! jsp와 db는 직접 연결이 안된다.
		conn= DriverManager.getConnection(url, id, pw);
		pstmt=conn.prepareStatement(sql);
		
		rs=pstmt.executeQuery();
		ArrayList<BoardDto> boardList = new ArrayList<>();
		while(rs.next()){
			BoardDto boardDto = new BoardDto(); // 기본생성자를 만들어줘야 new BoardDto에 에러가 사라짐..(BoardDto에)
			boardDto.setId(rs.getInt("id"));
			boardDto.setName(rs.getString("name"));
			boardDto.setTitle(rs.getString("title"));
			boardDto.setContents(rs.getString("contents"));
			boardDto.setDate(rs.getString("regdate"));
			boardDto.setHit(rs.getInt("hit"));
			boardList.add(boardDto);
		}

%>
    
<%@ include file= "include/header.jsp" %>
	<div class="container">
		<ul>
			<li>
				<span>1</span>
				<span>제목</span>
				<span>장문선</span>
				<span>2023/06/09</span>
				<span>0</span>				
			</li>
			
		</ul>
		
	</div>


<%@ include file= "include/footer.jsp" %>