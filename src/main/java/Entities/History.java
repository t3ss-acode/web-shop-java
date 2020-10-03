package Entities;

import java.sql.Timestamp;

public class History {
    private int id;
    private Product product;
    private int amount;
    private Action action;
    private User user;
    private Timestamp timestamp;

    public History() {
    }

    public History(int id, Product product, int amount, Action action, User user) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.action = action;
        this.user = user;
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
