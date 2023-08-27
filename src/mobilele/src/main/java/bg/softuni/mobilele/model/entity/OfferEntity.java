package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    private Integer mileage;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    private Integer year;

    private LocalDateTime created;

    private LocalDateTime modified;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

}
