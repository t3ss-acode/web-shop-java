package BL;

import DAL.RoleDAL;
import DAL.UserDAL;
import Entities.Role;
import Entities.User;

import java.util.Collection;

public class RoleBL {
    public static boolean addUser(Role addRole){
        return RoleDAL.addRole(addRole);
    }

    public static Collection<Role> getRolesFromDB(){
        return RoleDAL.getRolesFromDB();
    }

    public static String removeRole(Role roleNotWanted){
        return RoleDAL.removeRole(roleNotWanted);
    }

    public static String updateRole(Role editedRole){
        return RoleDAL.updateRole(editedRole);
    }
}
