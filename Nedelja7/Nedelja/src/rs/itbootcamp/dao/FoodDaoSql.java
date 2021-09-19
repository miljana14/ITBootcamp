package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoSql implements FoodDao{
    static Connection conn = DatabaseConnection.getConnection();
    @Override
    public void add(FoodModel fm){
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO food (food_id, food_name, food_kcal, food_proteins, food_carbs, food_fat) VALUES (?, ?, ?, ?, ?, ?)");
            st.setInt(1, fm.getFood_id());
            st.setString(2, fm.getFood_name());
            st.setDouble(3, fm.getKcal());
            st.setDouble(4, fm.getProteins());
            st.setDouble(5, fm.getCarbohydrates());
            st.setDouble(6, fm.getFood_fat());
            st.executeUpdate(); //za sve osim za SELECT(executeQuery)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addToMeal(int meal_id, int food_id, double mass) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO mealfood (meal_id, food_id, mass) VALUES (?, ?, ?)");
            st.setInt(1, meal_id);
            st.setInt(2, food_id);
            st.setDouble(3, mass);
            st.executeUpdate(); //za sve osim za SELECT(executeQuery)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addToFridge(int fridge_id, int food_id, double mass) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO fridgefood (fridge_id, food_id, mass) VALUES (?, ?, ?)");
            st.setInt(1, fridge_id);
            st.setInt(2, food_id);
            st.setDouble(3, mass);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void delete(int id){
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM food WHERE food_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE food " +
                    "SET food_id = ?, " +
                    "food_name = ?, " +
                    "food_kcal = ?, " +
                    "food_proteins = ?, " +
                    "food_carbs = ?, " +
                    "food_fat = ? " +
                    "WHERE food_id = ?");
            st.setInt(1, fm.getFood_id());
            st.setString(2, fm.getFood_name());
            st.setDouble(3, fm.getKcal());
            st.setDouble(4, fm.getProteins());
            st.setDouble(5, fm.getCarbohydrates());
            st.setDouble(6, fm.getFood_fat());
            st.setInt(7, fm.getFood_id());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public FoodModel getFood(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM food WHERE food_id = ?");
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            rs.next();
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
            return newFood;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodModel> getAllFood() {
        List<FoodModel> allFood = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food");
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

