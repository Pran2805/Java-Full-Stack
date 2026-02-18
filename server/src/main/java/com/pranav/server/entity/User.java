package com.pranav.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_user_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_user_username", columnNames = {"username"}),
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;

    private String email;

    private String password;

    private boolean isValid;

//    private Roles roles;


}
