package CONN.Wipro.Flight.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import CONN.Wipro.Flight.Bean.Sales;
import CONN.Wipro.Flight.Bean.SalesReport;
import CONN.Wipro.Flight.Util.DBUtil;
public class SalesDao {
	
public static String generateSalesID(java.util.Date date)throws SQLException {
	 Connection con=DBUtil.getDBConnection();
	 PreparedStatement ps;
	ps=con.prepareStatement("select SEQ_SALES_ID.nextval from dual");
	ResultSet rs=ps.executeQuery();
	Calendar cal=Calendar.getInstance();
	cal.setTime(date);
	int year=cal.get(Calendar.YEAR);
	if(rs.next()) {
		return ""+(year%100)+rs.getInt(1);
	}
	return "";
}
public static ArrayList<SalesReport> getSalesReport(){
	  ArrayList<SalesReport> sr = new ArrayList<SalesReport>();
	  Connection con=DBUtil.getDBConnection();
	  try {
	    PreparedStatement ps = con.prepareStatement("select * from V_SALES_REPORT");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	      SalesReport s1=new SalesReport();
	      s1.setSalesID(rs.getString(1));
	      s1.setSalesDate(rs.getDate(2));
	      s1.setProductID(rs.getString(3));
	      s1.setProductNmae(rs.getString(4));
	      s1.setQuantitySold(rs.getInt(5));
	      s1.setProductUnitPrice(rs.getDouble(6));
	      s1.setSalesPricePerUnit(rs.getDouble(7));
	      s1.setProfitAmount(rs.getDouble(8));
	      sr.add(s1);
	    }
	  } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	  }
	  return sr;
	}
	
public static int insertSales(Sales sales) {
	Connection con=DBUtil.getDBConnection();
	PreparedStatement ps;
	int t=0;
	try {
		ps=con.prepareStatement("INSERT INTO TBL_SALES values (?,?,?,?,?)");
		ps.setString(1,sales.getSalesId());
		ps.setDate(2, (Date) sales.getSalesDate());
		ps.setString(3,sales.getProductId());
		ps.setInt(4,sales.getQuantitySold());
		ps.setDouble(5,sales.getSalesPricePerUnit());
		ps.executeQuery();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return 1;
}

}
