package brandkon;

public record ProductDetailResponse(
        long productId,
        String productName,
        int price,
        BrandSummary brand,
        int expirationDays
) {
    public ProductDetailResponse(long productId, String productName, int price, BrandSummary brand, int expirationDays) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.expirationDays = expirationDays;
    }

    @Override
    public long productId() {
        return productId;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public BrandSummary brand() {
        return brand;
    }

    @Override
    public int expirationDays() {
        return expirationDays;
    }
}
