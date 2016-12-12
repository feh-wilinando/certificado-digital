package br.com.fws.prac.certificado_digital.models.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by nando on 02/12/16.
 */
@Data
@NoArgsConstructor
@Embeddable
public class Contact implements Serializable {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String jobTitle;
}
