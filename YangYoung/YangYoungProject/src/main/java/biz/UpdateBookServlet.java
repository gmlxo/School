package biz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charest=utf-8");
		String isbn = request.getParameter("isbn");

		BookDAO dao = new BookDAO();
		BookVO vo = dao.getBookData(isbn);

		if (vo != null) {
			request.setAttribute("selectBook", vo);
			request.getRequestDispatcher("/book/bookUpdate.jsp").forward(request, response);
		}else {
			response.sendRedirect("/book/bookList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charest=utf-8");
		
		BookVO vo = new BookVO();
		vo.setIsbn(request.getParameter("isbn"));
		vo.setTitle(request.getParameter("title"));
		vo.setAuthor(request.getParameter("author"));
		vo.setCompany(request.getParameter("company"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));

		BookDAO dao = new BookDAO();
		int n = dao.updateBook(vo);
		
		if(n>0)
			response.sendRedirect("/listBook");
		else
			response.sendRedirect("/book/bookUpdate.jsp");
	}

}