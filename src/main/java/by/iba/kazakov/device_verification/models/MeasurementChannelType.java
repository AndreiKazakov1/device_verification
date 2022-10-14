package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "measurement_channel_type")
public class MeasurementChannelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_measuremetnt_channel_type", nullable = false)
    private Integer id;

    @Column(name = "sensor_type", nullable = false, length = 45)
    private String sensorType;

    @Column(name = "nominal_static_characteristic", nullable = false, length = 100)
    private String nominalStaticCharacteristic;

    @Column(name = "start_input_range", nullable = false, precision = 8, scale = 2)
    private BigDecimal startInputRange;

    @Column(name = "end_input_range", nullable = false, precision = 8, scale = 2)
    private BigDecimal endInputRange;

    @Column(name = "start_output_range", nullable = false, precision = 8, scale = 2)
    private BigDecimal startOutputRange;

    @Column(name = "end_output_range", nullable = false, precision = 8, scale = 2)
    private BigDecimal endOutputRange;

    @Column(name = "input_measuring_signal_unit", nullable = false, length = 20)
    private String inputMeasuringSignalUnit;

    @Column(name = "output_measuring_signal_unit", nullable = false, length = 20)
    private String outputMeasuringSignalUnit;



}