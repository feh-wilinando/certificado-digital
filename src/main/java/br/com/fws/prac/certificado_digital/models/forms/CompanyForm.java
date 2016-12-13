package br.com.fws.prac.certificado_digital.models.forms;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.commons.Address;
import br.com.fws.prac.certificado_digital.models.commons.Contact;
import br.com.fws.prac.certificado_digital.validators.UniqueCompanyRegistration;
import br.com.fws.prac.certificado_digital.validators.UseRecaptcha;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by nando on 10/12/16.
 */
@Data
@NoArgsConstructor
@UseRecaptcha
@UniqueCompanyRegistration
public class CompanyForm implements Form<Company>{

    private Long id;

    @NotBlank
    private String companyName;

    @CNPJ
    @NotBlank
    private String companyRegistration;

    private String municipalRegistration;

    private String stateRegistration;

    @NotNull
    @Valid
    private Address address = new Address();

    @Embedded
    @Valid
    private Contact contact = new Contact();

    private String phoneNumber;

    private String cellNumber;

    @Override
    public void from(Company entity) {
        id = entity.getId();
        companyName = entity.getCompanyName();
        companyRegistration = entity.getCompanyRegistration();
        municipalRegistration = entity.getMunicipalRegistration();
        stateRegistration = entity.getStateRegistration();
        address = entity.getAddress();
        contact = entity.getContact();
        phoneNumber = entity.getPhoneNumber();
        cellNumber = entity.getCellNumber();

    }

    @Override
    public void to(Company entity) {

        entity.setId(id);
        entity.setCompanyName(companyName);
        entity.setCompanyRegistration(companyRegistration);
        entity.setMunicipalRegistration(municipalRegistration);
        entity.setStateRegistration(stateRegistration);
        entity.setAddress(address);
        entity.setContact(contact);
        entity.setPhoneNumber(phoneNumber);
        entity.setCellNumber(cellNumber);
    }
}
