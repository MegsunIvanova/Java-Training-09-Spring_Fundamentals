package com.plannerapp.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NamedEntityGraph(
        name = "userWithTasks",
        attributeNodes = @NamedAttributeNode("assignedTasks")
)
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", targetEntity = Task.class)
    private List<Task> assignedTasks;

    public User() {
        this.assignedTasks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public User setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
        return this;
    }
    public User assignTask(Task task) {
        this.assignedTasks.add(task);
        return this;
    }

    public User removeTask(Task task) {
        this.assignedTasks.remove(task);
        return this;
    }
}
