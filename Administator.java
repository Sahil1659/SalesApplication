package CONN.Wipro.Flight.Service;

import CONN.Wipro.Flight.Bean.Product;
import CONN.Wipro.Flight.Bean.Sales;
import CONN.Wipro.Flight.Bean.SalesReport;
import CONN.Wipro.Flight.DAO.SalesDao;
import CONN.Wipro.Flight.DAO.StockDao;
import CONN.Wipro.Flight.Util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
public class Administator {
public String deleteStock(String ProductID) throws SQLException {
	if(StockDao.deleteStock(ProductID))
		return "Deleted Successfully";
	else
		return "Record cannot be deleted";
}
public static int insertStock(Product stock) throws SQLException {
	if(stock!=null && stock.getProductName().length()>=2) {
		String productID=StockDao.generateProductID(stock.getProductName());
		stock.setProductID(productID);
		
	
	 if (StockDao.insertStocks(stock) == 1) {
	        System.out.println("Inserted Succesfully");
	      } else {
	        System.out.println("Error In Insertion");
	      }
	}
	     else {
	      return -1;
	    }
	    return 1;
	  }
	
public static int insertSales(Sales sales) throws SQLException {
	Connection con=DBUtil.getDBConnection();
	if(sales==null)
		return 0;
	 if (sales.getProductId().length() < 6) {
	      return 2;
	    }
	    PreparedStatement ps = con.prepareStatement("select QUANTITY_ON_HAND from tbl_stock where product_id = ?");
	    ps.setString(1, sales.getProductId());
	    ResultSet rs = ps.executeQuery();
	    int qty = 0;
	    if (rs.next()) {
	      qty = rs.getInt(1);
	    }
	    if (qty < sales.getQuantitySold()) {
	      return 3;
	    }	 java.util.Date date =  sales.getSalesDate();
	    Date curDate = new Date(new java.util.Date().getTime());
	    if (date.compareTo(curDate) > 0) {
	      return 4;
	    }
	    sales.setSalesId(SalesDao.generateSalesID(date));

	    if (SalesDao.insertSales(sales) == -1) {
	      return 5;
	    }

	   
	    else
	    return 1;
	  }
public static ArrayList<SalesReport> getSalesReport() throws SQLException {
    return SalesDao.getSalesReport();
  }
}

