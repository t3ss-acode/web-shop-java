package DAL;

import Entities.User;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UserDAL {
    public static Collection<User> getUsersFromDB(){
        Collection<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                userList.add(translateRow(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getLong(5)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static User getUserFromDB(String username){
        User user;
        String query = "SELECT * FROM user WHERE username = \"" + username +"\"";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            rs.next();
            user = translateRow(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getLong(5));
            return user;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addUser(User newUser){
        String query = "INSERT INTO user (username,password,email,card) VALUES (?,?,?,?)";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(newUser.getUsername());
        pp.add(newUser.getPassword());
        pp.add(newUser.getEmail());
        pp.add(newUser.getCard());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String updateUser(User editedUser) {
        String query = "UPDATE products set password = ? , email = ? , card = ?" +
                " WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(editedUser.getPassword());
        pp.add(editedUser.getEmail());
        pp.add(editedUser.getCard());
        pp.add(editedUser.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Could not Update.";
        }
        return "System updated.";
    }

    public static String removeUser(User userNotWanted) {
        String query = "DELETE FROM products WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(userNotWanted.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User removed.";
    }

    private static User translateRow(int id, String username, String password, String email, Long card){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCard(card);
        return user;
    }
}
