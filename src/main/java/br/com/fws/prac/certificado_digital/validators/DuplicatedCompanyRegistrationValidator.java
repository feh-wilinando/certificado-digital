package br.com.fws.prac.certificado_digital.validators;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.forms.CompanyForm;
import br.com.fws.prac.certificado_digital.models.forms.Form;
import br.com.fws.prac.certificado_digital.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Created by nando on 12/12/16.
 */
@Component
public class DuplicatedCompanyRegistrationValidator implements ConstraintValidator<UniqueCompanyRegistration, CompanyForm> {

    @Autowired
    private CompanyRepository repository;

    private String message;

    @Override
    public void initialize(UniqueCompanyRegistration constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(CompanyForm companyForm, ConstraintValidatorContext context) {

        if (companyForm.getId() != null) return true;

        Optional<Company> companyOptional = repository.findByCompanyRegistration(companyForm.getCompanyRegistration());

        boolean isValid = !companyOptional.isPresent();

        if (!isValid){
            context.buildConstraintViolationWithTemplate(message).addPropertyNode("companyRegistration").addConstraintViolation();
        }

        return isValid;
    }



}
