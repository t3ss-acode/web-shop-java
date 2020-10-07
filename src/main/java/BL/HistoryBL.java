package BL;

import DAL.HistoryDAL;
import Entities.History;
import EntitiesInfo.HistoryInfo;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryBL {

    public static boolean addHistory(HistoryInfo addHistory){
        return HistoryDAL.addHistory(addHistory);
    }

    public static Collection<HistoryInfo> getHistoryFromDB(){
        Collection<History> historyDALList = HistoryDAL.getHistoryFromDB();


        ArrayList<HistoryInfo> historyInfoList = new ArrayList<>();
        for (History history : historyDALList) {
            historyInfoList.add(new HistoryInfo(history.getId(), history.getProduct().getId(),
                    history.getProduct().getName(), history.getProduct().getCost(), history.getAction().getId(),
                    history.getAction().getName(), history.getUser().getId(), history.getUser().getUsername(),
                    history.getAmount(), history.getTimestamp()));
        }

        return historyInfoList;
    }


}
