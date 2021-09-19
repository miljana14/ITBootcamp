package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealDaoSql implements MealDao{
    static Connection conn = DatabaseConnection.getConnection();

    @Override
    public void add(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO meal (meal_id, meal_name, meal_desc, meal_difficulty) VALUES (?, ?, ?, ?)");
            st.setInt(1, mm.getMeal_id());
            st.setString(2, mm.getMeal_name());
            st.setString(3, mm.getMeal_desc());
            st.setString(4, mm.getMeal_difficulty());
            st.executeUpdate(); //za sve osim za SELECT(executeQuery)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM meal WHERE meal_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE meal " +
                    "SET meal_id = ?, " +
                    "meal_name = ?, " +
                    "meal_desc = ?, " +
                    "meal_difficulty = ? " +
                    "WHERE meal_id = ?");
            st.setInt(1, mm.getMeal_id());
            st.setString(2, mm.getMeal_name());
            st.setString(3, mm.getMeal_desc());
            st.setString(4, mm.getMeal_difficulty());
            st.setInt(5, mm.getMeal_id());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public MealModel getMeal(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM meal WHERE meal_id = ?");
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            rs.next();
            MealModel newMeal = new MealModel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
            return newMeal;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MealModel> getAllMeals() {
        List<MealModel> allMeal = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal");
            while(rs.next()){
                MealModel newMeal = new MealModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );

                allMeal.add(newMeal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allMeal;
    }

    @Override
    public List<String> getFoodMealNames(int meal_id) {
        List<String> mealFoodName = new ArrayList<>();
        try{
            String foodName = "";
            PreparedStatement st = conn.prepareStatement("SELECT food_name FROM food JOIN mealfood ON mealfood.food_id = food.food_id JOIN meal ON mealfood.meal_id = meal.meal_id WHERE mealfood.meal_id = ?");
            st.setInt(1,meal_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                foodName += "\n " + rs.getString(1);

            }
            mealFoodName.add(foodName+ "\n");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mealFoodName;
    }

    @Override
    public List<FoodModel> getFoodMeal(int meal_id) {
        List<FoodModel> mealFood = new ArrayList<>();
            try {
                PreparedStatement st = conn.prepareStatement("SELECT * FROM food JOIN mealfood ON mealfood.food_id = food.food_id JOIN meal ON mealfood.meal_id = meal.meal_id WHERE mealfood.meal_id = ?");
                st.setInt(1,meal_id);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                FoodModel newFoodMeal = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
                mealFood.add(newFoodMeal);
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
                return mealFood;
            }
}
