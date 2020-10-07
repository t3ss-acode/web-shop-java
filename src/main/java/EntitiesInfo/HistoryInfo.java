package EntitiesInfo;

import java.sql.Timestamp;

public class HistoryInfo {
    private int id;
    private ProductInfo product;
    private int amount;
    private ActionInfo action;
    private UserInfo user;
    private Timestamp timestamp;

    public HistoryInfo(int id, int productId, String productName, int productCost, int actionId, String actionName, int userId, String userName, int amount, Timestamp timestamp) {
        this.id = id;
        this.product = new ProductInfo(productId,productName,productCost);
        this.amount = amount;
        this.action = new ActionInfo(actionId,actionName);
        this.user = new UserInfo(userId,userName);
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public ProductInfo getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public ActionInfo getAction() {
        return action;
    }

    public UserInfo getUser() {
        return user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(ProductInfo product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAction(ActionInfo action) {
        this.action = action;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
