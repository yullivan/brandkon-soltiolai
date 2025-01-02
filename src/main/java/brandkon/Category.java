package brandkon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String slug;
    private String imageUrl;

    public Category(long id, String name, String slug, String imageUrl) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
