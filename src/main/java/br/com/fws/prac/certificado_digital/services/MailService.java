package br.com.fws.prac.certificado_digital.services;

import org.apache.log4j.Logger;
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

    private Logger logger = Logger.getLogger(MailService.class);

    public void send(String to, String body, String subject){

        String msg = String.format("Sending mail from %s, to %s and with subject %s",from, to, subject);
        logger.info(msg);

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
