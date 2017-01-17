package br.com.fws.prac.certificado_digital.services;

import br.com.fws.prac.certificado_digital.models.clients.Certificate;
import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.forms.CertificateRequestForm;
import br.com.fws.prac.certificado_digital.repositories.CertificateRepository;
import br.com.fws.prac.certificado_digital.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by nando on 06/12/16.
 */
@Service
public class CertificateService {

    @Autowired
    private CertificateRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private HttpServletRequest request;


    @Autowired
    private JmsTemplate jms;

    @Value("${certificado-digital.mail.queue.certificate}")
    private String queue;


    public void persist(CertificateRequestForm certificateRequestForm){

        Optional<Company> companyOptional = getCurrentCompany();

        if (companyOptional.isPresent()) {

            Optional<Certificate> certificateOptional = repository.findById(certificateRequestForm.getId());

            Certificate certificate;
            if (certificateOptional.isPresent()){
                certificate = certificateOptional.get();
            }else {
                certificate = new Certificate();
            }

            certificate.setRequester(companyOptional.get());

            certificateRequestForm.to(certificate);

            repository.save(certificate);

            jms.convertAndSend(queue, certificate);

        }

    }


    public List<Certificate> listAllByCurrentCompany(){
        Optional<Company> company = getCurrentCompany();

        if(company.isPresent()) {
            return repository.findAllByRequester(company.get());
        }else {
            return Collections.emptyList();
        }

    }


    public Optional<CertificateRequestForm> findById(Long id){

           Optional<Certificate> certificateOptional = repository.findById(id);

        if ( certificateOptional.isPresent() ){

            CertificateRequestForm certificateRequestForm = new CertificateRequestForm();

            certificateRequestForm.from(certificateOptional.get());

            return Optional.of(certificateRequestForm);

        }

        return Optional.empty();

    }

    public void fillAdditionalData(CertificateRequestForm certificateRequestForm) {
        Optional<Company> companyOptional = getCurrentCompany();

        if (companyOptional.isPresent()){
            Company company = companyOptional.get();

            certificateRequestForm.setCompanyName(company.getCompanyName());
            certificateRequestForm.setAddress(company.getAddress());
            certificateRequestForm.setContact(company.getContact());
        }
    }


    private Optional<Company> getCurrentCompany() {
        String companyRegistration = request.getUserPrincipal().getName();

        return companyRepository.findByCompanyRegistration(companyRegistration);
    }
}
