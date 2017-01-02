package br.com.fws.prac.certificado_digital.services;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.forms.CompanyForm;
import br.com.fws.prac.certificado_digital.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by nando on 02/12/16.
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private JmsTemplate template;

    @Value("${certificado-digital.mail.queue.requester}")
    private String queue;

    public void persist(CompanyForm companyForm) {

        Optional<Company> companyOptional = repository.findById(companyForm.getId());

        Company company;
        if(companyOptional.isPresent()) {
            company = companyOptional.get();
        } else {
            company = new Company();
        }

        companyForm.to(company);

        company.setActivationHash(UUID.randomUUID().toString());

        repository.save(company);

        template.convertAndSend(queue, company);

    }

    public Optional<CompanyForm> activeByHash(String hash) {

        Optional<Company> companyOptional = repository.findByActivationHash(hash);

        if (companyOptional.isPresent()){
            Company company = companyOptional.get();

            company.setActive(true);
            company.setActivationHash("");

            repository.save(company);

            CompanyForm companyForm = new CompanyForm();
            companyForm.from(company);


            return Optional.of(companyForm);

        }


        return Optional.empty();
    }

    public Optional<CompanyForm> getCurrentCompanyForm() {

        if (isLogged()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            String companyRegistration = (String) authentication.getPrincipal();

            Optional<Company> companyOptional = repository.findByCompanyRegistration(companyRegistration);

            if(companyOptional.isPresent()) {
                CompanyForm companyForm = new CompanyForm();

                companyForm.from(companyOptional.get());

                return Optional.of(companyForm);
            }
        }

        return Optional.empty();
    }


    public  boolean isLogged(){
        String  authenticated =  (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return !authenticated.equals("anonymousUser");
    }
}
