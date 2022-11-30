package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "admin_key_client")
public class AdminKeyForClient {
    public AdminKeyForClient(String admKeyClient) {
        this.admKeyClient = admKeyClient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin_key_client", nullable = false)
    private Long id;

    @Column(name = "adm_key_client", nullable = false, length = 45)
    private String admKeyClient;
}

