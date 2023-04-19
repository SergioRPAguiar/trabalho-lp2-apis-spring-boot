package br.com.lp2.apiswithspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lp2.apiswithspringboot.javabeans.Personagem;

public interface PersonagemRepository extends CrudRepository<Personagem, Long>{

}
