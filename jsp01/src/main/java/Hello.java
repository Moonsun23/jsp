

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Hello() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name= request.getParameter("name");
//		// parameter로 가져오는건 무조건 String
		int num01= Integer.parseInt(request.getParameter("num01"));
		int num02= Integer.parseInt(request.getParameter("num02"));
		int sum=num01+num02;
		
		
		/* 아래와 같이 쓰면.. 결과값이 안나온다.. String 값은 null 값으로 받을 수 없기 때문에
		int num01=0;
		int num02=0;
		
//		// parameter로 가져오는건 무조건 String
		num01= Integer.parseInt(request.getParameter("num01"));
		num02= Integer.parseInt(request.getParameter("num02"));
		int sum=num01+num02;
		 */
		
		
		PrintWriter out= response.getWriter();
		// 응답을 해야해서 써주는 코드
		// 서버는 요청/응답 2개를 할 수 있다...
//		out.println("hello servlet");
		
		// html의 내용을 가져오려면 모두 하나하나 out.println으로 출력 요청을 해줘야 한다...
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+name+"hello servlet</h1>");
		out.println("<h2>"+num01+"+"+num02+"="+sum+"</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	
		
		
		
		
		
		
	}

}
