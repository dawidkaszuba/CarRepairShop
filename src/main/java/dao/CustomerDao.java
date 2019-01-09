package dao;

import database.DbUtil;
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
                preparedStatement.setString(2,customer.getSurname());
                preparedStatement.setDate(3,Date.valueOf(customer.getBirthday()));
                preparedStatement.setString(4,customer.getEmail());
                preparedStatement.setInt(5,customer.getId());
                preparedStatement.execute();
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public static void delete(Connection connection, Integer id){
        if(id != null){

            String sql = "DELETE FROM customers WHERE id=?";
            try(PreparedStatement preparedStatement =connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            }catch(SQLException e){
                e.printStackTrace();

            }
            id = null;
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

    public static List<Customer> findAll(){
        String sql ="SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = DbUtil.getConn()){
            try(Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setSurname(rs.getString("surname"));
                    customer.setBirthday(rs.getObject("birthday", LocalDate.class));
                    customer.setEmail(rs.getString("email"));
                    customers.add(customer);
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

    public static int findCustomerByIdOfVehicle(int idOfVehicle) {
        String sql = "SELECT customers.id FROM customers JOIN vehicles ON vehicles.idOfOwner=customers.id WHERE vehicles.id=?;";
        int customerId = -1;
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,idOfVehicle);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()){
                    customerId = rs.getInt("id");
                }

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerId;
    }

    public static List<Customer> findCustomersByName(String surname){
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE surname LIKE ?";
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,surname +"%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setSurname(rs.getString("surname"));
                    customer.setBirthday(rs.getObject("birthday", LocalDate.class));
                    customer.setEmail(rs.getString("email"));
                    customers.add(customer);
                }

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }


        return customers;
    }
}
