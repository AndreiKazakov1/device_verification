package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "measurement_process")
public class MeasurementProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_measurement_process", nullable = false)
    private Integer id;

    @Column(name = "verification_point_index_number", nullable = false)
    private Integer verificationPointIndexNumber;

    @Column(name = "input_verification_point_value", nullable = false)
    private Float inputVerificationPointValue;

    @Column(name = "output_verification_point_value", nullable = false)
    private Float outputVerificationPointValue;

    @Column(name = "input_verification_point_unit", nullable = false, length = 20)
    private String inputVerificationPointUnit;

    @Column(name = "output_verification_point_unit", nullable = false, length = 20)
    private String outputVerificationPointUnit;

    @Column(name = "measured_value", nullable = false)
    private Float measuredValue;

    @Column(name = "calculated_error_value", nullable = false)
    private Float calculatedErrorValue;

    @Column(name = "external_inspection", nullable = false, length = 20)
    private String externalInspection;

    @Column(name = "device_testing", nullable = false, length = 20)
    private String deviceTesting;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_device_in_verification_measurement_channels", nullable = false)
    private DeviceInVerificationMeasurementChannel idDeviceInVerificationMeasurementChannels;



}