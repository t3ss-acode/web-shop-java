package DAL;

import Entities.Product;
import EntitiesInfo.ProductInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;

public class ProductDAL extends Product{
    public static Collection<Product> getProductsFromDB(){
        Collection<Product> productList = new ArrayList<>();
        String query = "SELECT products.id,name,cost,description,COUNT(*) FROM products " +
                "LEFT JOIN amount ON products.id = amount.productId " +
                "GROUP BY products.id;";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                productList.add(new ProductDAL(
                        //id, name, cost, description, amount
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static boolean addProduct(ProductInfo addProductInfo) {
        Product addProduct = new ProductDAL(addProductInfo.getId(),addProductInfo.getName(),addProductInfo.getCost(),
                addProductInfo.getDescription());
        String[] query = new String[2];
        query[0] = "INSERT INTO products (name,cost,description) VALUES (?,?,?)";
        query[1] = "INSERT INTO amount (productId,statusId) VALUES (last_insert_id(),1)";
        ArrayList<Object>[] pp = new ArrayList[query.length];
        pp[0] = new ArrayList<>();
        pp[1] = new ArrayList<>();
        pp[0].add(addProduct.getName());
        pp[0].add(addProduct.getCost());
        pp[0].add(addProduct.getDescription());
        try {
            DBConnection.executeUpdateSql(query, pp);
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ProductDAL(int id, String name, int cost, String description) {
        super(id, name, cost, description);
    }

    private ProductDAL(int id, String name, int cost, String description, int amount) {
        super(id, name, cost, description, amount);
    }
}
