package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "standard")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_standard", nullable = false)
    private Long id;

    @Column(name = "standard_name", nullable = false, length = 100, unique = true)
    private String standardName;

    @Column(name = "standard_number", nullable = false, length = 20)
    private String standardNumber;

    @Column(name = "standard_verification_date", nullable = false)
    private String standardVerificationDate;



}