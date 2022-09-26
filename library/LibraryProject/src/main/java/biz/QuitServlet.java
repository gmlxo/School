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

@WebServlet("/quit")
public class QuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html charest=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginOK");
		int result = 0;

		if (user == null) {
			out.print("<script> alert('사용자 정보가 없어 회원탈퇴를 진행할 수 없습니다'); history.back(); </scrit>");
		}  else {
			MemberDAO dao = new MemberDAO();
			result = dao.removeMember(user.getMemberId());
			String msg;
			
			if(result>0) {
				msg = user.getMemberName() + " 님의 회원정보가 삭제었습니다";
			} else {
				msg = user.getMemberName() + " 님의 회원정보가 삭제의 실패했습니다";
			}
			
			session.setAttribute("quit", msg);
			response.sendRedirect("/member/quitResult.jsp");
			
		}
	}

}
