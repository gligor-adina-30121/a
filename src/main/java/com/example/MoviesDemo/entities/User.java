package com.example.MoviesDemo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;
    @Column(unique = false, nullable = false, length = 50)
    private String role;
    @Column(unique = false, nullable = false, length = 50)
    private String email;
    @Column(unique = false, nullable = false, length = 25)
    private String password;
    @Column(name="first_name",unique = false, nullable = false, length = 100)
    private String firstName;
    @Column(name="last_name",unique = false, nullable = false, length = 100)
    private String lastName;
    @Column(name="phone_number",unique = false, nullable = false, length = 25)
    private String phoneNumber;
    @Column(name="date_of_birth",unique = false, nullable = false, length = 25)
    private LocalDate dateOfBirth;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    //private Set<Order> orders;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    //private Set<Favorite> favorites;
}
