package BL;

import DAL.UserDAL;
import Entities.Role;
import Entities.User;
import EntitiesInfo.UserInfo;

import java.util.ArrayList;
import java.util.Collection;

public class UserBl {
    public static boolean addUser(UserInfo addUserInfo){
        ArrayList<Role> roleList = (ArrayList<Role>) RoleBL.getRolesFromDB();
        for (Role r: roleList) {
            if (r.getName().equalsIgnoreCase(addUserInfo.getRole().getName())){
                addUserInfo.setRole(r.getId(),r.getName());
            }
        }
        return UserDAL.addUser(addUserInfo);
    }

    public static Collection<User> getUsersFromDB(){
        return UserDAL.getUsersFromDB();
    }

    public static UserInfo getUserFromDB(String username) {
        User userDAL = UserDAL.getUserFromDB(username);
        UserInfo userInfo = new UserInfo(userDAL.getId(), userDAL.getUsername(), userDAL.getPassword(),
                userDAL.getEmail(), userDAL.getCard(), userDAL.getRole().getId(),userDAL.getRole().getName());

        return userInfo;
    }

    public static String removeUser(User userNotWanted){
        return UserDAL.removeUser(userNotWanted);
    }

    public static String updateUser(User editedUser){
        return UserDAL.updateUser(editedUser);
    }
}
