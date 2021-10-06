package ufpb.dsc.lab2.servicos;

import java.io.IOException;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ufpb.dsc.lab2.repositorios.DisciplinaDAO;
import ufpb.dsc.lab2.dtos.DisciplinaDTO;
import ufpb.dsc.lab2.entidades.Disciplina;
import ufpb.dsc.lab2.excecoes.DisciplinaNaoEncontradaException;
import ufpb.dsc.lab2.excecoes.NaoHaDisciplinasNoSistemaException;
import ufpb.dsc.lab2.dtos.AtualizaComentarioDisciplina;
import ufpb.dsc.lab2.dtos.AtualizaNotaDisciplina;

@Service
public class ServicoDisciplina {
	
	@Autowired
	private DisciplinaDAO repositorioDisciplina;

	public ServicoDisciplina (DisciplinaDAO repositorioDisciplina) {
		super();
		this.repositorioDisciplina = repositorioDisciplina;
	}
	/*
	public void initAlunos() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {};
		InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");	
		try {
			List<Disciplina> disciplina = mapper.readValue(inputStream, typeReference);
			this.repositorioDisciplina.saveAll(disciplina);
			System.out.println("Disciplina salva");
			
		}catch (IOException e) {
			System.out.println("Não foi possível salvar a disciplina: " + e.getMessage());
		}
	}
	*/
	
	public Disciplina addDiciplina(Disciplina disciplina) {
		return repositorioDisciplina.save(disciplina);
	}
	
	public Collection<Disciplina> getDisciplinas(){
		if(repositorioDisciplina.findAll().isEmpty())
				throw new NaoHaDisciplinasNoSistemaException("Vazio", "Não ha disciplinas cadastradas no sistema.");
		return repositorioDisciplina.findAll();
	}
	
	public Disciplina getDisciplinaPorID(long id) {
		if (!repositorioDisciplina.existsById(id))
				throw new DisciplinaNaoEncontradaException("Disciplina inexistente","A disciplina com o 'id' fornecido não está cadastrada no sistema.");
		return repositorioDisciplina.findById(id).get();
	}
	
	public Disciplina addLike(long id) {
		if(!repositorioDisciplina.existsById(id))
				throw new DisciplinaNaoEncontradaException("Disciplina inexistente","A disciplina com o 'id' fornecido não está cadastrada no sistema.");
		Disciplina disciplina = getDisciplinaPorID(id);
		disciplina.setLikes();
		return repositorioDisciplina.save(disciplina);
	}
	
	public Disciplina addNota(long id, AtualizaNotaDisciplina atualizaNota) {
		if(!repositorioDisciplina.existsById(id))
				throw new DisciplinaNaoEncontradaException("Disciplina inexistente","A disciplina com o 'id' fornecido não está cadastrada no sistema.");
		Disciplina disciplina = getDisciplinaPorID(id);
		double nota = atualizaNota.getNovaNota();
		double novaNota;
		if(disciplina.getNotas() == 0) {
			disciplina.setNotas(nota);
		} else {
			novaNota = (disciplina.getNotas() + atualizaNota.getNovaNota())/2;
			disciplina.setNotas(novaNota);
		}
		
		return repositorioDisciplina.save(disciplina);
	}
	
	public Disciplina addComentario(long id, AtualizaComentarioDisciplina atualizaComentario) {
		if(!repositorioDisciplina.existsById(id))
				throw new DisciplinaNaoEncontradaException("Disciplina inexistente","A disciplina com o 'id' fornecido não está cadastrada no sistema.");
		Disciplina disciplina = getDisciplinaPorID(id);
		ArrayList<String> comentarios = atualizaComentario.getComentario(); 
		disciplina.setComentarios(comentarios);
		
		return repositorioDisciplina.save(disciplina);
		 
	}
	
	public List<Disciplina> ordenarPorLikesDesc() {
		if(repositorioDisciplina.findAll().isEmpty())
			throw new NaoHaDisciplinasNoSistemaException("Vazio", "Não ha disciplinas cadastradas no sistema.");
		return repositorioDisciplina.findByOrderByLikesDesc();
	}

	public List<Disciplina> ordenarPorNotasDesc() {
		if(repositorioDisciplina.findAll().isEmpty())
			throw new NaoHaDisciplinasNoSistemaException("Vazio", "Não ha disciplinas cadastradas no sistema.");
		return repositorioDisciplina.findByOrderByNotasDesc();
	}
}
	
	
	

