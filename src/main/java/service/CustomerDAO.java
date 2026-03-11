package service;

import controller.dao.ConnectionFactory;
import repository.GenericDAO;
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
                    if (rs.next()) {
                        generatedUserId = rs.getInt(1);
                    } else {
                        throw new SQLException("Creating user failed, no ID provided");
                    }
                }

                try (PreparedStatement stmtPhone = conn.prepareStatement(insertTelephoneSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtPhone.setInt(1, generatedUserId);
                    stmtPhone.setString(2, customer.getTelephoneNumber());
                    stmtPhone.executeUpdate();
                }

                try(PreparedStatement stmtEmail = conn.prepareStatement(insertEmailSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtEmail.setInt(1, generatedUserId);
                    stmtEmail.setString(2, customer.getEmail());
                    stmtEmail.executeUpdate();
                }
                conn.commit();
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
        String updateCustomerSQL = "UPDATE users SET Name = ?, Registration_Date = ? WHERE Id = ?";
        String updateTelephoneSQL = "UPDATE telephones SET Telephone_Number = ? WHERE User_Id = ?";
        String updateEmailSQL = "UPDATE emails SET email = ?, WHERE User_Id = ?";

        try(Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);

            try(PreparedStatement stmtCustomer  = conn.prepareStatement(updateCustomerSQL,Statement.RETURN_GENERATED_KEYS)) {

                stmtCustomer.setString(1, customer.getName());
                stmtCustomer.executeUpdate();

                try(PreparedStatement stmtPhone = conn.prepareStatement(updateTelephoneSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtPhone.setString(1, customer.getTelephoneNumber());
                    stmtPhone.executeUpdate();
                }

                try(PreparedStatement stmtEmail = conn.prepareStatement(updateEmailSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtEmail.setString(1, customer.getEmail());
                    stmtEmail.executeUpdate();
                }
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String deleteCustomerSQL = "DELETE FROM users WHERE Id = ?";
        String deleteTelephoneSQL = "DELETE FROM customers_telephones WHERE Customer_Id = ?";
        String deleteEmailSQL = "DELETE FROM customers_emails WHERE Customer_Id = ?";
    }

}
