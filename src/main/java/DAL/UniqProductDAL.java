package DAL;

import Entities.Product;
import Entities.Status;
import Entities.UniqProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UniqProductDAL {
    public static Collection<UniqProduct> getUniqProductsFromDB(){
        Collection<UniqProduct> uniqProductList = new ArrayList<>();
        String query = "SELECT amount.id,products.id,products.name,cost,description,status.id,status.name FROM amount" +
                "LEFT JOIN products ON products.id = amount.productId " +
                "LEFT JOIN status ON amount.statusId = status.id;";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                uniqProductList.add(translateRow(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return uniqProductList;
    }

    public static boolean addUniqProduct(UniqProduct addUniqProduct) {
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

    public static String updateUniqProduct(UniqProduct editedUniqProduct) {
        String query = "UPDATE amount set statusId = ? " +
                " WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(editedUniqProduct.getStatus().getId());
        pp.add(editedUniqProduct.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Could not Update.";
        }
        return "System updated.";
    }

    public static String removeUniqProduct(UniqProduct uniqProductNotWanted) {
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

    private static UniqProduct translateRow(int id,int productId, String productName,int cost, String desc,int statusId, String statusName){
        UniqProduct uniqProduct = new UniqProduct();
        Product product = new Product();
        Status status = new Status();
        product.setId(productId);
        product.setName(productName);
        product.setCost(cost);
        product.setDescription(desc);
        status.setId(statusId);
        status.setName(statusName);
        uniqProduct.setId(id);
        uniqProduct.setProduct(product);
        uniqProduct.setStatus(status);
        return uniqProduct;
    }
}
