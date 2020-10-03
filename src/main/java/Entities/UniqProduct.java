package Entities;

public class UniqProduct{
    private int id;
    private Product product;
    private Status status;

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
