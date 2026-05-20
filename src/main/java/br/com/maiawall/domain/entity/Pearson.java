package br.com.maiawall.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
    private String name;
    private String cep;

    public Pearson(Long id, String name, String cep) {
        if (id == null) {
            this.id = System.currentTimeMillis();
        }
        this.name = name;
        this.cep = cep;
    }

}
