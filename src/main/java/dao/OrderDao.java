package dao;


import database.DbUtil;
import model.Order;
import model.Vehicle;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao {

    public static void save(Order order) {
        if(order.getId() == null){
            String sql = "INSERT INTO orders(dateOfAcceptanceForRepair,plannedRepairDate, startedDateOfRepair," +
                    "idOfEmployee, descriptionOfProblem, status, idOfVehicle, costOfWork, costOfAutoParts, costOfWorkHour," +
                    "quantityOfWorkHour,idOfCustomer) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            String[] generatedColumns = {"id"};
            try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql,generatedColumns)) {
                preparedStatement.setDate(1, Date.valueOf(order.getDateOfAcceptanceForRepair()));
                preparedStatement.setDate(2, Date.valueOf(order.getPlannedRepairDate()));
                preparedStatement.setDate(3, Date.valueOf(order.getStartedDateOfRepair()));
                preparedStatement.setInt(4, order.getIdOfEmployee());
                preparedStatement.setString(5, order.getDescriptionOfProblem());
                preparedStatement.setString(6, order.getStatus());
                preparedStatement.setInt(7, order.getIdOfVehicle());
                preparedStatement.setDouble(8, order.getCostOfWork());
                preparedStatement.setDouble(9, order.getCostOfAutoParts());
                preparedStatement.setDouble(10, order.getCostOfWorkHour());
                preparedStatement.setDouble(11, order.getQuantityOfWorkHour());
                preparedStatement.setInt(12, order.getIdOfCustomer());
                preparedStatement.executeUpdate();
            }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }else {
            String sql = "UPDATE orders SET dateOfAcceptanceForRepair=?,plannedRepairDate, startedDateOfRepair=?," +
                    "idOfEmployee=?, descriptionOfProblem=?, status=?, idOfVehicle=?, costOfWork=?, costOfAutoParts=?, costOfWorkHour=?," +
                    "quantityOfWorkHour=?, idOfCustomer=? WHERE id=?";
            try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, Date.valueOf(order.getDateOfAcceptanceForRepair()));
                preparedStatement.setDate(2, Date.valueOf(order.getPlannedRepairDate()));
                preparedStatement.setDate(3, Date.valueOf(order.getStartedDateOfRepair()));
                preparedStatement.setInt(4, order.getIdOfEmployee());
                preparedStatement.setString(5, order.getDescriptionOfProblem());
                preparedStatement.setString(6, order.getStatus());
                preparedStatement.setInt(7, order.getIdOfVehicle());
                preparedStatement.setDouble(8, order.getCostOfWork());
                preparedStatement.setDouble(9, order.getCostOfAutoParts());
                preparedStatement.setDouble(10, order.getCostOfWorkHour());
                preparedStatement.setDouble(11, order.getQuantityOfWorkHour());
                preparedStatement.setInt(12, order.getIdOfCustomer());
                preparedStatement.setInt(13, order.getId());
                preparedStatement.execute();
            }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(Connection connection,Order order) {
        if(order.getId() != null) {
            String sql = "DELETE FROM orders WHERE id =?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, order.getId());
                preparedStatement.execute();

            }catch(SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static Order findById(int id) {
        Order order = new Order();
        String sql = "SELECT * from orders WHERE id=?";
        try(Connection connection = DbUtil.getConn()){
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                order.setId(rs.getInt("id"));
                order.setDateOfAcceptanceForRepair(rs.getObject("dateOfAcceptanceForRepair",LocalDate.class));
                order.setPlannedRepairDate(rs.getObject("plannedRepairDate",LocalDate.class));
                order.setStartedDateOfRepair(rs.getObject("startedDateOfRepair",LocalDate.class));
                order.setIdOfEmployee(rs.getInt("idOfEmployee"));
                order.setDescriptionOfProblem(rs.getString("descriptionOfProblem"));
                order.setStatus(rs.getString("status"));
                order.setIdOfVehicle(rs.getInt("idOfVehicle"));
                order.setCostOfWork(rs.getDouble("costOfWork"));
                order.setCostOfAutoParts(rs.getDouble("costOfAutoParts"));
                order.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                order.setQuantityOfWorkHour(rs.getDouble("quantityOfWorkHour"));
                order.setIdOfCustomer(rs.getInt("idOfCustomer"));
            } }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return order;
    }

    public static List<Order> findAll(Integer limit){
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders ORDER BY dateOfAcceptanceForRepair DESC";
        try(Connection connection = DbUtil.getConn()){
            try(Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                if (limit != null) {
                    statement.setFetchSize(limit);
                    statement.setMaxRows(limit);
                    statement.setFetchDirection(ResultSet.FETCH_FORWARD);
                }
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setDateOfAcceptanceForRepair(rs.getObject("dateOfAcceptanceForRepair", LocalDate.class));
                    order.setPlannedRepairDate(rs.getObject("plannedRepairDate", LocalDate.class));
                    order.setStartedDateOfRepair(rs.getObject("startedDateOfRepair", LocalDate.class));
                    order.setIdOfEmployee(rs.getInt("idOfEmployee"));
                    order.setDescriptionOfProblem(rs.getString("descriptionOfProblem"));
                    order.setStatus(rs.getString("status"));
                    order.setIdOfVehicle(rs.getInt("idOfVehicle"));
                    order.setCostOfWork(rs.getDouble("costOfWork"));
                    order.setCostOfAutoParts(rs.getDouble("costOfAutoParts"));
                    order.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                    order.setQuantityOfWorkHour(rs.getDouble("quantityOfWorkHour"));
                    order.setIdOfCustomer(rs.getInt("idOfCustomer"));
                    orders.add(order);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    public static List<Order> findOrderByVehicleId(int id){
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders where idOfVehicle=?";
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setDateOfAcceptanceForRepair(rs.getObject("dateOfAcceptanceForRepair", LocalDate.class));
                    order.setPlannedRepairDate(rs.getObject("plannedRepairDate", LocalDate.class));
                    order.setStartedDateOfRepair(rs.getObject("startedDateOfRepair", LocalDate.class));
                    order.setIdOfEmployee(rs.getInt("idOfEmployee"));
                    order.setDescriptionOfProblem(rs.getString("descriptionOfProblem"));
                    order.setStatus(rs.getString("status"));
                    order.setIdOfVehicle(rs.getInt("idOfVehicle"));
                    order.setCostOfWork(rs.getDouble("costOfWork"));
                    order.setCostOfAutoParts(rs.getDouble("costOfAutoParts"));
                    order.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                    order.setQuantityOfWorkHour(rs.getDouble("quantityOfWorkHour"));
                    order.setIdOfCustomer(rs.getInt("idOfCustomer"));
                    orders.add(order);
                }

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static List<Order> findByEmployeeIdCurrentRepair(int id, String status){
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders where idOfEmployee=? AND status=?";
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,status);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setDateOfAcceptanceForRepair(rs.getObject("dateOfAcceptanceForRepair", LocalDate.class));
                    order.setPlannedRepairDate(rs.getObject("plannedRepairDate", LocalDate.class));
                    order.setStartedDateOfRepair(rs.getObject("startedDateOfRepair", LocalDate.class));
                    order.setIdOfEmployee(rs.getInt("idOfEmployee"));
                    order.setDescriptionOfProblem(rs.getString("descriptionOfProblem"));
                    order.setStatus(rs.getString("status"));
                    order.setIdOfVehicle(rs.getInt("idOfVehicle"));
                    order.setCostOfWork(rs.getDouble("costOfWork"));
                    order.setCostOfAutoParts(rs.getDouble("costOfAutoParts"));
                    order.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                    order.setQuantityOfWorkHour(rs.getDouble("quantityOfWorkHour"));
                    order.setIdOfCustomer(rs.getInt("idOfCustomer"));
                    orders.add(order);
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    public static int getWorkHoursByEmployeeAndDate(String date, String startedDateOfRepair, int id) {
        String sql = "SELECT SUM(quantityOfWorkHour) FROM orders where startedDateOfRepair>=? AND startedDateOfRepair<? AND idOfEmployee=?";
        int quantity = -1;
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,startedDateOfRepair);
                preparedStatement.setString(2,date);
                preparedStatement.setInt(3,id);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()){
                    quantity = rs.getInt(1);
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return quantity;
    }

    public static List<ArrayList<String>> findOrderWithVehicle(){
        String sql = " Select orders.id,descriptionOfProblem, brand, model,registrationNumber from orders JOIN vehicles ON idOfVehicle=vehicles.id;\n";
        List<ArrayList<String>> list = new ArrayList<>();
        try(Connection connection = DbUtil.getConn()){
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    List<String> firstList = new ArrayList<>();
                    String id = rs.getString("id");
                    String descriptionOfProblem = rs.getString("descriptionOfProblem");
                    String brand = rs.getString("brand");
                    String model = rs.getString("model");
                    String registrationNumber = rs.getString("registrationNumber");
                    firstList.add(id);
                    firstList.add(descriptionOfProblem);
                    firstList.add(brand);
                    firstList.add(model);
                    firstList.add(registrationNumber);
                    list.add((ArrayList<String>) firstList);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Order> findOrderByCustomerId(int id) {
        List<Order> orders = new ArrayList<>();
        String sql = " SELECT * FROM orders WHERE idOfCustomer=?";
        try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setDateOfAcceptanceForRepair(rs.getObject("dateOfAcceptanceForRepair", LocalDate.class));
                    order.setPlannedRepairDate(rs.getObject("plannedRepairDate", LocalDate.class));
                    order.setStartedDateOfRepair(rs.getObject("startedDateOfRepair", LocalDate.class));
                    order.setIdOfEmployee(rs.getInt("idOfEmployee"));
                    order.setDescriptionOfProblem(rs.getString("descriptionOfProblem"));
                    order.setStatus(rs.getString("status"));
                    order.setIdOfVehicle(rs.getInt("idOfVehicle"));
                    order.setCostOfWork(rs.getDouble("costOfWork"));
                    order.setCostOfAutoParts(rs.getDouble("costOfAutoParts"));
                    order.setCostOfWorkHour(rs.getDouble("costOfWorkHour"));
                    order.setQuantityOfWorkHour(rs.getDouble("quantityOfWorkHour"));
                    order.setIdOfCustomer(rs.getInt("idOfCustomer"));
                    orders.add(order);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
