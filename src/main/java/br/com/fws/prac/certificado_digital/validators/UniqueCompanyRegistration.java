package br.com.fws.prac.certificado_digital.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nando on 13/12/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = DuplicatedCompanyRegistrationValidator.class)
public @interface UniqueCompanyRegistration {

    String message() default "CNPJ já cadastrado";


    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
