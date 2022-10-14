package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "error_type")
public class ErrorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_error_type", nullable = false)
    private Integer id;

    @Column(name = "error_type_col", nullable = false, length = 20)
    private String errorTypeCol;

    @Column(name = "error_unit", nullable = false, length = 10)
    private String errorUnit;




}