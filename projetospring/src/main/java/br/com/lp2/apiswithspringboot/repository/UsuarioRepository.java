package br.com.lp2.apiswithspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lp2.apiswithspringboot.javabeans.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
