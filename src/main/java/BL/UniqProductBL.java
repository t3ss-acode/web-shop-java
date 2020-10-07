package BL;

import DAL.UniqProductDAL;
import Entities.Product;
import Entities.UniqProduct;
import EntitiesInfo.ProductInfo;
import EntitiesInfo.UniqProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UniqProductBL {

    public static boolean addUniqProduct(UniqProductInfo addUniqProduct){
        return UniqProductDAL.addUniqProduct(addUniqProduct);
    }

    public static Collection<UniqProductInfo> getUniqProductsFromDB(){
        Collection<UniqProduct> uniqProductsDALList = UniqProductDAL.getUniqProductsFromDB();


        ArrayList<UniqProductInfo> uniqProductInfoList = new ArrayList<>();
        for(Iterator iterator = uniqProductsDALList.iterator(); iterator.hasNext();) {
            UniqProduct uniqProduct = (UniqProduct) iterator.next();
            uniqProductInfoList.add(new UniqProductInfo(uniqProduct.getId(),uniqProduct.getProduct().getId(),
                    uniqProduct.getProduct().getName(),uniqProduct.getProduct().getCost(),
                    uniqProduct.getProduct().getDescription(),uniqProduct.getStatus().getId(),
                    uniqProduct.getStatus().getName()));
        }

        return uniqProductInfoList;
    }

    public static String removeUniqProduct(UniqProductInfo uniqProductNotWanted){
        return UniqProductDAL.removeUniqProduct(uniqProductNotWanted);
    }

    public static boolean updateUniqProduct(UniqProductInfo editedUniqProduct){
        return UniqProductDAL.updateUniqProduct(editedUniqProduct);
    }


}
