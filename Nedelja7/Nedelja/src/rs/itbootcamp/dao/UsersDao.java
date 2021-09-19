package rs.itbootcamp.dao;

import rs.itbootcamp.model.UserModel;

import java.util.List;

public interface UsersDao {
    void add(UserModel um);
    void delete(int id);
    void update(UserModel um);
    UserModel getUser(int id);
    void addMealGrade(int user_id, int meal_id, int grade);
    boolean login(String entry, String password);
    //List<UserModel> getAllUsers();
}
