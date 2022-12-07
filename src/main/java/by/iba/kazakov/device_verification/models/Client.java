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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Long id;

    @Column(name = "client_name", nullable = false, length = 45)
    private String clientName;

    @Column(name = "client_address", nullable = false, length = 150)
    private String clientAddress;

    @Column(name = "client_phone_number", length = 20)
    private String clientPhoneNumber;

    @Column(name = "client_file_code", nullable = false, unique = true)
    private Integer clientFileCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;



}