package CONN.Wipro.Flight.Bean;

import java.util.Date;

public class Sales {
	 java.sql.Date salesDate;
	String salesId,productId;
	int quantitySold;
	double salesPricePerUnit;
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
	public java.sql.Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(java.sql.Date date) {
		this.salesDate = date;
	}
	
}
