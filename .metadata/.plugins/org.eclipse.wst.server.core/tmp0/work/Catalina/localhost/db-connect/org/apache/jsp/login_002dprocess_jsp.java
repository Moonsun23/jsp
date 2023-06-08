/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-06-08 01:52:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class login_002dprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	// jsp는 respond와 request같은 내장객체를 이미 가지고 있어서 선언을 따로 안해도 된다.

	String driver = "oracle.jdbc.OracleDriver";
	String url= "jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw= "1234";
	// db로 넘기는 과정..
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from register where id = ? and password= ?";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	rs= pstmt.executeQuery();
	
	// response.setContentType("text/html;charset=utf-8");
	// 위 행을 써줘야 콘솔창에 한글이 뜸
	
	
	// 4개의 scope 가 있음
	// pageContext <request <session <application => 유효범위의 순서...
	// pageContext 한페이지 내에서 처리..
	// request로 속성처리..
	// session-> 내가 없애기 전까지 유효한 서버...(값을 넘길 수 있다..)
	// application -> 계속 같이 가는 ...서버?
			
			// 주로 request랑 session을 주로 쓴다..
	
	
	if(rs.next()){
		String userId= rs.getString("id");
		String userPw= rs.getString("password");
		String userName=rs.getString("name");
		
		// pageContext.setAttribute("pageUserId", userId);
		// 주소창에 안실리고 내부적으로.. 
		//request.setAttribute("userId", userId);
		// userId는 userId 값을 받아서..
		session.setAttribute("loggedUserId", userId);
		// 직접 주소창을 바꾸는거!// 특정 페이지로 넘기는 것.
		// 로그인 상태로 유지시켜줌/./.!
		session.setAttribute("loggedUserName", userName);
		
		
		//request.getRequestDispatcher("login-ok.jsp").forward(request, response);
		// 반드시 forward를 시켜야 값이 넘어간다...
		// forward- 서버가 페이지를 바꿀 수 있다면..
		
		
		
		// response.sendRedirect("login-ok.jsp?userId="+userId);
		//페이지 자체를 바꾸는...sendRedirect		
		
		System.out.println(request.getParameter(userId));
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-ok.jsp");
		// login-ok 파일에 있는 내용을 그대로 가져와서 쓰는 것.
		dispatcher.forward(request, response); //위에 forward 있는 부분과 동일한 내용...
		
		
	//	out.println("로그인 성공");	
	
	}else{
		//out.println("로그인 실패");
	}
	

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
