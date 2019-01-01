package dao;

import database.DbUtil;
import model.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    public static void save(Connection connection, Vehicle vehicle){
        if(vehicle.getId() == null){
            String sql = "INSERT INTO vehicles(brand, model, nextTechnicalReview, registrationNumber, yearOfProduction, idOfOwner) VALUES(?,?,?,?,?,?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1,vehicle.getBrand());
                preparedStatement.setString(2,vehicle.getModel());
                preparedStatement.setDate(3, Date.valueOf(vehicle.getNextTechnicalReview()));
                preparedStatement.setString(4,vehicle.getRegistrationNumber());
                preparedStatement.setInt(5,vehicle.getYearOfProduction());
                preparedStatement.setInt(6,vehicle.getIdOfOwner());
                preparedStatement.execute();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }else{
            String sql = "UPDATE vehicles SET brand=?, model=?, nextTechnicalReview=?, registrationNumber=?," +
                    "yearOfProduction=?,idOfOwner=? WHERE id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,vehicle.getBrand());
                preparedStatement.setString(2,vehicle.getModel());
                preparedStatement.setDate(3, Date.valueOf(vehicle.getNextTechnicalReview()));
                preparedStatement.setString(4,vehicle.getRegistrationNumber());
                preparedStatement.setInt(5,vehicle.getYearOfProduction());
                preparedStatement.setInt(6,vehicle.getIdOfOwner());
                preparedStatement.setInt(7,vehicle.getId());
                preparedStatement.executeUpdate();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(Integer id) {

        String sql = "DELETE FROM vehicles WHERE id=?";
        try(Connection connection = DbUtil.getConn()){
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> findAll(){

        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try(Connection connection = DbUtil.getConn()){
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setModel(rs.getString("model"));
                    vehicle.setBrand(rs.getString("brand"));
                    vehicle.setNextTechnicalReview(LocalDate.parse(rs.getString("nextTechnicalReview")));
                    vehicle.setRegistrationNumber(rs.getString("registrationNumber"));
                    vehicle.setYearOfProduction(rs.getInt("yearOfProduction"));
                    vehicle.setIdOfOwner(rs.getInt("idOfOwner"));
                    vehicles.add(vehicle);
                }
            }
        }catch( SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public static Vehicle findById(int id) {
        String sql = "SELECT * FROM vehicles where id=?";
        Vehicle vehicle = new Vehicle();
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setModel(rs.getString("model"));
                    vehicle.setBrand(rs.getString("brand"));
                    vehicle.setNextTechnicalReview(LocalDate.parse(rs.getString("nextTechnicalReview")));
                    vehicle.setRegistrationNumber(rs.getString("registrationNumber"));
                    vehicle.setYearOfProduction(rs.getInt("yearOfProduction"));
                    vehicle.setIdOfOwner(rs.getInt("idOfOwner"));

                }

            }catch(SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }
}
