package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "standart")
public class Standart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_standart", nullable = false)
    private Integer id;

    @Column(name = "standart_name", nullable = false, length = 100)
    private String standartName;

    @Column(name = "standart_number", nullable = false, length = 20)
    private String standartNumber;

    @Column(name = "standart_verification_date", nullable = false)
    private LocalDate standartVerificationDate;



}