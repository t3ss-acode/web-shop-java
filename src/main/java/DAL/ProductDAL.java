package DAL;

import Entities.Product;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class ProductDAL {
    public static Collection<Product> getProductsFromDB(){
        Collection<Product> productList = new ArrayList<Product>();
        String query = "SELECT * FROM [dbo].[Product]";
        ResultSet rs = DBConnection.executeSql(query);
        /*while(rs.next()){

        }*/
        return productList;
    }

    private static Product translateRow(){
        Product product = new Product();
        return product;
    }
}
