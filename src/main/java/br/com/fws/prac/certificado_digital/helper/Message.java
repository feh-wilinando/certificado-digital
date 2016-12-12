package br.com.fws.prac.certificado_digital.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * Created by nando on 02/12/16.
 */
@AllArgsConstructor
public class Message {

    @Getter private String summary;
    @Getter private String detail;
    @Getter private Severity severity;


    public enum Severity {
        SUCCESS,INFO, WARNING, DANGER;
    }


}
