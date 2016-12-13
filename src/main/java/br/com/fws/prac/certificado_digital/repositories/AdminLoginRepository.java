package br.com.fws.prac.certificado_digital.repositories;

import br.com.fws.prac.certificado_digital.models.users.AdminUserWrapper;
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
public class AdminLoginRepository implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            return manager.createQuery("select new br.com.fws.prac.certificado_digital.models.users.AdminUserWrapper(a) from Admin a where a.email = :email", AdminUserWrapper.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (NoResultException e){
            throw new UsernameNotFoundException("Usuário " + email + " não encontrado!");
        }
    }
}
