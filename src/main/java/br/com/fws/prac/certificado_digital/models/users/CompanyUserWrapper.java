package br.com.fws.prac.certificado_digital.models.users;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by nando on 04/12/16.
 */
public class CompanyUserWrapper extends UserWrapper<Company> {

    public CompanyUserWrapper(Company company) {
        super(company);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(Role.ROLE_CLIENT);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return entity.getCompanyRegistration();
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
