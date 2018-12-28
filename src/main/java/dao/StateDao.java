package dao;

import model.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateDao {

    public static void save(Connection connection, State status){
        if(status.getId() == 0){
            String[] generatedColums = {"id"};
            String sql = "INSERT INTO states(name) VALUES(?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColums)){
                preparedStatement.setString(1,status.getName());
                preparedStatement.executeUpdate();

            }catch(SQLException e){
                e.printStackTrace();
            }

        }else{
            String sql = "UPDATE orders SET name=? WHERE id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,status.getName());
                preparedStatement.setInt(2,status.getId());
                preparedStatement.execute();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(Connection connection, State state){
        if(state.getId() !=null){
            String sql = "DELETE FROM states WHERE id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,state.getId());
                preparedStatement.execute();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static State findById(Connection connection, int id){
        State state = new State();
        String sql = "SELECT * FROM states WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                state.setId(rs.getInt("id"));
                state.setName(rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return state;
    }

    public static List<State> findAll(Connection connection) {
        List<State> states = new ArrayList<>();
        State state = new State();
        String sql = "SELECT * FROM states";
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            state.setId(rs.getInt("id"));
            state.setName(rs.getString("name"));
            states.add(state);
        }catch (SQLException e ){
            e.printStackTrace();
        }

        return states;
    }
}
