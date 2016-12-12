package br.com.fws.prac.certificado_digital.models.clients;

import br.com.fws.prac.certificado_digital.models.commons.Address;
import br.com.fws.prac.certificado_digital.models.commons.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by nando on 02/12/16.
 */
@Data
@NoArgsConstructor
@Entity
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String companyName;

    @CNPJ
    @NotBlank
    @Column(unique = true)
    private String companyRegistration;

    private String municipalRegistration;

    private String stateRegistration;

    @Embedded
    @NotNull
    @Valid
    private Address address = new Address();

    @NotNull
    @Embedded
    @Valid
    private Contact contact = new Contact();


    private String phoneNumber;

    private String cellNumber;

    @NotNull
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean active;


    private String activationHash;


}
