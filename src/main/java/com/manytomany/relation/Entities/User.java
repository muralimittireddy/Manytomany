package com.manytomany.relation.Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userid;

        private String uname;
        private String password;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "userid"),
                inverseJoinColumns = @JoinColumn(name = "roleid"))
        private Set<Role> roles = new HashSet<>();

        // Getters and Setters
    }



