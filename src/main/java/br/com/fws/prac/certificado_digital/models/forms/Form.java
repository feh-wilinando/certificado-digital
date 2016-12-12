package br.com.fws.prac.certificado_digital.models.forms;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by nando on 12/12/16.
 */
public interface Form<T> {

    void from(T entity);
    void to(T entity);

}
