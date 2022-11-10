package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "admin_key_verifier")
public class AdminKeyForVerifier {
    public AdminKeyForVerifier (String admKeyVerifier) {
        this.admKeyVerifier = admKeyVerifier;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin_key_verifier", nullable = false)
    private Integer id;

    @Column(name = "adm_key_verifier", nullable = false, length = 45)
    private String admKeyVerifier;


}