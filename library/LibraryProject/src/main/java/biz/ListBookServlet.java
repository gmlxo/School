package biz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.BookVO;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/listBook")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("book_title");
		
		MemberDAO dao = new MemberDAO();
		ArrayList<BookVO> list = dao.getBookList(key);
		
		if(list != null) {
			request.setAttribute("booklist", list);
		}
		request.getRequestDispatcher("/book/bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}