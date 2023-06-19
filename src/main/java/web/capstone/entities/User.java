package web.capstone.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Gallery> galleries;
}
