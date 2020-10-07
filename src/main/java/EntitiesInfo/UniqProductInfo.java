package EntitiesInfo;

public class UniqProductInfo {
    private int id;
    private ProductInfo product;
    private StatusInfo status;

    public UniqProductInfo(int id,int productId, String productName,int cost, String desc,int statusId, String statusName) {
        this.id = id;
        this.product = new ProductInfo(productId,productName,cost,desc);
        this.status = new StatusInfo(statusId,statusName);
    }

    public int getId() {
        return id;
    }

    public ProductInfo getProduct() {
        return product;
    }

    public StatusInfo getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(ProductInfo product) {
        this.product = product;
    }

    public void setStatusInfo(StatusInfo status) {
        this.status = status;
    }
}
