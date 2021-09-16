package ufpb.dsc.lab1.controladores;

import java.util.Collection;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.lab1.sevicos.DisciplinasService;
import ufpb.dsc.lab1.dtos.DisciplinasDtos;
import ufpb.dsc.lab1.dtos.atualizaNomeDisciplina;
import ufpb.dsc.lab1.dtos.atualizaNotaDisciplina;
import ufpb.dsc.lab1.entidades.Disciplinas;


@RestController
public class DisciplinasController {
	
	@Autowired
	private DisciplinasService disciplinasService;
	
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplinas> addDisciplina(@RequestBody DisciplinasDtos disciplina){
		return new ResponseEntity<Disciplinas>(disciplinasService.addListaDisciplina(disciplina), HttpStatus.CREATED); 
	}
	
	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<Collection<Disciplinas>> recuperaTodasAsDisciplinas(@RequestParam(value="busca", required=false) String padrao){
		return new ResponseEntity<Collection<Disciplinas>>(disciplinasService.recuperaDisciplinas(Optional.ofNullable(padrao)), HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplinas> recuperaDisciplina(@PathVariable long id){
		return new ResponseEntity<Disciplinas>(disciplinasService.recuperaDisciplina(id), HttpStatus.OK);
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplinas> atualizaNomeDisciplina(@PathVariable long id, @RequestBody atualizaNomeDisciplina atualizaNome){
		return new ResponseEntity<Disciplinas>(disciplinasService.atualizaNomeDisciplina(id, atualizaNome), HttpStatus.OK);
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplinas> atualizaNotaDisciplina(@PathVariable long id, @RequestBody atualizaNotaDisciplina atualizaNota){
		return new ResponseEntity<Disciplinas>(disciplinasService.atualizaNotaDisciplina(id, atualizaNota), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/vi/api/disciplinas/{id}")
	public ResponseEntity<Disciplinas> deletaDisciplinaPorId(@PathVariable long id){
		return new ResponseEntity<Disciplinas>(disciplinasService.deletaDisciplinaPorId(id), HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/disciplinas/ordenado")
	public ResponseEntity<Disciplinas> rescuperaDisciplinasOrdenado(){
		return new ResponseEntity<Disciplinas>(disciplinasService.recuperaOrdenado(), HttpStatus.OK);
	}
	

}
