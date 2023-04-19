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

import br.com.lp2.apiswithspringboot.javabeans.Clan;
import br.com.lp2.apiswithspringboot.repository.ClanRepository;

@Controller
@RequestMapping("/api/clan")
@ComponentScan("br.com.lp2.apiswithspringboot.repository")
public class ClanResource {

	@Autowired
	ClanRepository clanRepository;

	@PostMapping("/inserir")
	@ResponseBody
	public Clan salvarClan(@RequestBody Clan clan) {
		return clanRepository.save(clan);
	}

	@GetMapping("/listarClan/{idClan}")
	@ResponseBody
	public Optional<Clan> listarClan(@PathVariable long idClan) {
		return clanRepository.findById(idClan);
	}

	@GetMapping("/listarClans")
	@ResponseBody
	public Iterable<Clan> listarClans() {
		return clanRepository.findAll();
	}

	@PostMapping(value = "/atualizar/{idClan}")
	@ResponseBody
	public void atualizarClan(@PathVariable long idClan, @RequestBody Clan novoClan) {

		Optional<Clan> antigoClan = clanRepository.findById(idClan);

		if (antigoClan.isPresent()) {
			antigoClan.get().setNomeClan(novoClan.getNomeClan());
			clanRepository.save(antigoClan.get());
		}

	}

	@PostMapping("/deletarClan/{idClan}")
	@ResponseBody
	public void deletarClan(@PathVariable long idClan) {
		clanRepository.deleteById(idClan);
	}
	
}
