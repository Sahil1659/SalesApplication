package CONN.Wipro.Flight.Bean;


public class SalesReport
{

private java.util.Date salesDate;
private String productID;
private String productNmae;
private int quantitySold;
private double productUnitPrice;
private double salesPricePerUnit;
private double profitAmount;


private String salesID;
public String getSalesID()
{
return salesID;
}
public void setSalesID(String salesID)
{
this.salesID = salesID;
}
public java.util.Date getSalesDate()
{
return salesDate;
}
public void setSalesDate(java.util.Date salesDate)
{
this.salesDate = salesDate;
}
public String getProductID()
{
return productID;
}
public void setProductID(String productID)
{
this.productID = productID;
}
public String getProductNmae()
{
return productNmae;
}
public void setProductNmae(String productNmae)
{
this.productNmae = productNmae;
}
public int getQuantitySold()
{
return quantitySold;
}
public void setQuantitySold(int quantitySold)
{
this.quantitySold = quantitySold;
}
public double getProductUnitPrice()
{
return productUnitPrice;
}
public void setProductUnitPrice(double productUnitPrice)
{
this.productUnitPrice = productUnitPrice;
}
public double getSalesPricePerUnit()
{
return salesPricePerUnit;
}
public void setSalesPricePerUnit(double salesPricePerUnit)
{
this.salesPricePerUnit = salesPricePerUnit;
}
public double getProfitAmount()
{
return profitAmount;
}
public void setProfitAmount(double profitAmount) {
this.profitAmount = profitAmount;
}
}
