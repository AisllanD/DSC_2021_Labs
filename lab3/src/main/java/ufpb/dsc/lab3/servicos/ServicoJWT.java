package ufpb.dsc.lab3.servicos;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import ufpb.dsc.lab3.entidades.Usuario;
import ufpb.dsc.lab3.filtro.TokenFilter;

@Service
public class ServicoJWT {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	public static final String TOKEN_KEY = "kjkjkjlkjlkjljlkjlj";
	
	public RespostaDeLogin autentica(Usuario usuario) {
		if(!servicoUsuario.validaUsuarioSenha(usuario)) {
			return new RespostaDeLogin("Usuario ou senha invalidos. Nao foi realizado o login.");
		}
		
		String token = geraToken(usuario.getEmail());
		return new RespostaDeLogin(token);
	}
	
	private String geraToken(String email) {
		return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(email)
				.signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 3 * 60 * 1000)).compact();// 3 min
	}
	
	public String getSujeitoDoToken(String authorizationHeader) {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new SecurityException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = authorizationHeader.substring(TokenFilter.TOKEN_INDEX);

		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new SecurityException("Token invalido ou expirado!");
		}
		return subject;
	}

}
