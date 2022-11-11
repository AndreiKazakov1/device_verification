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
@Table(name = "device_type")
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device_type", nullable = false)
    private Integer id;

    @Column(name = "measurement_device_type", nullable = false, length = 150)
    private String measurementDeviceType;

    @Column(name = "device_file_code", nullable = false, unique = true)
    private Integer deviceFileCode;

    @Column(name = "device_name", nullable = false, length = 100, unique = true)
    private String deviceName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_measurement_type", nullable = false)
    private MeasurementType idMeasurementType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_methodology", nullable = false)
    private Methodology idMethodology;


}