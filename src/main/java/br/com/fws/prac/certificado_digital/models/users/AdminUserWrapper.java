package br.com.fws.prac.certificado_digital.models.users;

import br.com.fws.prac.certificado_digital.models.admins.Admin;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by nando on 04/12/16.
 */
public class AdminUserWrapper extends UserWrapper<Admin> {

    public AdminUserWrapper(Admin admin) {
        super(admin);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(entity.getRole());
    }

    @Override
    public String getPassword() {
        return entity.getPassword();
    }

    @Override
    public String getUsername() {
        return entity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return entity.isActive();
    }
}
