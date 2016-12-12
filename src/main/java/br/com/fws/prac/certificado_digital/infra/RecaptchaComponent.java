package br.com.fws.prac.certificado_digital.infra;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by nando on 02/12/16.
 */
@Component
public class RecaptchaComponent {

    @Value("${recaptcha.validation.publicKey}")
    @Getter
    private String publicKey;

    @Value("${recaptcha.validation.secretKey}")
    @Getter
    private String secretKey;

    @Value("${recaptcha.validation.verificationUrl}")
    @Getter
    private String apiRecaptchaEndpoint;

}
