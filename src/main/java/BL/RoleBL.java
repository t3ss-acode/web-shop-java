package BL;

import DAL.RoleDAL;
import DAL.UserDAL;
import Entities.Role;
import Entities.User;
import EntitiesInfo.RoleInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RoleBL {
    public static boolean addUser(RoleInfo addRole){
        return RoleDAL.addRole(addRole);
    }

    public static Collection<RoleInfo> getRolesFromDB(){
        Collection<Role> roleDALList = RoleDAL.getRolesFromDB();

        ArrayList<RoleInfo> roleInfoList = new ArrayList<>();
        for (Iterator iterator = roleDALList.iterator(); iterator.hasNext();){
            Role role = (Role) iterator.next();
            roleInfoList.add(new RoleInfo(role.getId(),role.getName()));
        }
        return roleInfoList;
    }

    public static String removeRole(RoleInfo roleNotWanted){
        return RoleDAL.removeRole(roleNotWanted);
    }

    public static String updateRole(RoleInfo editedRole){
        return RoleDAL.updateRole(editedRole);
    }
}
