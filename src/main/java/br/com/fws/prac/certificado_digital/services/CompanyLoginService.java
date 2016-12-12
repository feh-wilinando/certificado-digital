package br.com.fws.prac.certificado_digital.services;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.forms.CompanyLoginForm;
import br.com.fws.prac.certificado_digital.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by nando on 02/12/16.
 */
@Service
public class CompanyLoginService {

    @Autowired
    private CompanyRepository repository;


    public boolean evaluate(CompanyLoginForm companyLoginForm) {

        Optional<Company> companyOptional = repository.findByCompanyRegistration(companyLoginForm.getCompanyRegistration());

        if( companyOptional.isPresent() ){
            return companyOptional.get().isActive();
        }

        return false;
    }
}
