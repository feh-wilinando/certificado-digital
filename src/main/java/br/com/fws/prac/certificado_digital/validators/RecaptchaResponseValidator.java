package br.com.fws.prac.certificado_digital.validators;

import br.com.fws.prac.certificado_digital.models.forms.Form;
import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by nando on 10/12/16.
 */
@Component
public class RecaptchaResponseValidator implements ConstraintValidator<UseRecaptcha, Form<?>> {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RecaptchaValidator recaptchaValidator;

    @Override
    public void initialize(UseRecaptcha constraintAnnotation) {

    }

    @Override
    public boolean isValid(Form<?> value, ConstraintValidatorContext context) {

        ValidationResult validate = recaptchaValidator.validate(request);

        return validate.isSuccess();
    }
}
