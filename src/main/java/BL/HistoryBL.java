package BL;

import DAL.HistoryDAL;
import DAL.ProductDAL;
import Entities.History;
import Entities.Product;
import EntitiesInfo.HistoryInfo;
import EntitiesInfo.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HistoryBL {

    public static boolean addHistory(HistoryInfo addHistory){
        return HistoryDAL.addHistory(addHistory);
    }

    public static Collection<HistoryInfo> getHistoryFromDB(){
        Collection<History> historyDALList = HistoryDAL.getHistoryFromDB();


        ArrayList<HistoryInfo> historyInfoList = new ArrayList<>();
        for(Iterator iterator = historyDALList.iterator(); iterator.hasNext();) {
            History history = (History) iterator.next();
            historyInfoList.add(new HistoryInfo(history.getId(),history.getProduct().getId(),
                    history.getProduct().getName(),history.getProduct().getCost(),history.getAction().getId(),
                    history.getAction().getName(),history.getUser().getId(),history.getUser().getUsername(),
                    history.getAmount(),history.getTimestamp()));
        }

        return historyInfoList;
    }


}
