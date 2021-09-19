package rs.itbootcamp.dao;


import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;

import java.util.List;

public interface FridgeDao {
    void add(FridgeModel f);
    void delete(int id);
    void update(FridgeModel f);
    List<FoodModel> getAllFood(int fridge_id);
}
