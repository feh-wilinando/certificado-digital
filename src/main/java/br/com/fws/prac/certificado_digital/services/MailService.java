package br.com.fws.prac.certificado_digital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by nando on 02/12/16.
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${certificado-digital.mail.from}")
    private String from;


    @Value("${certificado-digital.mail.to}")
    private String to;

    public void send(String body, String subject){


        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();

            mimeMessage.setFrom(from);
            mimeMessage.setSubject(subject);

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
            helper.setTo(to);
            helper.setText(body,true);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }



    }

}
