package ufpb.dsc.lab3.servicos;

import java.util.Optional;


import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.dsc.lab3.entidades.Usuario;
import ufpb.dsc.lab3.repositorios.UsuarioDAO;

@Service
public class ServicoUsuario {
	
	@Autowired
	private UsuarioDAO<Usuario, String> repositorioUsuario;
	
	@Autowired
	private ServicoJWT servicoJWT;
	
	
	public Usuario addUsuario(Usuario usuario) {
		return this.repositorioUsuario.save(usuario);
		
	}
	
	public Usuario getUsuario(String email) {
		Optional<Usuario> optUsuario = repositorioUsuario.findByEmail(email);
		if(optUsuario.isEmpty())
			throw new IllegalArgumentException();
		return optUsuario.get();
	}
	
	public Usuario removeUsuario(String email, String authHeader) throws ServletException {
		Usuario usuario = getUsuario(email);
		if (usuarioTemPermissao(authHeader, email)) {
			repositorioUsuario.delete(usuario);
			return usuario;
		}
		throw new ServletException("Usuario nao tem permissao");
	}
	
	
	private boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
		String subject = servicoJWT.getSujeitoDoToken(authorizationHeader);
		Optional<Usuario> optUsuario = repositorioUsuario.findByEmail(subject);
		return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
	}
	
	public boolean validaUsuarioSenha(Usuario usuario) {
		Optional<Usuario> optUsuario = repositorioUsuario.findByEmail(usuario.getEmail());
		if(optUsuario.isPresent() && optUsuario.get().getSenha().equals(usuario.getSenha())) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
