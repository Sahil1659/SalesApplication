package CONN.Wipro.Flight.DAO;

import CONN.Wipro.Flight.Bean.Product;
import CONN.Wipro.Flight.Bean.Sales;
import CONN.Wipro.Flight.Util.DBUtil;
import java.sql.*;
public class StockDao {

	
	  public static int updateStock(String productID, int Qty) throws SQLException {
			Connection con=DBUtil.getDBConnection();
		    PreparedStatement ps;
		    ps = con.prepareStatement("update tbl_stock set QUANTITY_ON_HAND = ? where product_id = ?");
		    ps.setInt(1, (Qty));
		    ps.setString(2, productID);
		    if (ps.executeUpdate() == 1) {
		      return 0;
		    }
		    return -1;
		  }
	
	public static String generateProductID(String productName) throws SQLException {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps;
		ps=con.prepareStatement("select SEQ_PRODUCT_ID.nextval from dual");
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		return productName.substring(0, 2)+rs.getInt(1);
		else
			return "Problem in generateProductID";
	}
	public static boolean deleteStock(String productID) throws SQLException{
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps;
		ps=con.prepareStatement("delete from TBL_STOCK where PRODUCT_ID=?");
		ps.setString(1, productID); 
		if(ps.executeUpdate()==1)
		return true;
		else
			return false;
	}
	  
	public static Product getStock(String productID) throws SQLException {
		  Connection con=DBUtil.getDBConnection();
			PreparedStatement ps;
		    
		     ps = con.prepareStatement("select * from TBL_STOCK where product_id = ?");
		    ps.setString(1, productID);
		    ResultSet rs = ps.executeQuery();
Product product=new Product();
		    if (rs.next()) {
		      product.setProductID(rs.getString(1));
		      product.setProductName(rs.getString(2));
		      product.setQuantityOnHand(rs.getInt(3));
		      product.setProductUnitPrice(rs.getFloat(4));
		      product.setReorderLevel(rs.getInt(5));
		    
		    }
		    return product;
		    
		    
	  }
	public static int insertStocks(Product sales) {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps;
		int t=0;
		try {
			ps=con.prepareStatement("INSERT INTO TBL_STOCK values (?,?,?,?,?)");
			ps.setString(1,sales.getProductID());
			ps.setString(2, sales.getProductName());
			ps.setInt(3,sales.getQuantityOnHand());
			ps.setFloat(4,(float) sales.getProductUnitPrice());
			ps.setInt(5,sales.getReorderLevel());
			ps.executeQuery();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 1;
	}
}
