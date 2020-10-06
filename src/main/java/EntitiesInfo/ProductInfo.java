package EntitiesInfo;

import java.io.Serializable;

public class ProductInfo implements Serializable{
    private int id;
    private String name;
    private int amount;
    private int cost;
    private String description;

    public ProductInfo() {

    }

    public ProductInfo(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public ProductInfo(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public ProductInfo(int id, String name, int cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public ProductInfo(int id, String name, int amount, int cost, String description) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
