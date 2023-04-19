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

import br.com.lp2.apiswithspringboot.javabeans.EfeitoSonoro;
import br.com.lp2.apiswithspringboot.repository.EfeitoSonoroRepository;

@Controller
@RequestMapping("/api/efeitoSonoro")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class EfeitoSonoroResource {

	@Autowired
	EfeitoSonoroRepository efeitoSonoroRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public EfeitoSonoro salvarEfeitoSonoro(@RequestBody EfeitoSonoro efeitoSonoro) {
		return efeitoSonoroRepository.save(efeitoSonoro);
	}

	@GetMapping("/listarEfeitoSonoro/{idEfeitoSonoro}")
	@ResponseBody
	public Optional<EfeitoSonoro> listarEfeitoSonoro(@PathVariable long idEfeitoSonoro) {
		return efeitoSonoroRepository.findById(idEfeitoSonoro);
	}

	@GetMapping("/listarEfeitoSonoros")
	@ResponseBody
	public Iterable<EfeitoSonoro> listarEfeitoSonoros() {
		return efeitoSonoroRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idEfeitoSonoro}")
	@ResponseBody
	public void atualizarEfeitoSonoro(@PathVariable long idEfeitoSonoro, @RequestBody EfeitoSonoro novoEfeitoSonoro) {

		Optional<EfeitoSonoro> antigoEfeitoSonoro = efeitoSonoroRepository.findById(idEfeitoSonoro);

		if (antigoEfeitoSonoro.isPresent()) {
			antigoEfeitoSonoro.get().setNomeEfeitoSonoro(novoEfeitoSonoro.getNomeEfeitoSonoro());
			efeitoSonoroRepository.save(antigoEfeitoSonoro.get());
		}

	}

	@PostMapping("/deletarEfeitoSonoro/{idEfeitoSonoro}")
	@ResponseBody
	public void deletarEfeitoSonoro(@PathVariable long idEfeitoSonoro) {
		efeitoSonoroRepository.deleteById(idEfeitoSonoro);
	}
	
}
