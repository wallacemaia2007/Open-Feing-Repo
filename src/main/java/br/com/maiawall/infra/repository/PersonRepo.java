package br.com.maiawall.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maiawall.domain.entity.Pearson;

public interface PersonRepo extends JpaRepository<Pearson, Long> {

}
