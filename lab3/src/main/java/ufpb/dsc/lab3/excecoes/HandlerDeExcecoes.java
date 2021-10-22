package ufpb.dsc.lab3.excecoes;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ufpb.dsc.lab3.dtos.DetalhesDoProblema;

@RestControllerAdvice
public class HandlerDeExcecoes {
	
	private static String ADICIONA_DISCIPLINA_URI = "https://servidor:8080/v1/api/disciplinas";
	
	@ExceptionHandler(NaoHaDisciplinasNoSistemaException.class)
	public ResponseEntity<DetalhesDoProblema> LidaComNaoHaDisciplinasNoSistemaException(NaoHaDisciplinasNoSistemaException ndse){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.BAD_REQUEST.value());
		problema.setTitle(ndse.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(ndse.getDetalhe());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
	}
	
	@ExceptionHandler(DisciplinaNaoEncontradaException.class)
	public ResponseEntity<DetalhesDoProblema> LidaComDisciplinaNaoEncontradaException(DisciplinaNaoEncontradaException dnee){
		DetalhesDoProblema problema = new DetalhesDoProblema();
		problema.setStatus(HttpStatus.NOT_FOUND.value());
		problema.setTitle(dnee.getTitulo());
		problema.setType(ADICIONA_DISCIPLINA_URI);
		problema.setDetail(dnee.getDetalhe());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
	}
	
}
