package br.com.fws.prac.certificado_digital.listener;

import br.com.fws.prac.certificado_digital.infra.FreemarkerTemplateComponent;
import br.com.fws.prac.certificado_digital.models.clients.Certificate;
import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nando on 07/12/16.
 */
@Component
public class MailSenderListener {


    @Component
    public static class MailCertificateListener {

        @Autowired
        private MailService mailService;

        @Autowired
        private FreemarkerTemplateComponent freemarker;

        @Value("${certificado-digital.mail.request-certificate.subject}")
        private String subject;

        @JmsListener(destination = "queue.mail.sender.certificate")
        public void listener(Certificate certificate){

            Map<String, Object> contents = new HashMap<>();

            contents.put("certificate", certificate);


            String body = freemarker.execute("requested-certificate.ftl", contents);

            mailService.send(body, subject);
        }

    }

    @Component
    public static class MailCompanyListener {

        @Autowired
        private MailService mailService;

        @Autowired
        private FreemarkerTemplateComponent freemarker;

        @Value("${certificado-digital.url.base}")
        private String  urlBase;

        @Value("${certificado-digital.mail.inserted-company.subject}")
        private String subject;

        @JmsListener(destination = "queue.mail.sender.company")
        public void listener(Company company){
            Map<String, Object> contents = new HashMap<>();

            contents.put("company", company);

            contents.put("url", urlBase);

            String body = freemarker.execute("inserted-customer.ftl", contents);

            mailService.send(body, subject);
        }
    }


}
