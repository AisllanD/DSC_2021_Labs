package ufpb.dsc.lab1.sevicos;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import ufpb.dsc.lab1.dtos.ItemDeAtualizacaoDeDisciplina;
import ufpb.dsc.lab1.entidades.Disciplinas;
import ufpb.dsc.lab1.excecoes.DisciplinaNaoEncontradaException;
import ufpb.dsc.lab1.excecoes.NomeDeDisciplinaInvalidoException;

public class DadosDiciplina {
	
	private Map<Long, Disciplinas> disciplinasPorId = new HashMap<>();
	private Map<String, Disciplinas> disciplinasPorNome = new HashMap<>();
	
	public Optional<Disciplinas> recuperaPorNome(String nome){
		return Optional.ofNullable(disciplinasPorNome.get(nome));
	}
	
	public Optional<Disciplinas> recuperaPorId(Long id){
		return Optional.ofNullable(disciplinasPorId.get(id));
	}

	public Disciplinas adicionaDisciplinas(Disciplinas disciplina) {
		disciplinasPorId.put(disciplina.getId(),disciplina);
		return disciplina;
	}	
	
	public Collection<Disciplinas> getDisciplinas(Optional<String> padraoDeBusca){
		if (padraoDeBusca.isEmpty())
			return disciplinasPorId.values();
		
		Set<String> nomes = disciplinasPorNome.keySet();
		
		Collection<Disciplinas> disciplinas = new ArrayList<>();
		for (String nome : nomes) {
			if (nome.contains(padraoDeBusca.get())) {
				disciplinas.add(disciplinasPorNome.get(nome));
			}
		}
		return disciplinas;
	}
	
	public Disciplinas getDisciplina(long id) {
		if(!disciplinasPorId.containsKey(id))
				throw new DisciplinaNaoEncontradaException("Disciplina não encontrada. ","Não há disciplinas com este ID ");
		
		return disciplinasPorId.get(id);
	}
	
	public Disciplinas atualizaItemDaDisciplina(long id, ItemDeAtualizacaoDeDisciplina itemDeAtualizacao) {
		Disciplinas disciplina = recuperaPorId(id).get();
		switch (itemDeAtualizacao.getAtributo()) {
		case "nome":
			if(disciplinaComEsteNomeJaExiste(itemDeAtualizacao.getNovoValor()))
					throw new NomeDeDisciplinaInvalidoException("Nome para disciplina inválido.", 
																"Uma disciplina já está cadastra com este nome.");
			disciplina.setNome(itemDeAtualizacao.getNovoValor());
			break;
		
		case "notas":
			double [] novaNota = null;
			disciplina.setNotas(novaNota);
			break;
		}
		
		return disciplina;
	}
	
	public boolean disciplinaComEsteNomeJaExiste(String nome) {
		return recuperaPorNome(nome).isPresent();
	}
	
	
	
}
