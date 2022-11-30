package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "measurement_protocol_head")
public class MeasurementProtocolHead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_measurement_protocol_head", nullable = false)
    private Long id;

    @Column(name = "measurement_protocol_head_number", nullable = false, length = 20, unique = true)
    private String measurementProtocolHeadNumber;

    @Column(name = "measurement_protocol_head_verification_Org", nullable = false, length = 20)
    private String measurementProtocolHeadVerOrg;

    @Column(name = "measurement_protocol_head_date", nullable = false, length = 10)
    private String measurementProtocolHeadDate;

    @Column(name = "lab_temperature", nullable = false, precision = 5, scale = 1)
    private BigDecimal labTemperature;

    @Column(name = "lab_humidity", nullable = false, precision = 5, scale = 1)
    private BigDecimal labHumidity;

    @Column(name = "lab_pressure", nullable = false, precision = 5, scale = 1)
    private BigDecimal labPressure;

    @Column(name = "lab_voltage", nullable = false, precision = 5, scale = 1)
    private BigDecimal labVoltage;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @Column(name = "device_in_verification_measurement_channels_quantity", nullable = false)
    private Integer deviceInVerificationMeasurementChannelsQuantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_error_type", nullable = false)
    private ErrorType idErrorType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_device_in_verification", nullable = false)
    private DeviceInVerification idDeviceInVerification;



}