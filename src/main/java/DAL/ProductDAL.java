package DAL;

import Entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;

public class ProductDAL {
    public static Collection<Product> getProductsFromDB(){
        Collection<Product> productList = new ArrayList<>();
        String query = "SELECT products.id,name,cost,description,COUNT(*) FROM products " +
                "LEFT JOIN amount ON products.id = amount.productId " +
                "GROUP BY products.id;";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                productList.add(translateRow(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static boolean addProduct(Product addProduct) {
        String query = "INSERT INTO products (name,cost,description) VALUES (?,?,?)";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(addProduct.getName());
        pp.add(addProduct.getCost());
        pp.add(addProduct.getDescription());
        try {
            DBConnection.executeUpdateSql(query, pp);
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String updateProduct(Product editedProduct) {
        String query = "UPDATE products set name = ? , cost = ? , description = ?" +
                " WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(editedProduct.getName());
        pp.add(editedProduct.getCost());
        pp.add(editedProduct.getDescription());
        pp.add(editedProduct.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Could not Update.";
        }
        return "System updated.";
    }

    public static String removeProduct(Product productNotWanted) {
        String query = "DELETE FROM products WHERE id = ?";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(productNotWanted.getId());
        try {
            DBConnection.executeUpdateSql(query,pp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Product removed.";
    }

    private static Product translateRow(int id, String name,int cost, String desc, int amount){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCost(cost);
        product.setDescription(desc);
        product.setAmount(amount);
        return product;
    }
}
