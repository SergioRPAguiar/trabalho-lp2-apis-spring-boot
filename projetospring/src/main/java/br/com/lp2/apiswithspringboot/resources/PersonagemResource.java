package br.com.lp2.apiswithspringboot.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lp2.apiswithspringboot.javabeans.Personagem;
import br.com.lp2.apiswithspringboot.repository.PersonagemRepository;

@Controller
@RequestMapping("/api/personagem")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class PersonagemResource {

	@Autowired
	PersonagemRepository personagemRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Personagem salvarPersonagem(@RequestBody Personagem personagem) {
		return personagemRepository.save(personagem);
	}

	@GetMapping("/listarPersonagem/{idPersonagem}")
	@ResponseBody
	public Optional<Personagem> listarPersonagem(@PathVariable long idPersonagem) {
		return personagemRepository.findById(idPersonagem);
	}

	@GetMapping("/listarPersonagems")
	@ResponseBody
	public Iterable<Personagem> listarPersonagems() {
		return personagemRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idPersonagem}")
	@ResponseBody
	public void atualizarPersonagem(@PathVariable long idPersonagem, @RequestBody Personagem novoPersonagem) {

		Optional<Personagem> antigoPersonagem = personagemRepository.findById(idPersonagem);

		if (antigoPersonagem.isPresent()) {
			antigoPersonagem.get().setNomePersonagem(novoPersonagem.getNomePersonagem());
			personagemRepository.save(antigoPersonagem.get());
		}

	}

	@PostMapping("/deletarPersonagem/{idPersonagem}")
	@ResponseBody
	public void deletarPersonagem(@PathVariable long idPersonagem) {
		personagemRepository.deleteById(idPersonagem);
	}
	
}
