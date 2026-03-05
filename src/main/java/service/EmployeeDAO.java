package service;

import controller.dao.ConnectionFactory;
import repository.GenericDAO;
import model.Employee;

import java.sql.*;

public class EmployeeDAO implements GenericDAO<Employee> {

    @Override
    public void insert(Employee employee) {


        String insertEmployeeSQL = "INSERT INTO users (Name, Registration_Date) VALUES (?, ?)";
        String insertTelephoneSQL = "INSERT INTO telephones (User_Id, Telephone) VALUES (?, ?)";
        String insertEmailSQL = "INSERT INTO emails (User_Id, Email) VALUES (?,?)";
        String insertRoleSQL = "INSERT INTO employee_roles (User_Id, Role) VALUES (?,?)";

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            try(PreparedStatement stmtEmployee = conn.prepareStatement(insertEmployeeSQL, Statement.RETURN_GENERATED_KEYS)) {
                stmtEmployee.setInt(1, employee.getId());
                stmtEmployee.setString(2, employee.getName());

                stmtEmployee.executeUpdate();

                int generatedUserId = 1;
                try (ResultSet rs = stmtEmployee.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedUserId = rs.getInt(1);
                    } else {
                        throw new SQLException("Creating user failed, no ID provided.");
                    }
                }

                try (PreparedStatement stmtPhone = conn.prepareStatement(insertTelephoneSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtPhone.setInt(1, generatedUserId);
                    stmtPhone.setString(2, employee.getTelephoneNumber());
                }

                try (PreparedStatement stmtEmail = conn.prepareStatement(insertEmailSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtEmail.setInt(1, generatedUserId);
                    stmtEmail.setString(2, employee.getEmail());
                }

                try (PreparedStatement stmtRole = conn.prepareStatement(insertRoleSQL, Statement.RETURN_GENERATED_KEYS)) {
                    stmtRole.setInt(1, generatedUserId);
                    stmtRole.setString(2, employee.getRole());
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee findById(int id) {
        String findEmployee = "SELECT FROM users WHERE Id = ?";
        String findTelephonesSQL = "SELECT FROM telephones WHERE User_Id = ?";
        String findEmailSQL = "SELECT FROM emails WHERE User_Id = ?";
        String findRoleSQL = "SELECT FROM roles WHERE User_Id = ?";
        return null;
    }

    @Override
    public void update(Employee employee) {
        String updateEmployeeSQL = "UPDATE users SET Name = ? WHERE Id = ?";
        String updateEmailSQL = "UPDATE emails SET Telephone_Number = ? WHERE User_Id = ?";
        String updateTelephoneSQL = "UPDATE telephones SET Email = ? WHERE User_Id = ?";
        String updateRoleSQL = "UPDATE roles SET Role = ? WHERE User_Id = ?";
    }

    @Override
    public void delete(int id) {
        String deleteEmployeeSQL = "DELETE FROM users WHERE Id = ?";
        String deleteTelephoneSQL = "DELETE FROM telephones WHERE User_Id = ?";
        String deleteEmailSQL = "DELETE FROM emails WHERE User_Id = ?";
        String deleteRoleSQL = "DELETE FROM roles WHERE User_Id = ?";
    }

}
