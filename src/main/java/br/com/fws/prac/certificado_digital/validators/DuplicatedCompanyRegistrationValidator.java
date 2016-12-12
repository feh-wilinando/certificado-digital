package br.com.fws.prac.certificado_digital.validators;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.forms.CompanyForm;
import br.com.fws.prac.certificado_digital.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * Created by nando on 12/12/16.
 */
@Component
public class DuplicatedCompanyRegistrationValidator implements Validator {

    @Autowired
    private CompanyRepository repository;


    @Override
    public boolean supports(Class<?> clazz) {
        return CompanyForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CompanyForm companyForm = (CompanyForm) target;

        Optional<Company> companyOptional = repository.findByCompanyRegistration(companyForm.getCompanyRegistration());

        if (companyOptional.isPresent() && companyForm.getId() == null){
            errors.rejectValue("companyRegistration","company.companyRegistration", "CNPJ já cadastrado");
        }

    }
}
