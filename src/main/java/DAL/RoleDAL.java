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

    public static boolean addRole(Role newRole){
        String query = "INSERT INTO roles (name) VALUES (?)";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(newRole.getName());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String updateRole(Role editedRole) {
        String query = "UPDATE roles set name = ?" +
                " WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(editedRole.getName());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Could not Update.";
        }
        return "System updated.";
    }

    public static String removeRole(Role roleNotWanted) {
        String query = "DELETE FROM roles WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(roleNotWanted.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Role removed.";
    }

    private RoleDAL(int id, String name) {
        super(id, name);
    }
}
