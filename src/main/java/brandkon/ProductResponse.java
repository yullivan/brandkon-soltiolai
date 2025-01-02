package brandkon;

public record ProductResponse(
        long id,
        String brandName,
        String productName,
        int price,
        String imageUrl
) {
    public ProductResponse(long id, String brandName, String productName, int price, String imageUrl) {
        this.id = id;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    @Override
    public long id() {
        return id;
    }

    @Override
    public String brandName() {
        return brandName;
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
    public String imageUrl() {
        return imageUrl;
    }
}
