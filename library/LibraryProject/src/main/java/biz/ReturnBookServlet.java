package biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.RentDAO;

@WebServlet("/rentalBook")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReturnBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charest=utf-8");
		PrintWriter out = response.getWriter();
		
		int bookNo;
		String strBookNo = request.getParameter("bookNo");
		if(strBookNo == null) 
			bookNo = 0;
		else 
			bookNo = Integer.parseInt(strBookNo);
		
		RentDAO rentDAO = new RentDAO();
		BookDAO bookDAO = null;
		int ret = rentDAO.deleteRent(bookNo);
		if(ret > 0) {
			bookDAO = new BookDAO();
			bookDAO.setRentalField(bookNo, "f");
		} else {
			out.println("<script> alert('도서 반납 실패'); history.back(); </script>");
		}
		
		response.sendRedirect("/rentalBook");
	}
}