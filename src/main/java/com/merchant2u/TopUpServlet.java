package com.merchant2u;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.merchant2u.DAO.MerchantOrderDAO;

/**
 * Servlet implementation class TopUpServlet
 */
@WebServlet("/TopUp")
public class TopUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MerchantOrderDAO orderDAO = null;
	RequestDispatcher rd = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopUpServlet() {
        //super();
        // TODO Auto-generated constructor stub
    	orderDAO = new MerchantOrderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		rd = request.getRequestDispatcher("/topup.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
