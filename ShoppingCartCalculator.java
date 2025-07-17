
import java.util.List;

public class ShoppingCartCalculator {

    /**
     * คำนวณราคารวมสุทธิของสินค้าในตะกร้า โดยใช้กฎส่วนลด
     * 
     *   BOGO (Buy One Get One): ซื้อ 1 แถม 1 เช่น ซื้อ 3 จ่าย 2
     *   BULK: ถ้าซื้อตั้งแต่ 6 ชิ้นขึ้นไป ได้รับส่วนลด 10%
     * 
     *
     * @param cartItems รายการสินค้าในตะกร้า
     * @return ราคารวมสุทธิของตะกร้า
     */
    public static double calculateTotalPrice(List<CartItem> cartItems) {
    if (cartItems == null || cartItems.isEmpty()) {
        return 0.0;
    }

    double total = 0.0;

    for (CartItem item : cartItems) {
        double pricePerItem = item.getPrice();
        int quantity = item.getQuantity();
        String code = item.getPurchaseCode();
        double itemTotal = 0.0;

        if (code.equals("BOGO")) {
            int chargeableQty = (quantity / 2) + (quantity % 2);
            itemTotal = chargeableQty * pricePerItem;
        } else if (code.equals("BULK")) {
            itemTotal = pricePerItem * quantity;
            if (quantity >= 6) {
                itemTotal *= 0.9; // ลด 10%
            }
        } else {
            itemTotal = pricePerItem * quantity;
        }

        total += itemTotal;
    }

    return total;
}
}
