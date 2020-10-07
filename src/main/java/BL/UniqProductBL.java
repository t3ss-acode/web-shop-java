package BL;

import DAL.UniqProductDAL;
import Entities.UniqProduct;
import EntitiesInfo.UniqProductInfo;

import java.util.ArrayList;
import java.util.Collection;

public class UniqProductBL {

    public static boolean addUniqProduct(UniqProductInfo addUniqProduct){
        return UniqProductDAL.addUniqProduct(addUniqProduct);
    }

    public static Collection<UniqProductInfo> getUniqProductsFromDB(){
        Collection<UniqProduct> uniqProductsDALList = UniqProductDAL.getUniqProductsFromDB();


        ArrayList<UniqProductInfo> uniqProductInfoList = new ArrayList<>();
        for (UniqProduct uniqProduct : uniqProductsDALList) {
            uniqProductInfoList.add(new UniqProductInfo(uniqProduct.getId(), uniqProduct.getProduct().getId(),
                    uniqProduct.getProduct().getName(), uniqProduct.getProduct().getCost(),
                    uniqProduct.getProduct().getDescription(), uniqProduct.getStatus().getId(),
                    uniqProduct.getStatus().getName()));
        }

        return uniqProductInfoList;
    }

    public static boolean updateUniqProduct(UniqProductInfo editedUniqProduct){
        return UniqProductDAL.updateUniqProduct(editedUniqProduct);
    }


}
