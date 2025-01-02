package brandkon;

import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String imageUrl;

    @ManyToOne
    private Category category;

    private String guidelines;

    public Brand(long id, String name, String imageUrl, Category category, String guidelines) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.guidelines = guidelines;
    }

    public Brand() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public String getGuidelines() {
        return guidelines;
    }
}
