import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void main(String[] args) {
        run(); // เรียกชุดทดสอบ
    }

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---\n");

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: TC1 - Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: TC1 - Expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: TC1 - Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: TC2 - Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: TC2 - Expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));  // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: TC3 - Normal items total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: TC3 - Expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: BOGO ซื้อ 3 แถม 1 => จ่าย 2
        ArrayList<CartItem> bogoCart = new ArrayList<>();
        bogoCart.add(new CartItem("BOGO", "Soda", 15.0, 3)); // จ่าย 2 => 30.0
        double total4 = ShoppingCartCalculator.calculateTotalPrice(bogoCart);
        if (total4 == 30.0) {
            System.out.println("PASSED: TC4 - BOGO 3 items should charge for 2 (30.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: TC4 - Expected 30.0 but got " + total4);
            failedCount++;
        }

        // Test 5: BULK น้อยกว่า 6 ชิ้น => ไม่มีส่วนลด
        ArrayList<CartItem> bulkCart1 = new ArrayList<>();
        bulkCart1.add(new CartItem("BULK", "Rice", 100.0, 5)); // 5 * 100 = 500.0
        double total5 = ShoppingCartCalculator.calculateTotalPrice(bulkCart1);
        if (total5 == 500.0) {
            System.out.println("PASSED: TC5 - BULK under 6 items, no discount (500.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: TC5 - Expected 500.0 but got " + total5);
            failedCount++;
        }

        // Test 6: BULK ≥ 6 ชิ้น => ลด 10%
        ArrayList<CartItem> bulkCart2 = new ArrayList<>();
        bulkCart2.add(new CartItem("BULK", "Rice", 100.0, 6)); // 600 - 10% = 540.0
        double total6 = ShoppingCartCalculator.calculateTotalPrice(bulkCart2);
        if (total6 == 540.0) {
            System.out.println("PASSED: TC6 - BULK 6+ items, 10% discount (540.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: TC6 - Expected 540.0 but got " + total6);
            failedCount++;
        }

        // --- สรุปผล ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}