package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.UserModel;

import java.sql.*;

public class UserDaoSql implements UsersDao{
    static Connection conn = DatabaseConnection.getConnection();
    @Override
    public void add(UserModel um){
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO users (user_id, username, email, user_password, user_admin) VALUES (?, ?, ?, ?, ?)");
            st.setInt(1, um.getUserId());
            st.setString(2, um.getUserName());
            st.setString(3, um.getEmail());
            st.setString(4, um.getPassword());
            st.setBoolean(5, um.isAdmin());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE user_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(UserModel um) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users " +
                    "SET user_id = ?, " +
                    "username = ?, " +
                    "email = ?, " +
                    "user_password = ?, " +
                    "user_admin = ? " +
                    "WHERE user_id = ?");
            st.setInt(1, um.getUserId());
            st.setString(2, um.getUserName());
            st.setString(3, um.getEmail());
            st.setString(4, um.getPassword());
            st.setBoolean(5, um.isAdmin());
            st.setInt(6, um.getUserId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public UserModel getUser(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
            return new UserModel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getBoolean(5)
            );
            }
            else {
                System.out.println("No result");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMealGrade(int user_id, int meal_id, int grade) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO usermeal (user_id,meal_id,grade) VALUES (?,?,?) " +
                    "ON CONFLICT (user_id,meal_id) DO UPDATE SET user_id = ?, meal_id = ?, grade = ?");
            st.setInt(1, user_id);
            st.setInt(2, meal_id);
            st.setInt(3, grade);
            st.setInt(4, user_id);
            st.setInt(5, meal_id);
            st.setInt(6, grade);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean login(String entry, String password) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT user_password FROM users WHERE username = " +
                    "'" + entry + "'" +
                    "OR email = '" + entry + "'");
            return  rs.next() && rs.getString(1).equals(password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
