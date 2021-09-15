package ufpb.dsc.lab1.sevicos;

import java.util.Collection;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ufpb.dsc.lab1.dtos.DisciplinasDtos;
import ufpb.dsc.lab1.entidades.Disciplinas;
import ufpb.dsc.lab1.excecoes.DisciplinaNaoEncontradaException;
import ufpb.dsc.lab1.dtos.ItemDeAtualizacaoDeDisciplina;

@Service
public class DisciplinasService {
	
	DadosDiciplina dadosdisc = new DadosDiciplina();
	

	public DisciplinasService () {
		super();
	}
	
	
	public Disciplinas addListaDisciplina(DisciplinasDtos disciplina) {
		return dadosdisc.adicionaDisciplinas(Disciplinas.criaDisciplina(disciplina));
	}
	
	public Collection<Disciplinas> recuperaDisciplinas(Optional<String> padraoDeBusca){
		return dadosdisc.getDisciplinas(padraoDeBusca);
	}
	
	public Disciplinas recuperaDisciplina(long id) {
		return dadosdisc.getDisciplina(id);
	}
	
	public Disciplinas atualizaDisciplina(long id, ItemDeAtualizacaoDeDisciplina itemDeAtualizacao){
		if(dadosdisc.recuperaPorId(id).isEmpty())
			throw new DisciplinaNaoEncontradaException("Disciplina não encontrada. ","Não há disciplinas com este ID ");
		
		return dadosdisc.atualizaItemDaDisciplina(id, itemDeAtualizacao);
	}
	
}
	
	


