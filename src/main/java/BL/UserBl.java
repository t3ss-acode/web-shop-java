package BL;

import DAL.UserDAL;
import Entities.User;

import java.util.Collection;

public class UserBl {
    public static boolean addUser(User addUser){
        return UserDAL.addUser(addUser);
    }

    public static Collection<User> getUsersFromDB(){
        return UserDAL.getUsersFromDB();
    }

    public static User getUserFromDB(String username){
        return UserDAL.getUserFromDB(username);
    }

    public static String removeUser(User userNotWanted){
        return UserDAL.removeUser(userNotWanted);
    }

    public static String updateUser(User editedUser){
        return UserDAL.updateUser(editedUser);
    }
}
