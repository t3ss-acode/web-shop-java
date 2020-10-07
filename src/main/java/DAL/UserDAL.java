package DAL;

import Entities.User;
import EntitiesInfo.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UserDAL extends User{
    public static Collection<User> getUsersFromDB(){
        Collection<User> userList = new ArrayList<>();
        String query = "SELECT user.id,username,password,email,card,roles.id,roles.name FROM user " +
                "LEFT JOIN userRoles ON user.id = userRoles.userId" +
                "LEFT JOIN roles ON userRoles.roleId = roles.id;";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                userList.add(new UserDAL(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getLong(5),rs.getInt(6),rs.getString(7)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static User getUserFromDB(String username){
        User user;
        String query = "SELECT user.id,username,password,email,card,roles.id,roles.name FROM user \n" +
                "LEFT JOIN userRoles ON user.id = userRoles.userId\n" +
                "LEFT JOIN roles ON userRoles.roleId = roles.id\n" +
                "WHERE username = \""+username+ "\";";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            rs.next();
            user = new UserDAL(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4),rs.getLong(5),rs.getInt(6),rs.getString(7));
            return user;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addUser(UserInfo newUserInfo){
        User newUser = new UserDAL(newUserInfo.getId(),newUserInfo.getUsername(),newUserInfo.getPassword(),
                newUserInfo.getEmail(),newUserInfo.getCard(),newUserInfo.getRole().getId(),newUserInfo.getRole().getName());
        String[] query = new String[2];
        query[0] = "INSERT INTO user (username,password,email,card) VALUES (?,?,?,?);";
        query[1] = "INSERT INTO userRoles (userId,roleId) VALUES (last_insert_id(), ?);";
        ArrayList<Object>[] pp = new ArrayList[query.length];
        pp[0] = new ArrayList<>();
        pp[1]= new ArrayList<>();
        pp[0].add(newUser.getUsername());
        pp[0].add(newUser.getPassword());
        pp[0].add(newUser.getEmail());
        pp[0].add(newUser.getCard());
        pp[1].add(newUser.getRole().getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private UserDAL(int id, String username, String password, String email, Long card, int roleId, String roleName) {
        super(id, username, password, email, card, roleId, roleName);
    }
}
