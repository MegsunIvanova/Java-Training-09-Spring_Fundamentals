package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserIsNull();

    Optional<Task> findTaskByIdAndUserIsNull(Long id);

    Optional<Task> findTaskByIdAndUser(Long id, User user);
}
