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
@Table(name = "device_in_verification_measurement_channels")
public class DeviceInVerificationMeasurementChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device_in_verification_measurement_channels", nullable = false)
    private Integer id;

    @Column(name = "channel_index_number", nullable = false)
    private Integer channelIndexNumber;

    @Column(name = "error_value", nullable = false)
    private Float errorValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_measurement_channel_type", nullable = false)
    private MeasurementChannelType idMeasurementChannelType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_measurement_protocol_head", nullable = false)
    private MeasurementProtocolHead idMeasurementProtocolHead;



}

