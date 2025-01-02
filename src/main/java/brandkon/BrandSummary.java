package brandkon;

public record BrandSummary(
        long id,
        String name,
        String guidelines
) {
    public BrandSummary(long id, String name, String guidelines) {
        this.id = id;
        this.name = name;
        this.guidelines = guidelines;
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
    public String guidelines() {
        return guidelines;
    }
}
