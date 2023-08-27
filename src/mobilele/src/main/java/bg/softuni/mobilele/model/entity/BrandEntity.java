package bg.softuni.mobilele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    @OneToMany(mappedBy = "brand")
    private List<ModelEntity> models;

}
