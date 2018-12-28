package dao;

import model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public static void save(Connection connection,Customer customer){
        if(customer.getId() == null){
            String[] generatedColumns = {"id"};
            String sql = "INSERT INTO customers(name,surname,birthday,email) VALUES(?,?,?,?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql,generatedColumns)){
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getSurname());
                preparedStatement.setDate(3,Date.valueOf(customer.getBirthday()));
                preparedStatement.setString(4,customer.getEmail());
                preparedStatement.executeUpdate();

            }catch(SQLException e){
                e.printStackTrace();
            }
        } else{

            String sql = "UPDATE customers SET name=?, surname=?, birthday=?,email=? WHERE id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getName());
                preparedStatement.setDate(3,Date.valueOf(customer.getBirthday()));;
                preparedStatement.setInt(4,customer.getId());
                preparedStatement.execute();
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public static void delete(Connection connection, Customer customer){
        if(customer.getId() != null){

            String sql = "DELETE FROM customers WHERE id=?";
            try(PreparedStatement preparedStatement =connection.prepareStatement(sql)){
                preparedStatement.setInt(1,customer.getId());
                preparedStatement.execute();
            }catch(SQLException e){
                e.printStackTrace();

            }
            Integer id = null;
        }

    }

    public static Customer findById(Connection connection, int id) {
        String sql = "SELECT * FROM customers WHERE id=?";

        Customer customer = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setBirthday(rs.getObject("birthday",LocalDate.class));
                customer.setEmail(rs.getString("email"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static List<Customer> findAll(Connection connection){
        String sql ="SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setBirthday(rs.getObject("birthday",LocalDate.class));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

}
