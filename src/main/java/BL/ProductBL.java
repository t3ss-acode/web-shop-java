package BL;

import DAL.ProductDAL;
import Entities.Product;
import EntitiesInfo.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;

public class ProductBL {

    public static boolean addProduct(ProductInfo addProduct){
        return ProductDAL.addProduct(addProduct);
    }

    public static ArrayList<ProductInfo> getProductsFromDB(){
        Collection<Product> productDALList = ProductDAL.getProductsFromDB();


        ArrayList<ProductInfo> productInfoList = new ArrayList<>();
        for (Product product : productDALList) {
            productInfoList.add(new ProductInfo(product.getId(), product.getName(), product.getAmount(), product.getCost(), product.getDescription()));
        }

        return productInfoList;
    }


}
