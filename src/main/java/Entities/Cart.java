package Entities;

import java.util.Collection;

public class Cart {
    private User user;
    private Collection<Product> productList;

    public User getUser() {
        return user;
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }
}
