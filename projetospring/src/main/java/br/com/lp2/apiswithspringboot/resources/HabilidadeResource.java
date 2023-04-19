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

import br.com.lp2.apiswithspringboot.javabeans.Habilidade;
import br.com.lp2.apiswithspringboot.repository.HabilidadeRepository;

@Controller
@RequestMapping("/api/habilidade")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class HabilidadeResource {

	@Autowired
	HabilidadeRepository habilidadeRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Habilidade salvarHabilidade(@RequestBody Habilidade habilidade) {
		return habilidadeRepository.save(habilidade);
	}

	@GetMapping("/listarHabilidade/{idHabilidade}")
	@ResponseBody
	public Optional<Habilidade> listarHabilidade(@PathVariable long idHabilidade) {
		return habilidadeRepository.findById(idHabilidade);
	}

	@GetMapping("/listarHabilidades")
	@ResponseBody
	public Iterable<Habilidade> listarHabilidades() {
		return habilidadeRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idHabilidade}")
	@ResponseBody
	public void atualizarHabilidade(@PathVariable long idHabilidade, @RequestBody Habilidade novoHabilidade) {

		Optional<Habilidade> antigoHabilidade = habilidadeRepository.findById(idHabilidade);

		if (antigoHabilidade.isPresent()) {
			antigoHabilidade.get().setNomeHabilidade(novoHabilidade.getNomeHabilidade());
			habilidadeRepository.save(antigoHabilidade.get());
		}

	}

	@PostMapping("/deletarHabilidade/{idHabilidade}")
	@ResponseBody
	public void deletarHabilidade(@PathVariable long idHabilidade) {
		habilidadeRepository.deleteById(idHabilidade);
	}
	
}
