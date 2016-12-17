package br.com.fws.prac.certificado_digital.models.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by nando on 02/12/16.
 */
@Data
@NoArgsConstructor
@Embeddable
public class Address implements Serializable{

    @NotBlank
    private String street;

    @Min(1)
    private Integer number;

    private String complement;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String city;

    @NotNull
    @Enumerated(EnumType.STRING)
    private State state;

    @NotBlank
    private String zipCode;

}
