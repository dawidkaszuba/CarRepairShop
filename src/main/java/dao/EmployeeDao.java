package dao;

import database.DbUtil;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public static void save(Connection connection, Employee employee) {
        if (employee.getId() == null) {
            String[] generatedColumns = {"id"};
            String sql = "INSERT INTO employees(name, surname, address, note, costOfWorkHour, phoneNumber) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql,generatedColumns)) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getAddress());
                preparedStatement.setString(4, employee.getNote());
                preparedStatement.setDouble(5, employee.getCostOfWorkHour());
                preparedStatement.setString(6, employee.getPhoneNumber());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "UPDATE employees SET name=?, surname=?, address=?, note=?, costOfWorkHour=?, phoneNumber=? " +
                    "WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getAddress());
                preparedStatement.setString(4, employee.getNote());
                preparedStatement.setDouble(5, employee.getCostOfWorkHour());
                preparedStatement.setString(6, employee.getPhoneNumber());
                preparedStatement.setInt(7, employee.getId());
                preparedStatement.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(Connection connection, Integer id) {
        if (id != null) {
            String sql = "DELETE FROM employees WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1,id);
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        id = null;
    }

    public static Employee findById(int id){
        String sql = "SELECT * FROM employees WHERE id=?";
        Employee employee = new Employee();
        try(Connection connection = DbUtil.getConn()){
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setNote(rs.getString("note"));
                employee.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
            }
        }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return employee;
    }

    public static List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try(Connection connection = DbUtil.getConn()){
            try(Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setSurname(rs.getString("surname"));
                    employee.setAddress(rs.getString("address"));
                    employee.setNote(rs.getString("note"));
                    employee.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                    employee.setPhoneNumber(rs.getString("phoneNumber"));
                    employees.add(employee);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return employees;
    }

}
