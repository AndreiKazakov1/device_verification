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
    private Integer id;

    @Column(name = "measurement_protocol_head_number", nullable = false, length = 10)
    private String measurementProtocolHeadNumber;

    @Column(name = "lab_temperature", nullable = false, precision = 5, scale = 1)
    private BigDecimal labTemperature;

    @Column(name = "lab_humidity", nullable = false, precision = 5, scale = 1)
    private BigDecimal labHumidity;

    @Column(name = "lab_preasure", nullable = false, precision = 5, scale = 1)
    private BigDecimal labPreasure;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

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