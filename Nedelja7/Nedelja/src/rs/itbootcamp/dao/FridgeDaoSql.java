package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FridgeDaoSql implements FridgeDao{
    static Connection conn = DatabaseConnection.getConnection();
    @Override
    public void add(FridgeModel f) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO fridge (fridge_id, user_id) VALUES (?, ?)");
            st.setInt(1, f.getFridgeId());
            st.setInt(2, f.getUserId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM fridge WHERE fridge_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(FridgeModel f) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE fridge " +
                    "SET fridge_id = ?, " +
                    "user_id = ? " +
                    "WHERE fridge_id = ?");
            st.setInt(1, f.getFridgeId());
            st.setInt(2, f.getUserId());
            st.setInt(3, f.getFridgeId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<FoodModel> getAllFood(int fridge_id) {
        List<FoodModel> allFood = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM food JOIN fridgefood ON fridgefood.food_id = food.food_id WHERE fridgefood.fridge_id = ?");
            st.setInt(1,fridge_id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
                allFood.add(newFood);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allFood;
    }
}
