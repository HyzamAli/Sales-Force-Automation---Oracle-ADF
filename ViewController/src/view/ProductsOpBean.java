package view;

public class ProductsOpBean {
    private String prodId;
    private String quantity;
    private String category;

    public ProductsOpBean() {
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
