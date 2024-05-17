import java.time.LocalDate;


public class Product {

    private String productType;
    private double productPrice;
    private boolean hasDiscount;
    private LocalDate dateAdded;
    public Product(String productType, double productPrice) {
        this.productType = productType;
        this.productPrice = productPrice;
        this.hasDiscount = false;
        this.dateAdded = LocalDate.now();
    }

    public Product(String productType, double productPrice, boolean hasDiscount) {
        this.productType = productType;
        this.productPrice = productPrice;
        this.hasDiscount = hasDiscount;
        this.dateAdded = LocalDate.now();
    }


    public String getProductType() {
        return productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    @Override
    public String toString() {
        return "Product{type=" + productType + ", price=" + productPrice + "}";
    }
}
