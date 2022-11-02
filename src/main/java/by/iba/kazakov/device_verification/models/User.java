package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 45, unique = true)
    private String login;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "role", nullable = false, length = 20)
    private String role;


    @OneToMany(mappedBy = "idUser")
    private Set<Administrator> administrators = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<Verifier> verifiers = new LinkedHashSet<>();



}