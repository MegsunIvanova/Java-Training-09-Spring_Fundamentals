package bg.softuni.mobilele.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "is_active")
    private boolean isActive;

    private LocalDateTime created;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "last_name")
    private String lastName;

    private LocalDateTime modified;

    @Column(nullable = false, unique = true)
    private String username;

    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "seller")
    private List<OfferEntity> offers;

}
