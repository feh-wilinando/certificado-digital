package br.com.fws.prac.certificado_digital.models.clients;

import br.com.fws.prac.certificado_digital.models.commons.Address;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private Integer volume;

    @NotNull
    @Min(1)
    private BigDecimal weigth;

    @ManyToOne
    private Company requester;

    private LocalTime startingTime;

    private LocalTime endingTime;

    @Embedded
    @Valid
    private Address address = new Address();

    @NotBlank
    private String companyName;

    private LocalDate requestDate;

    private LocalDate emissionDate;

    @NotNull
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean palletizedAndStretched;

    @PrePersist @PreUpdate
    public void preSaveOrUpdate(){
        this.requestDate = LocalDate.now();
    }

}
