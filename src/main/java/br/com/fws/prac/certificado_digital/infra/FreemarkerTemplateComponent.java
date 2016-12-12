package br.com.fws.prac.certificado_digital.infra;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by nando on 02/12/16.
 */
@Component
public class FreemarkerTemplateComponent implements Serializable {

    @Autowired
    private Configuration configuration;

    public String execute(String path, Map<String, Object> contents) {
        try {
            Template template = configuration.getTemplate(path);
            StringWriter out = new StringWriter();
            template.process(contents, out);
            return out.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
