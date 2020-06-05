package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class User {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @NotNull
    @Column(name = "USERNAME")
    private String username;

}