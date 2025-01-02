package brandkon;

public record CategoryResponse(
        long id,
        String name,
        String slug,
        String imageUrl
) {
    public CategoryResponse(long id, String name, String slug, String imageUrl) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
    }

    @Override
    public long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String slug() {
        return slug;
    }

    @Override
    public String imageUrl() {
        return imageUrl;
    }
}
