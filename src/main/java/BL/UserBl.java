package BL;

import DAL.UserDAL;
import Entities.Role;
import Entities.User;

import java.util.ArrayList;
import java.util.Collection;

public class UserBl {
    public static boolean addUser(User addUser){
        ArrayList<Role> roleList = (ArrayList<Role>) RoleBL.getRolesFromDB();
        for (Role r: roleList) {
            if (r.getName().equalsIgnoreCase(addUser.getRole().getName())){
                addUser.setRole(r);
            }
        }
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
