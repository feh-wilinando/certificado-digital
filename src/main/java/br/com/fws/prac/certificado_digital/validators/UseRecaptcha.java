package br.com.fws.prac.certificado_digital.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nando on 10/12/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = RecaptchaResponseValidator.class)
public @interface UseRecaptcha {

    String message() default "Houve um problema ao validar a captcha do seu formulario";


    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
