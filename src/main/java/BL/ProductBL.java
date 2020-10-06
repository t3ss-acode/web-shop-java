package BL;

import DAL.ProductDAL;
import Entities.Product;
import EntitiesInfo.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductBL {
    /*
    public static boolean addProduct(Product addProduct){
        return ProductDAL.addProduct(addProduct);
    }

     */

    public static ArrayList<ProductInfo> getProductsFromDB(){
        Collection<Product> productDALList = ProductDAL.getProductsFromDB();


        ArrayList<ProductInfo> productInfoList = new ArrayList<>();
        for(Iterator iterator = productDALList.iterator(); iterator.hasNext();) {
            Product product =(Product)iterator.next();
            productInfoList.add(new ProductInfo(product.getId(), product.getName(), product.getAmount(), product.getCost(), product.getDescription()));
        }
        for(int i=0; i < productInfoList.size(); i++) {
            System.out.println(productInfoList.get(i).getName());
        }
        return productInfoList;
    }

    /*
    public static String removeProduct(Product productNotWanted){
        return ProductDAL.removeProduct(productNotWanted);
    }

    public static String updateProduct(Product editedProduct){
        return ProductDAL.updateProduct(editedProduct);
    }

     */
}
