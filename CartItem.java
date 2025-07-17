package lib;
public class CartItem {
    private String purchaseCode;
    private String productName;
    private double price;
    private int quantity;

    public CartItem(String purchaseCode, String productName, double price, int quantity) {
        this.purchaseCode = purchaseCode;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPurchaseCode() { return purchaseCode; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}