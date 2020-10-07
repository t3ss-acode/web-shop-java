package BL;

import DAL.UserDAL;
import Entities.User;
import EntitiesInfo.RoleInfo;
import EntitiesInfo.UserInfo;

import java.util.ArrayList;

public class UserBl {
    public static boolean addUser(UserInfo addUserInfo){
        ArrayList<RoleInfo> roleList = (ArrayList<RoleInfo>) RoleBL.getRolesFromDB();
        for (RoleInfo r: roleList) {
            if (r.getName().equalsIgnoreCase(addUserInfo.getRole().getName())){
                addUserInfo.setRole(r.getId(),r.getName());
            }
        }
        return UserDAL.addUser(addUserInfo);
    }

    public static UserInfo getUserFromDB(String username) {
        User userDAL = UserDAL.getUserFromDB(username);
        UserInfo userInfo = new UserInfo(userDAL.getId(), userDAL.getUsername(), userDAL.getPassword(),
                userDAL.getEmail(), userDAL.getCard(), userDAL.getRole().getId(),userDAL.getRole().getName());

        return userInfo;
    }

}
