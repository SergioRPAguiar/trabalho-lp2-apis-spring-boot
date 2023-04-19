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

import br.com.lp2.apiswithspringboot.javabeans.Granada;
import br.com.lp2.apiswithspringboot.repository.GranadaRepository;

@Controller
@RequestMapping("/api/granada")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class GranadaResource {

	@Autowired
	GranadaRepository granadaRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Granada salvarGranada(@RequestBody Granada granada) {
		return granadaRepository.save(granada);
	}

	@GetMapping("/listarGranada/{idGranada}")
	@ResponseBody
	public Optional<Granada> listarGranada(@PathVariable long idGranada) {
		return granadaRepository.findById(idGranada);
	}

	@GetMapping("/listarGranadas")
	@ResponseBody
	public Iterable<Granada> listarGranadas() {
		return granadaRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idGranada}")
	@ResponseBody
	public void atualizarGranada(@PathVariable long idGranada, @RequestBody Granada novoGranada) {

		Optional<Granada> antigoGranada = granadaRepository.findById(idGranada);

		if (antigoGranada.isPresent()) {
			antigoGranada.get().setNomeGranada(novoGranada.getNomeGranada());
			granadaRepository.save(antigoGranada.get());
		}

	}

	@PostMapping("/deletarGranada/{idGranada}")
	@ResponseBody
	public void deletarGranada(@PathVariable long idGranada) {
		granadaRepository.deleteById(idGranada);
	}
	
}
