package shopcart.product.model;

public class Price {

    private float lowestPrice;
    private boolean sale;

    public Price() {}

    public Price(float lowestPrice) {
        this(lowestPrice, false);
    }

    public Price(float lowestPrice, boolean sale) {
        this.lowestPrice = lowestPrice;
        this.sale = sale;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
