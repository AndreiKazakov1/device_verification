package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "methodology")
public class Methodology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_methodology", nullable = false)
    private Long id;

    @Column(name = "methodology_name", nullable = false, length = 100, unique = true)
    private String methodologyName;

    @Column(name = "methodology_number", nullable = false, length = 45, unique = true)
    private String methodologyNumber;

    @Column(name = "methodology_introduction_year", nullable = false)
    private Integer methodologyIntroductionYear;


}