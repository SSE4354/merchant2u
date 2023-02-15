package com.merchant2u;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.merchant2u.model.MerchantOrder;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merchant2u.DAO.MerchantOrderDAO;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MerchantOrderDAO merchantOrderDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
		super();
		// TODO Auto-generated constructor stub
		merchantOrderDAO = new MerchantOrderDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String a = request.getParameter("a");
		switch (a) {
		case "bank":
			order(request, response);
			break;
		case "pay":
			pay(request, response);
			break;
		default:
			order(request, response);
		}

	}

	private void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MerchantOrder u = new MerchantOrder();
		u.setMobile_number(request.getParameter("mobile_number"));
		u.setOperator(request.getParameter("operator"));
		u.setAmount(request.getParameter("amount"));
		u.setBank_name(request.getParameter("bank_name"));
		u.setAccount_number(request.getParameter("account_number"));
		

		if (merchantOrderDAO.newOrder(u)) {
			request.setAttribute("notification", "Order accepted!");
			request.setAttribute("color", "success");

			if(requestOtp(u.getAccount_number())) {
				response.getWriter().append("Request OTP");
				request.setAttribute("notification", "Please check your email to get the OTP.");
				request.setAttribute("color", "primary");				
			} else {
				response.getWriter().append("Order Failed!");
				request.setAttribute("notification", "Failed to get OTP.");
				request.setAttribute("color", "danger");				
			}
			
			request.setAttribute("order", u);
			RequestDispatcher rd = request.getRequestDispatcher("/bank.jsp");
			rd.forward(request, response);

		} else {
			response.getWriter().append("Order Failed!");
			request.setAttribute("notification", "Order Failed!");
			request.setAttribute("color", "danger");
		}

	}

	public boolean requestOtp(String account_number) throws IOException {

		URL url = new URL("http://localhost:8080/MYBANK2U/Merchant?task=otp&acc=" + account_number);
		ObjectMapper mapper = new ObjectMapper();
		mapper.readTree(url);
		return true;
	}
	
	private void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		URL url = new URL("http://localhost:8080/MYBANK2U/Merchant?task=pay&acc="+request.getParameter("account_number")+"&otp="+request.getParameter("otp")+"&amount="+request.getParameter("amount"));

		ObjectMapper mapper = new ObjectMapper();

		JsonNode node = mapper.readTree(url);
		String success = node.get("success").toString();
		String message = node.get("message").toString().replace("\"", "");
		String status = node.get("status").toString().replace("\"", "");

		
		request.setAttribute("notification", "");
		request.setAttribute("color", "");

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(200);
		
		boolean s = Boolean.parseBoolean(success.replace("\"", ""));
		
		if(s) {
			
			String balance = node.get("balance").toString().replace("\"", "");
			String pin = node.get("pin").toString().replace("\"", "");

			MerchantOrderDAO dao = new MerchantOrderDAO();
			MerchantOrder theOrder = dao.getRecord(request.getParameter("account_number"));
			dao.updateOrder(theOrder.getId());
			
			request.setAttribute("order", theOrder);

			request.setAttribute("balance", balance);
			request.setAttribute("pin", pin);
			request.setAttribute("notification", message);
			request.setAttribute("color", "success");
			
			RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
			
		} else {			
			request.setAttribute("notification", message);
			request.setAttribute("color", "danger");
			RequestDispatcher rd = request.getRequestDispatcher("/TopUp");
			rd.forward(request, response);
		}
		
		out.flush(); 
}	
	
}
