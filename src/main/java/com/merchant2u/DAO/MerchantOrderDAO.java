package com.merchant2u.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.merchant2u.model.MerchantOrder;

public class MerchantOrderDAO {

	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	PreparedStatement preparedStatement =null;

	public boolean checkOrder(String id) {
		boolean found = false;
		try {
		String sql = "SELECT id FROM merchant_orders where id='" + id +"'";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
		found = true;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return found;
		}
	
	
	public boolean newOrder(MerchantOrder order) {
		boolean flag = false;
		try {
		String sql = "INSERT INTO merchant_orders VALUES (0, '" + order.getMobile_number()  + "', '" + order.getOperator()  + "', '" + order.getAmount()  + "', '" + order.getBank_name()  + "', '" + order.getAccount_number()  + "', 'New', SYSDATE)";

		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return flag;
		}
	
	public MerchantOrder getRecord(String acc) {
		MerchantOrder order = null;
		try {
			order = new MerchantOrder();
		String sql = "SELECT "
				+ "id,"
				+ "mobile_number,"
				+ "operator,"
				+ "amount,"
				+ "bank_name,"
				+ "account_number,"
				+ "status,"
				+ "created_date "
				+ "FROM merchant_orders "
				+ "where account_number='" + acc +"' and status='New' and ROWNUM <= 1 order by id desc";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			order.setId(resultSet.getString("id"));
			order.setMobile_number("mobile_number");
			order.setOperator(resultSet.getString("operator"));
			order.setAmount(resultSet.getString("amount"));
			order.setBank_name(resultSet.getString("bank_name"));
			order.setAccount_number(resultSet.getString("account_number"));
			order.setStatus(resultSet.getString("status"));
			order.setCreated_date(resultSet.getString("created_date"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return order;
		}
	
//	public List<MerchantOrder> getRecord(String acc) {
//		List<MerchantOrder> list = null;
//		MerchantOrder order = new MerchantOrder();
//
//		try {
//			list = new ArrayList<MerchantOrder>();
//			String sql = "SELECT "
//					+ "id,"
//					+ "mobile_number,"
//					+ "operator,"
//					+ "amount,"
//					+ "bank_name,"
//					+ "account_number,"
//					+ "status,"
//					+ "created_date "
//					+ "FROM merchant_orders "
//					+ "where account_number='" + acc +"' and status='New' and ROWNUM <= 1 order by id desc";
//			connection = DBConnectionUtil.openConnection();
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(sql);
//
//			while (resultSet.next()) {
//				order = new MerchantOrder();
//				order.setId(resultSet.getString("id"));
//				order.setMobile_number(resultSet.getString("mobile_number"));
//				order.setOperator(resultSet.getString("operator"));
//				order.setAmount(resultSet.getDouble("amount"));
//				order.setBank_name(resultSet.getString("bank_name"));
//				order.setAccount_number(resultSet.getString("account_number"));
//				order.setStatus(resultSet.getString("status"));
//				order.setCreated_date(resultSet.getString("created_date"));
//				list.add(order);
//			}
//		} catch (Exception e) {
//		}
//
//		return list;
//	}	
	

	public MerchantOrder getOrder(String id) {
		MerchantOrder order = null;
		try {
			order = new MerchantOrder();
		String sql = "SELECT "
				+ "id,"
				+ "mobile_number,"
				+ "operator,"
				+ "amount,"
				+ "bank_name,"
				+ "account_number,"
				+ "status,"
				+ "created_date "
				+ "FROM merchant_orders "
				+ "where id='" + id +"'";
		connection = DBConnectionUtil.openConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {

		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return order;
		}
	
	public boolean updateOrder(String id) {		
		boolean flag = false;
		try {
			
			String sql = "UPDATE merchant_orders SET "		
					+ "status = 'Paid' "
					+ "where id = '" + id + "'";
	
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql.replace("\"", "'"));
			
			//System.out.println(sql);
			
			int i = preparedStatement.executeUpdate();
	        if (i > 0) {
	        	flag = true;
	        } else {
	        	flag = false;
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
			return flag;
	}
	

}
