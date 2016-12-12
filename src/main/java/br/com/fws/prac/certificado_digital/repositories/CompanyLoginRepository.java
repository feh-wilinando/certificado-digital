package br.com.fws.prac.certificado_digital.repositories;

import br.com.fws.prac.certificado_digital.models.users.CompanyUserWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by nando on 04/12/16.
 */
@Repository
public class CompanyLoginRepository implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public UserDetails loadUserByUsername(String companyRegistration) throws UsernameNotFoundException {
        try {
            CompanyUserWrapper companyUser = manager.createQuery("select new br.com.fws.prac.certificado_digital.models.users.CompanyUserWrapper(c) from Company c where c.companyRegistration = :companyRegistration", CompanyUserWrapper.class)
                    .setParameter("companyRegistration", companyRegistration)
                    .getSingleResult();
            return companyUser;
        }catch (NoResultException e){
            throw new UsernameNotFoundException("O CNPJ: " + companyRegistration + " não está cadastrado!");
        }

    }
}
