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

import br.com.lp2.apiswithspringboot.javabeans.ModoJogo;
import br.com.lp2.apiswithspringboot.repository.ModoJogoRepository;

@Controller
@RequestMapping("/api/modoJogo")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class ModoJogoResource {

	@Autowired
	ModoJogoRepository modoJogoRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public ModoJogo salvarModoJogo(@RequestBody ModoJogo modoJogo) {
		return modoJogoRepository.save(modoJogo);
	}

	@GetMapping("/listarModoJogo/{idModoJogo}")
	@ResponseBody
	public Optional<ModoJogo> listarModoJogo(@PathVariable long idModoJogo) {
		return modoJogoRepository.findById(idModoJogo);
	}

	@GetMapping("/listarModoJogos")
	@ResponseBody
	public Iterable<ModoJogo> listarModoJogos() {
		return modoJogoRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idModoJogo}")
	@ResponseBody
	public void atualizarModoJogo(@PathVariable long idModoJogo, @RequestBody ModoJogo novoModoJogo) {

		Optional<ModoJogo> antigoModoJogo = modoJogoRepository.findById(idModoJogo);

		if (antigoModoJogo.isPresent()) {
			antigoModoJogo.get().setNomeModoJogo(novoModoJogo.getNomeModoJogo());
			modoJogoRepository.save(antigoModoJogo.get());
		}

	}

	@PostMapping("/deletarModoJogo/{idModoJogo}")
	@ResponseBody
	public void deletarModoJogo(@PathVariable long idModoJogo) {
		modoJogoRepository.deleteById(idModoJogo);
	}
	
}
