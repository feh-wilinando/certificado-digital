package br.com.fws.prac.certificado_digital.models.admins;

import br.com.fws.prac.certificado_digital.models.users.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nando on 04/12/16.
 */
@Data
@NoArgsConstructor
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean active;

    @OneToOne
    private Role role;


}
