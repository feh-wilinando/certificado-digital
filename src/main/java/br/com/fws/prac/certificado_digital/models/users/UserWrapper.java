package br.com.fws.prac.certificado_digital.models.users;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by nando on 04/12/16.
 */
public abstract class UserWrapper<T> implements UserDetails{

    protected final T entity;

    public UserWrapper(T entity){
        this.entity = entity;
    }

}
