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

import br.com.lp2.apiswithspringboot.javabeans.Usuario;
import br.com.lp2.apiswithspringboot.repository.UsuarioRepository;



@Controller
@RequestMapping("/api/usuario")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Usuario salvarUsuario(@RequestBody Usuario nickname) {
		return usuarioRepository.save(nickname);
	}

	@GetMapping("/listarUsuario/{idUsuario}")
	@ResponseBody
	public Optional<Usuario> listarUsuario(@PathVariable long idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}

	@GetMapping("/listarUsuarios")
	@ResponseBody
	public Iterable<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idUsuario}")
	@ResponseBody
	public void atualizarUsuario(@PathVariable long idUsuario, @RequestBody Usuario novoUsuario) {

		Optional<Usuario> antigoUsuario = usuarioRepository.findById(idUsuario);

		if (antigoUsuario.isPresent()) {
			antigoUsuario.get().setNickname(novoUsuario.getNickname());
			usuarioRepository.save(antigoUsuario.get());
		}

	}

	@PostMapping("/deletarUsuario/{idUsuario}")
	@ResponseBody
	public void deletarUsuario(@PathVariable long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}

}
