package br.com.fws.prac.certificado_digital.repositories;

import br.com.fws.prac.certificado_digital.models.clients.Certificate;
import br.com.fws.prac.certificado_digital.models.clients.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by nando on 02/12/16.
 */
@Repository
public interface CertificateRepository extends org.springframework.data.repository.Repository<Certificate, Long> {

    void save(Certificate certificate);

    List<Certificate> findAllByCompany(Company company);

    Optional<Certificate> findById(Long id);

    boolean exists(Long id);

}
