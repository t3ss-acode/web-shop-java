package BL;

import DAL.ProductDAL;
import Entities.Product;

import java.util.Collection;

public class ProductBL {
    public static boolean addProduct(Product addProduct){
        return ProductDAL.addProduct(addProduct);
    }

    public static Collection<Product> getProductsFromDB(){
        return ProductDAL.getProductsFromDB();
    }

    public static String removeProduct(Product productNotWanted){
        return ProductDAL.removeProduct(productNotWanted);
    }

    public static String updateProduct(Product editedProduct){
        return ProductDAL.updateProduct(editedProduct);
    }
}
