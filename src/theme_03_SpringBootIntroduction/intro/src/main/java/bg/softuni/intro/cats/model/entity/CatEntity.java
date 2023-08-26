package bg.softuni.intro.cats.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cats")
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private OwnerEntity owner;

    public Long getId() {
        return id;
    }

    public CatEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CatEntity setName(String name) {
        this.name = name;
        return this;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public CatEntity setOwner(OwnerEntity owner) {
        this.owner = owner;
        return this;
    }
}
