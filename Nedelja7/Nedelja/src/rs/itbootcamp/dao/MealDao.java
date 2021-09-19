package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.util.List;

public interface MealDao {
    void add(MealModel mm);
    void delete(int id);
    void update(MealModel mm);
    MealModel getMeal(int id);
    List<MealModel> getAllMeals();
    List<String> getFoodMealNames(int meal_id);
    List<FoodModel> getFoodMeal(int meal_id);
}
