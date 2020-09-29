package Entities;

public class History {
    private int id;
    private Product product;
    private int amount;
    private Action action;
    private User user;

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
}
