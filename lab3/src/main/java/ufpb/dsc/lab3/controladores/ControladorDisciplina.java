package ufpb.dsc.lab3.controladores;

import java.util.Collection;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.lab3.servicos.ServicoDisciplina;
import ufpb.dsc.lab3.dtos.AtualizaComentarioDisciplina;
import ufpb.dsc.lab3.dtos.AtualizaNotaDisciplina;
import ufpb.dsc.lab3.dtos.DisciplinaDTO;
import ufpb.dsc.lab3.entidades.Disciplina;
import ufpb.dsc.lab3.excecoes.NaoHaDisciplinasNoSistemaException;

@RestController
public class ControladorDisciplina {

	@Autowired
	private ServicoDisciplina servicoDisciplina;
	
	public ControladorDisciplina(ServicoDisciplina servicoDisciplina) {
		super();
		this.servicoDisciplina = servicoDisciplina;
	}

	@PostMapping("v1/api/disciplinas")
	public ResponseEntity<Disciplina> cadastraDisciplina(@RequestBody Disciplina disciplina){
		return new ResponseEntity<Disciplina>(servicoDisciplina.addDiciplina(disciplina), HttpStatus.OK);
	}
	
	@GetMapping("v1/api/disciplinas")
	public ResponseEntity<Collection<Disciplina>> recuperaTodasDisciplinas(){
		return new ResponseEntity<Collection<Disciplina>>(servicoDisciplina.getDisciplinas(),HttpStatus.OK);
	}
	
	@GetMapping("v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> recuperaDisciplinaPorId(@PathVariable long id){
		return new ResponseEntity<Disciplina>(servicoDisciplina.getDisciplinaPorID(id), HttpStatus.OK);
	}
	
	@PutMapping("v1/api/disciplinas/likes/{id}")
	public ResponseEntity<Disciplina> adicionaLike(@PathVariable long id){
		return new ResponseEntity<Disciplina>(servicoDisciplina.addLike(id), HttpStatus.OK);
	}
	
	@PutMapping("v1/api/disciplinas/nota/{id}")
	public ResponseEntity<Disciplina> adicionaNota(@PathVariable long id, @RequestBody AtualizaNotaDisciplina atualizaNota){
		return new ResponseEntity<Disciplina>(servicoDisciplina.addNota(id, atualizaNota), HttpStatus.OK);
	}

	@PutMapping("v1/api/disciplinas/comentarios/{id}")
	public ResponseEntity<Disciplina> adicionaComentario(@PathVariable long id, @RequestBody AtualizaComentarioDisciplina atualizaComentario){
		return new ResponseEntity<Disciplina>(servicoDisciplina.addComentario(id, atualizaComentario), HttpStatus.OK);
	}
	
	@GetMapping("vi/api/ranking/likes")
	public ResponseEntity<List<Disciplina>> agrupaDisciplinasDescrecentePorLike(){
		return new ResponseEntity<List<Disciplina>> (servicoDisciplina.ordenarPorLikesDesc(), HttpStatus.OK);
	}
	
	@GetMapping("vi/api/ranking/notas")
	public ResponseEntity<List<Disciplina>> agrupaDisciplinasDescrecentePorNota(){
		return new ResponseEntity<List<Disciplina>> (servicoDisciplina.ordenarPorNotasDesc(), HttpStatus.OK);
	}
	
}

