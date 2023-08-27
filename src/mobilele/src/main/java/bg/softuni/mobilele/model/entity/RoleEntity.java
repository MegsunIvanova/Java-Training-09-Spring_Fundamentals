package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;

}
