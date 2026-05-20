package br.com.maiawall.domain.entity;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pearson")
@Getter
@Setter
@NoArgsConstructor
public class Pearson {

    @Id
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    // @CPF(message = "Invalid CPF")
    private String cpf;

    // @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "CEP is mandatory")
    private String cep;

    public Pearson(Long id, String name, String cep, String cpf, String email) {
        if (id == null) {
            this.id = System.currentTimeMillis();
        }
        this.name = name;
        this.cep = cep;
        this.cpf = cpf;
        this.email = email;
    }

}
