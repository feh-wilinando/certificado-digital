package br.com.fws.prac.certificado_digital.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * Created by nando on 02/12/16.
 */
@Data
@NoArgsConstructor
public class CompanyLoginForm {

    @CNPJ
    @NotBlank
    private String companyRegistration;

}
