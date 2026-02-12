package model;

public class Order {
    private int customerId;
    private double totalPrice;

    Order(int customerId, double totalPrice) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

}
