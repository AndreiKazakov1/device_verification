package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;
import java.util.Calendar;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "device_in_verification")
public class DeviceInVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device_in_verification", nullable = false)
    private Long id;

    @Column(name = "device_in_verification_number", nullable = false, length = 45, unique = true)
    private String deviceInVerificationNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_device_type", nullable = false)
    private DeviceType idDeviceType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_client", nullable = false)
    private Client idClient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_verifier", nullable = false)
    private Verifier idVerifier;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_standard", nullable = false)
    private Standard idStandard;

    @Column(name = "verification_start_date", nullable = false)
    private String verificationStartDate;



}