package bg.softuni.intro.cats.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL
    )
    private List<CatEntity> cats = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public OwnerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OwnerEntity setName(String name) {
        this.name = name;
        return this;
    }

    public OwnerEntity addCat(CatEntity cat) {
        cats.add(cat);
        return this;
    }

    public List<CatEntity> getCats() {
        return cats;
    }

    public OwnerEntity setCats(List<CatEntity> cats) {
        this.cats = cats;
        return this;
    }
}
