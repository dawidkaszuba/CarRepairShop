package dao;

import database.DbUtil;
import model.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateDao {

    public static void save(State status){
        if(status.getId() == null){
            String[] generatedColums = {"id"};
            String sql = "INSERT INTO states(name) VALUES(?)";
            try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColums)){
                preparedStatement.setString(1,status.getName());
                preparedStatement.executeUpdate();

            }catch(SQLException e){
                e.printStackTrace();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else{
            String sql = "UPDATE states SET name=? WHERE id=?";
            try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,status.getName());
                preparedStatement.setInt(2,status.getId());
                preparedStatement.execute();
            }catch(SQLException e) {
                e.printStackTrace();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(Integer id){
        if(id !=null){
            String sql = "DELETE FROM states WHERE id=?";
            try(Connection connection = DbUtil.getConn()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static State findById(int id){
        State state = new State();
        String sql = "SELECT * FROM states WHERE id=?";
        try(Connection connection = DbUtil.getConn()){
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                state.setId(rs.getInt("id"));
                state.setName(rs.getString("name"));
            }
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return state;
    }

    public static List<State> findAll() {
        List<State> states = new ArrayList<>();
        String sql = "SELECT * FROM states";
        try(Connection connection = DbUtil.getConn()){
        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                State state = new State();
                state.setId(rs.getInt("id"));
                state.setName(rs.getString("name"));
                states.add(state);
            }
        }
        }catch (SQLException e ){
            e.printStackTrace();
        }

        return states;
    }
}
