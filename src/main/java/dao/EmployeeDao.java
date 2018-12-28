package dao;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public static void save(Connection connection, Employee employee) {
        if (employee.getId() == null) {
            String[] generatedColumns = {"id"};
            String sql = "INSERT INTO employee(name, surname, address, note, costOfWorkHour, phoneNumber) VALUES(?,?,?,?,?,?)";
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
            String sql = "UPDATE employess SET name=?, surname=?, address=?, note=?, costOfWorkHour=?, phoneNumber=?) " +
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

    public static void delete(Connection connection, Employee employee) {
        if (employee.getId() != null) {
            String sql = "DELETE FROM employess WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1,employee.getId());
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        Integer id = null;
    }

    public static Employee findById(Connection connection, int id){
        String sql = "SELECT * FROM employess WHERE id=?";
        Employee employee = new Employee();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setNote(rs.getString("note"));
                employee.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return employee;
    }

    public static List<Employee> findAll(Connection connection){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        String sql = "SELECT * FROM employess";
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setNote(rs.getString("note"));
                employee.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employees.add(employee);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return employees;
    }

}
