package BL;

import DAL.ProductDAL;
import Entities.Product;
import EntitiesInfo.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductBL {

    public static boolean addProduct(ProductInfo addProduct){
        return ProductDAL.addProduct(addProduct);
    }

    public static ArrayList<ProductInfo> getProductsFromDB(){
        Collection<Product> productDALList = ProductDAL.getProductsFromDB();


        ArrayList<ProductInfo> productInfoList = new ArrayList<>();
        for(Iterator iterator = productDALList.iterator(); iterator.hasNext();) {
            Product product =(Product)iterator.next();
            productInfoList.add(new ProductInfo(product.getId(), product.getName(), product.getAmount(), product.getCost(), product.getDescription()));
        }

        return productInfoList;
    }


    public static String removeProduct(ProductInfo productNotWanted){
        return ProductDAL.removeProduct(productNotWanted);
    }

    public static String updateProduct(ProductInfo editedProduct){
        return ProductDAL.updateProduct(editedProduct);
    }


}
