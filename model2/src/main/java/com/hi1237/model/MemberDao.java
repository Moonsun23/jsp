package com.hi1237.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
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
	
	public int insertMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		// db에 연결시켜주는 부분
		String sql="insert into register values(?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  memberDto.getId());
			pstmt.setString(2,  memberDto.getName());
			pstmt.setString(3,  memberDto.getPassword());
			pstmt.setString(4,  memberDto.getEmail());
			pstmt.setInt(5,  memberDto.getZonecode());
			pstmt.setString(6,  memberDto.getAddress());
			pstmt.setString(7,  memberDto.getDetailAddress());
			pstmt.setString(8,  memberDto.getExtraAddress());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
		// return 타입이 있는거니까...
	}
	
	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedMemberDto = null;
		getConnection();
		String sql = "select * from register where id = ? and password = ?";		// sql도 내맘대로 쓰는 부분
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				loggedMemberDto = new MemberDto();
				String userId= rs.getString("id");
				String userName= rs.getString("name");
				loggedMemberDto.setId(userId);
				loggedMemberDto.setName(userName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return loggedMemberDto;
	}
}














