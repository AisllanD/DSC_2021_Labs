package ufpb.dsc.lab3.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufpb.dsc.lab3.entidades.Disciplina;

@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {
	public boolean existsByNome(String nome);
	
	public List<Disciplina> findByOrderByLikesDesc();
	public List<Disciplina> findByOrderByNotasDesc();
	
}
