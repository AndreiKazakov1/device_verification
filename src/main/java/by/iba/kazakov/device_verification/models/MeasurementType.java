package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "measurement_type")
public class MeasurementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_measurement_type", nullable = false)
    private Long id;

    @Column(name = "measurement_type_col", nullable = false, length = 255, unique = true)
    private String measurementTypeCol;


}