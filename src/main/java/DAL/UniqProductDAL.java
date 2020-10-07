package DAL;

import Entities.UniqProduct;
import EntitiesInfo.UniqProductInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UniqProductDAL extends UniqProduct{
    public static Collection<UniqProduct> getUniqProductsFromDB(){
        Collection<UniqProduct> uniqProductList = new ArrayList<>();
        String query = "SELECT amount.id,products.id,products.name,cost,description,status.id,status.name FROM amount " +
                "LEFT JOIN products ON products.id = amount.productId " +
                "LEFT JOIN status ON amount.statusId = status.id;";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                uniqProductList.add(new UniqProductDAL(rs.getInt(1),rs.getInt(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getInt(6),rs.getString(7)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return uniqProductList;
    }

    public static boolean addUniqProduct(UniqProductInfo addUniqProduct) {
        String query = "INSERT INTO amount (productId,statusId) VALUES (?,?)";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(addUniqProduct.getProduct().getId());
        pp.add(addUniqProduct.getStatus().getId());
        try {
            DBConnection.executeUpdateSql(query, pp);
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateUniqProduct(UniqProductInfo editedUniqProduct) {
        String query = "UPDATE amount set statusId = ? " +
                " WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(editedUniqProduct.getStatus().getId());
        pp.add(editedUniqProduct.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String removeUniqProduct(UniqProductInfo uniqProductNotWanted) {
        String query = "DELETE FROM amount WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(uniqProductNotWanted.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Uniq product removed.";
    }

    private UniqProductDAL(int id, int productId, String productName, int cost, String desc, int statusId, String statusName) {
        super(id, productId, productName, cost, desc, statusId, statusName);
    }
}
