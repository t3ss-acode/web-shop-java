package DAL;

import Entities.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class RoleDAL extends Role {
    public static Collection<Role> getRolesFromDB(){
        Collection<Role> userList = new ArrayList<>();
        String query = "SELECT * FROM roles";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                userList.add(new RoleDAL(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private RoleDAL(int id, String name) {
        super(id, name);
    }
}
