package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.CategoryEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "model")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    private LocalDateTime created;
    private LocalDateTime modified;

    @ManyToOne
    private BrandEntity brand;

    @OneToMany(mappedBy = "model")
    private List<OfferEntity> offers;


}
