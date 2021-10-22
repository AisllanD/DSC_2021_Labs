package ufpb.dsc.lab3.controladores;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.lab3.servicos.ServicoJWT;
import ufpb.dsc.lab3.entidades.Usuario;
import ufpb.dsc.lab3.servicos.RespostaDeLogin;

@RestController
@RequestMapping("/auth")
public class ControladorLogin {
	
	@Autowired
	private ServicoJWT servicoJWT;

	@PostMapping("/login")
	public ResponseEntity<RespostaDeLogin> autentica(@RequestBody Usuario usuario) throws ServletException {
		return new ResponseEntity<RespostaDeLogin>(servicoJWT.autentica(usuario), HttpStatus.OK);
	}

}
