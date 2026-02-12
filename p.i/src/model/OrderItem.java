package model;

public class OrderItem {
    private int productId;
    private int orderId;

    OrderItem(int productId, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }
}
