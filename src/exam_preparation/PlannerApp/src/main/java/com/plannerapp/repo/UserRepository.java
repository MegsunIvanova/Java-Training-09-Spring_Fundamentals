package com.plannerapp.repo;

import com.plannerapp.model.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @EntityGraph(
            value = "userWithTasks",
            attributePaths = "assignedTasks"
    )
    @Query("SELECT u FROM User  u " +
            "WHERE u.username = :username ")
    Optional<User> findUserByUsernameWithTasks(String username);
}
