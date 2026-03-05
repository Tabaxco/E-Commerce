package service;

import controller.dao.ConnectionFactory;
import repository.GenericDAO;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAO implements GenericDAO<Order> {

    @Override
    public void insert(Order order) {

        String insertOrder = "INSERT INTO orders (Id, Customer_Id, Total_Price) VALUES (?, ?, ?)";
        String insertOrderItem = "INSERT INTO order_items (Order_Id, Customer_Id) VALUES (?,?)";

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);

            try(PreparedStatement stmtOrder = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS)) {
                stmtOrder.setInt(1, order.getOrderId());
                stmtOrder.setInt(2, order.getCustomerId());
                stmtOrder.setDouble(3, order.getTotalPrice());
            }
        } catch(SQLException e) {

        }
    }

    @Override
    public Order findById(int id) {
        String findOrderSQL = "SELECT FROM orders WHERE Id = ?";
        String findOrderItem = "SELECT FROM order_items WHERE Order_Id = ?";
        return null;
    }

    @Override
    public void update(Order order) {
        String updateOrderSQL = "UPDATE orders SET Total_Price = ? WHERE Order_Id = ?";
    }

    @Override
    public void delete(int id) {

        String deleteOrderSQL = "DELETE FROM orders WHERE Id = ?";
        String deleteOrderItemSQL = "DELETE FROM order_items WHERE Order_Id = ?";
    }
}
