package com.cafemv.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafemv.dto.CafeDTO;
import com.cafemv.dto.MensagemDTO;
import com.cafemv.exceptions.RegraException;
import com.cafemv.model.Cafe;
import com.cafemv.repository.CafeRepository;
@RestController
@RequestMapping("/cafe")
public class CafeController{
	
	
	@Autowired
	CafeRepository cafeRepository;
	@PostMapping
	public ResponseEntity<Cafe> criarCafe(@RequestBody Cafe newCafe){
		validarCpf(newCafe.getCpf());
		verificarCafe(newCafe.getCafe());
		Cafe cafe = cafeRepository.save(newCafe);
		return new ResponseEntity<>(cafe, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CafeDTO> buscarCafe(){
		List<Cafe> cafe = cafeRepository.findAll();
		
		List<CafeDTO> resposta = cafe.stream().map(
				obj -> new CafeDTO(obj.getId(), obj.getNome(), obj.getCpf(), obj.getCafe())).collect(Collectors.toList());
		return resposta;
	}
	@DeleteMapping("/{id}")
	public MensagemDTO deleteCafe(@PathVariable Long id) {
		cafeRepository.deleteById(id);
		
		return new MensagemDTO("Café removido!" + id);
	}
	
	public void validarCpf(String cpf) {
		boolean existe = cafeRepository.existsByCpf(cpf);
		if(existe) {
			throw new RegraException("Já existe este CPF Cadastrado.");
		}
	}
	
	public void verificarCafe(String cafe) {
		boolean existe = cafeRepository.existsByCafe(cafe);
		if(existe) {
			throw new RegraException("Já existe o café cadastrado.");
		}
	}

}
