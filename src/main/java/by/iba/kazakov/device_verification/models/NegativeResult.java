package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "negative_result")
public class NegativeResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_negative_result", nullable = false)
    private Long id;

    @Column(name = "unsuitability_conclusion_number", nullable = false, length = 30)
    private String unsuitabilityConclusionNumber;

    @Column(name = "verification_end_date", nullable = false)
    private Instant verificationEndDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_device_in_verification", nullable = false)
    private DeviceInVerification idDeviceInVerification;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_measurement_protocol_body", nullable = false)
    private MeasurementProtocolBody idMeasurementProtocolBody;



}