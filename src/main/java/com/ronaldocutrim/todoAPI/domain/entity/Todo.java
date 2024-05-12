package com.ronaldocutrim.todoAPI.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private Boolean completed;

    @JsonIgnore
    @ManyToOne
    private User user;

    public Todo(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }
}
