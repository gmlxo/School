package biz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/insertBook")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		BookVO vo = new BookVO();
		vo.setIsbn(request.getParameter("isbn"));
		vo.setTitle(request.getParameter("title"));
		vo.setAuthor(request.getParameter("author"));
		vo.setCompany(request.getParameter("company"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));

		BookDAO dao = new BookDAO();
		int n = dao.insertBook(vo);

		if (n > 0)
			response.sendRedirect("/listBook");
		else
			response.sendRedirect("/book/bookInsert.jsp");
	}
}
