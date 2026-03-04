package controller.dao;

import controller.dao.interfaces.GenericDAO;
import model.Customer;
import java.sql.*;

public class CustomerDAO implements GenericDAO<Customer> {


    @Override
    public void insert(Customer customer) {
        String insertCustomerSQL = "INSERT INTO users (Name, Registration_Date) VALUES (?, ?)";
        String insertTelephoneSQL = "INSERT INTO customer_telephones (Id, Telephone_Number) VALUES (?,?)";
        String insertEmailSQL = "INSERT INTO customer_emails (Id, Email) VALUES (?,?)";

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);

            try(PreparedStatement stmtCustomer = conn.prepareStatement(insertCustomerSQL, Statement.RETURN_GENERATED_KEYS)) {
                stmtCustomer.setString(1, customer.getName());

                stmtCustomer.executeUpdate();

                int generatedUserId = -1;
                try(ResultSet rs = stmtCustomer.getGeneratedKeys()) {

                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        String findCustomerSQL = "SELECT FROM users WHERE Id = ?";
        String findTelephoneSQL = "SELECT FROM telephones WHERE User_Id = ?";
        String findEmailSQL = "SELECT FROM emails WHERE User_Id = ?";
        return null;
    }

    @Override
    public void update(Customer customer) {
        String sql;
    }

    @Override
    public void delete(int id) {
        String deleteCustomerSQL = "DELETE FROM users WHERE Id = ?";
        String deleteTelephoneSQL = "DELETE FROM customers_telephones WHERE Customer_Id = ?";
        String deleteEmailSQL = "DELETE FROM customers_emails WHERE Customer_Id = ?";
    }

}
