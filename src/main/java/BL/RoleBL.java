package BL;

import DAL.RoleDAL;
import Entities.Role;
import EntitiesInfo.RoleInfo;

import java.util.ArrayList;
import java.util.Collection;

public class RoleBL {

    public static Collection<RoleInfo> getRolesFromDB(){
        Collection<Role> roleDALList = RoleDAL.getRolesFromDB();

        ArrayList<RoleInfo> roleInfoList = new ArrayList<>();
        for (Role role : roleDALList) {
            roleInfoList.add(new RoleInfo(role.getId(), role.getName()));
        }
        return roleInfoList;
    }

}
