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

import br.com.lp2.apiswithspringboot.javabeans.Skin;
import br.com.lp2.apiswithspringboot.repository.SkinRepository;

@Controller
@RequestMapping("/api/skin")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class SkinResource {
	
	@Autowired
	SkinRepository skinRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Skin salvarSkin(@RequestBody Skin skin) {
		return skinRepository.save(skin);
	}

	@GetMapping("/listarSkin/{idSkin}")
	@ResponseBody
	public Optional<Skin> listarSkin(@PathVariable long idSkin) {
		return skinRepository.findById(idSkin);
	}

	@GetMapping("/listarSkins")
	@ResponseBody
	public Iterable<Skin> listarSkins() {
		return skinRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idSkin}")
	@ResponseBody
	public void atualizarSkin(@PathVariable long idSkin, @RequestBody Skin novoSkin) {

		Optional<Skin> antigoSkin = skinRepository.findById(idSkin);

		if (antigoSkin.isPresent()) {
			antigoSkin.get().setNomeSkin(novoSkin.getNomeSkin());
			skinRepository.save(antigoSkin.get());
		}

	}

	@PostMapping("/deletarSkin/{idSkin}")
	@ResponseBody
	public void deletarSkin(@PathVariable long idSkin) {
		skinRepository.deleteById(idSkin);
	}
	
}
