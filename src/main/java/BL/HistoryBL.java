package BL;

import DAL.HistoryDAL;
import Entities.History;

import java.util.Collection;

public class HistoryBL {
    public static boolean addHistory(History addHistory){
        return HistoryDAL.addHistory(addHistory);
    }

    public static Collection<History> getHistoryFromDB(){
        return HistoryDAL.getHistoryFromDB();
    }
}
