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

import br.com.lp2.apiswithspringboot.javabeans.Arma;
import br.com.lp2.apiswithspringboot.repository.ArmaRepository;

@Controller
@RequestMapping("/api/arma")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class ArmaResource {

	@Autowired
	ArmaRepository armaRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Arma salvarArma(@RequestBody Arma arma) {
		return armaRepository.save(arma);
	}

	@GetMapping("/listarArma/{idArma}")
	@ResponseBody
	public Optional<Arma> listarArma(@PathVariable long idArma) {
		return armaRepository.findById(idArma);
	}

	@GetMapping("/listarArmas")
	@ResponseBody
	public Iterable<Arma> listarArmas() {
		return armaRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idArma}")
	@ResponseBody
	public void atualizarArma(@PathVariable long idArma, @RequestBody Arma novoArma) {

		Optional<Arma> antigoArma = armaRepository.findById(idArma);

		if (antigoArma.isPresent()) {
			antigoArma.get().setNomeArma(novoArma.getNomeArma());
			armaRepository.save(antigoArma.get());
		}

	}

	@PostMapping("/deletarArma/{idArma}")
	@ResponseBody
	public void deletarArma(@PathVariable long idArma) {
		armaRepository.deleteById(idArma);
	}
}
