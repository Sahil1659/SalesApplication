package CONN.Wipro.Flight.Bean;

public class Product {

	static String productID;
	static String productName;
	static int quantityOnHand;
	int reorderLevel;
	float productUnitPrice;
	
	public static String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public static String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public static int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	public int getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(float productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	
}
