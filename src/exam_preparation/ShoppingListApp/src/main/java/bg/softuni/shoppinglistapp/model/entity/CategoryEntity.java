package bg.softuni.shoppinglistapp.model.entity;

import bg.softuni.shoppinglistapp.model.enums.CategoryName;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@NamedEntityGraph(
        name = "categoryWithProducts",
        attributeNodes = @NamedAttributeNode("products"))
public class CategoryEntity extends BaseEntity {

    //name: unique
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    private String description;

    @OneToMany(mappedBy = "category", targetEntity = ProductEntity.class)
    private Set<ProductEntity> products;

    public CategoryEntity() {
        this.products = new HashSet<>();
    }

    public CategoryEntity(CategoryName name) {
        this.name = name;
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryEntity setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public CategoryEntity setProducts(Set<ProductEntity> products) {
        this.products = products;
        return this;
    }
}
