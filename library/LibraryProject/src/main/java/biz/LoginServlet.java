package biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id, pw;
		MemberVO vo = null;
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		vo = dao.getMemberDate(id);
		
		if(vo == null || !pw.equals(vo.getMemberPw())) {
			out.println("<script> arert('회원정보가 맞지 않습니다.'); history.back(); </script>");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginOK", vo);
			response.sendRedirect("/login/loginOK.jsp");
		}
	}
}