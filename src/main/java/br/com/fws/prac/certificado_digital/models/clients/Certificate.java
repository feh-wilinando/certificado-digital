package br.com.fws.prac.certificado_digital.models.clients;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by nando on 02/12/16.
 */
@Data
@NoArgsConstructor
@Entity
public class Certificate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoice;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotBlank
    private String collectionLocation;

    @NotNull
    @Min(1)
    private BigDecimal weigth;

    @ManyToOne
    private Company company;

    private LocalDate requestDate;

    private LocalDate emissionDate;

    @PrePersist @PreUpdate
    public void preSaveOrUpdate(){
        this.requestDate = LocalDate.now();
    }

}
