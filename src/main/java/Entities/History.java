package Entities;

import java.sql.Timestamp;

public class History {
    private int id;
    private Product product;
    private int amount;
    private Action action;
    private User user;
    private Timestamp timestamp;

    protected History(int productId, int actionId, int userId, int amount){
        this.product = new Product(productId,null,0);
        this.action = new Action(actionId,null);
        this.user = new User(userId,null);
        this.amount = amount;
    }

    protected History(int id, int productId, String productName, int productCost, int actionId, String actionName, int userId, String userName, int amount, Timestamp timestamp) {
        this.id = id;
        this.product = new Product(productId,productName,productCost);
        this.amount = amount;
        this.action = new Action(actionId,actionName);
        this.user = new User(userId,userName);
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public Action getAction() {
        return action;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
