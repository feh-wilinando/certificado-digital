package br.com.fws.prac.certificado_digital.repositories;

import br.com.fws.prac.certificado_digital.models.clients.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by nando on 02/12/16.
 */
@Repository
public interface CompanyRepository extends org.springframework.data.repository.Repository<Company, Long> {

    Optional<Company> findById(Long id);

    void save(Company company);

    Optional<Company> findByCompanyRegistration(String companyRegistration);

    @Query("select c from Company c where c.activationHash = :hash")
    Optional<Company> findByActivationHash(@Param("hash") String hash);
}
