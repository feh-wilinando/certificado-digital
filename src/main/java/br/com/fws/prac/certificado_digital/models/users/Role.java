package br.com.fws.prac.certificado_digital.models.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nando on 04/12/16.
 */
@Data
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority{

    @Id
    private String name;

    public static final Role ROLE_ADMIN = new Role("ROLE_ADMIN");
    public static final Role ROLE_USER = new Role("ROLE_USER");
    public static final Role ROLE_CLIENT = new Role("ROLE_CLIENT");

    public Role(String  name){
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
