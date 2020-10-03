package DAL;

import Entities.Action;
import Entities.History;
import Entities.Product;
import Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class HistoryDAL {
    public static Collection<History> getHistoryFromDB(){
        Collection<History> historyList = new ArrayList<>();
        String query = "SELECT history.id,products.id,products.name,products.cost,actions.id,actions.name,user.id,user.username,amount,timestamp FROM history " +
                "LEFT JOIN actions ON history.actionId = actions.id " +
                "LEFT JOIN products ON history.productId = products.id " +
                "LEFT JOIN user ON history.userId = user.id;";
        try {
            ResultSet rs = DBConnection.executeSql(query,null);
            while(rs.next()){
                historyList.add(translateRow(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getTimestamp(10)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    public static boolean addHistory(History addHistory) {
        String query = "INSERT INTO history (productId,actionId,userId,amount) VALUES (?,?,?,?)";
        ArrayList<Object> pp = new ArrayList<>();
        pp.add(addHistory.getProduct().getId());
        pp.add(addHistory.getAction().getId());
        pp.add(addHistory.getUser().getId());
        pp.add(addHistory.getAmount());
        try {
            DBConnection.executeUpdateSql(query, pp);
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private static History translateRow(int id, int productId, String productName, int productCost, int actionId, String actionName, int userId, String userName, int amount, Timestamp timestamp){
        History history = new History();
        Product product = new Product();
        Action action = new Action();
        User user = new User();
        product.setId(productId);
        product.setName(productName);
        product.setCost(productCost);
        action.setId(actionId);
        action.setName(actionName);
        user.setId(userId);
        user.setUsername(userName);
        history.setId(id);
        history.setProduct(product);
        history.setAction(action);
        history.setUser(user);
        history.setAmount(amount);
        history.setTimestamp(timestamp);
        return history;
    }
}
