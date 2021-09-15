package ufpb.dsc.lab1.controladores;

import java.util.Collection;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.lab1.sevicos.DisciplinasService;
import ufpb.dsc.lab1.dtos.DisciplinasDtos;
import ufpb.dsc.lab1.dtos.ItemDeAtualizacaoDeDisciplina;
import ufpb.dsc.lab1.entidades.Disciplinas;


@RestController
public class DisciplinasController {
	
	@Autowired
	private DisciplinasService disciplinasService;
	
	/* 
	 *  Adiciona uma disciplina no sistema e 
	 * retorna a disciplina que foi adicionada 
	 * (incluindo o id)  
	 */
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplinas> addDisciplina(@RequestBody DisciplinasDtos disciplina){
		return new ResponseEntity<Disciplinas>(disciplinasService.addListaDisciplina(disciplina), HttpStatus.CREATED); 
	}
	
	
	
	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<Collection<Disciplinas>> recuperaTodasAsDisciplinas(@RequestParam(value="busca", required=false) String padrao){
		return new ResponseEntity<Collection<Disciplinas>>(disciplinasService.recuperaDisciplinas(Optional.ofNullable(padrao)), HttpStatus.OK);
	}
	
	/*não está lançando exceção*/
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplinas> recuperaDisciplina(@PathVariable long id){
		return new ResponseEntity<Disciplinas>(disciplinasService.recuperaDisciplina(id), HttpStatus.OK);
	}
	
	/*Atualiza o nome da disciplina de identificador id no sistema*/
	@PatchMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplinas> atualizaDisciplina(@PathVariable long id, @RequestBody ItemDeAtualizacaoDeDisciplina itemDeAtualizacao){
		return new ResponseEntity<Disciplinas>(disciplinasService.atualizaDisciplina(id, itemDeAtualizacao), HttpStatus.OK);
	}
	
	
}
