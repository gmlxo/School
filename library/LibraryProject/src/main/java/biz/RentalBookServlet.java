package biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.RentDAO;
import vo.MemberVO;
import vo.RentVO;

@WebServlet("/rentalBook")
public class RentalBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RentalBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charest=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginOK");
		String userId = member.getMemberId();
		
		int bookNo;
		String strBookNo = request.getParameter("bookNo");
		if(strBookNo == null)
			bookNo = 0;
		else
			bookNo = Integer.parseInt(strBookNo);
		
		RentDAO rentDAO = new RentDAO();
		ArrayList<RentVO> rentList = null;
		RentVO rentVO = null;
		int ret = 0;
		
		BookDAO bookDAO = null;
		
		if(bookNo == 0) {
			rentList = (ArrayList<RentVO>)rentDAO.getRentalList(userId);
			if(rentList != null) {
				request.setAttribute("rent_list", rentList);
			}
			request.getRequestDispatcher("/book/lib-rental.jsp").forward(request, response);
		} else {
			rentVO = new RentVO();
			rentVO = rentDAO.makeRentData(userId, bookNo);
			if(rentVO != null) {
				ret = rentDAO.rentBook(rentVO);
				if(ret > 0) {
					bookDAO = new BookDAO();
					bookDAO.setRentalField(bookNo, "t");
				} else {
					out.println("<script> alert('도서 대여 실패'); history.back(); </script>");
				}
			} else {
				out.println("<script> alert('도서 대여 정보 생성 실패'); history.back(); </script>");
			}
			
			response.sendRedirect("/rentalBook");
		}
	}
}