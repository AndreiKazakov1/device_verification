package by.iba.kazakov.device_verification.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "verifier")
public class Verifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_verifier", nullable = false)
    private Integer id;

    @Column(name = "verifier_first_name", nullable = false, length = 45)
    private String verifierFirstName;

    @Column(name = "verifier_last_name", nullable = false, length = 45)
    private String verifierLastName;

    @Column(name = "verifier_service_number", nullable = false)
    private Integer verifierServiceNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_admin_key", nullable = false)
    private AdminKey idAdminKey;

    @OneToMany(mappedBy = "idVerifier")
    private Set<DeviceInVerification> deviceInVerifications = new LinkedHashSet<>();



}