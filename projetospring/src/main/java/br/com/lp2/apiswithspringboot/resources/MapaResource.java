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

import br.com.lp2.apiswithspringboot.javabeans.Mapa;
import br.com.lp2.apiswithspringboot.repository.MapaRepository;

@Controller
@RequestMapping("/api/mapa")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class MapaResource {

	@Autowired
	MapaRepository mapaRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Mapa salvarMapa(@RequestBody Mapa mapa) {
		return mapaRepository.save(mapa);
	}

	@GetMapping("/listarMapa/{idMapa}")
	@ResponseBody
	public Optional<Mapa> listarMapa(@PathVariable long idMapa) {
		return mapaRepository.findById(idMapa);
	}

	@GetMapping("/listarMapas")
	@ResponseBody
	public Iterable<Mapa> listarMapas() {
		return mapaRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idMapa}")
	@ResponseBody
	public void atualizarMapa(@PathVariable long idMapa, @RequestBody Mapa novoMapa) {

		Optional<Mapa> antigoMapa = mapaRepository.findById(idMapa);

		if (antigoMapa.isPresent()) {
			antigoMapa.get().setNomeMapa(novoMapa.getNomeMapa());
			mapaRepository.save(antigoMapa.get());
		}

	}

	@PostMapping("/deletarMapa/{idMapa}")
	@ResponseBody
	public void deletarMapa(@PathVariable long idMapa) {
		mapaRepository.deleteById(idMapa);
	}
}
