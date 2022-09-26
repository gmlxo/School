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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		MemberDAO dao = new MemberDAO();
		boolean isExist = dao.existID(request.getParameter("memberId"));
		int result = 0;

		if (isExist) {
			out.println("<script> alert('이미 존재하는 ID 입니다.'); </script>");
		} else {
			MemberVO data = new MemberVO();
			data.setMemberId(request.getParameter("memberId"));
			data.setMemberPw(request.getParameter("memberPw"));
			data.setMemberName(request.getParameter("name"));
			data.setMemberAddr(request.getParameter("addr"));
			data.setMemberAge(Integer.parseInt(request.getParameter("age")));

			result = dao.insertMember(data);
			if (result > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("loginOK", data);
				out.println("<script> alert('로그인 성공'); </script>");
			} else
				out.println("<script> alert('로그인 실패'); </script>");
			
			response.sendRedirect("/index.jsp");
		}
	}

}