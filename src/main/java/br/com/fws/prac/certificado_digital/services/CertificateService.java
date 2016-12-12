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

        String companyRegistration = request.getUserPrincipal().getName();

        Optional<Company> companyOptional = companyRepository.findByCompanyRegistration(companyRegistration);

        if (companyOptional.isPresent()) {

            Optional<Certificate> certificateOptional = repository.findById(certificateRequestForm.getId());

            Certificate certificate;
            if (certificateOptional.isPresent()){
                certificate = certificateOptional.get();
            }else {
                certificate = new Certificate();
            }

            certificate.setCompany(companyOptional.get());

            certificateRequestForm.to(certificate);

            repository.save(certificate);

            jms.convertAndSend(queue, certificate);

        }

    }


    public List<Certificate> listAllByCurrentCompany(){
        String companyRegistration = request.getUserPrincipal().getName();


        Optional<Company> company = companyRepository.findByCompanyRegistration(companyRegistration);

        if(company.isPresent()) {
            return repository.findAllByCompany(company.get());
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

}
