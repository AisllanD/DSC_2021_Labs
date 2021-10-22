package ufpb.dsc.lab3.controladores;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.lab3.entidades.Usuario;
import ufpb.dsc.lab3.servicos.ServicoUsuario;

@RestController
public class ControladorUsuario {
	
	@Autowired
	private ServicoUsuario servicoUser;
	
	public ControladorUsuario(ServicoUsuario servicoUsuario) {
		super();
		this.servicoUser = servicoUser;
	}
	
	@PostMapping("/v1/api/usuarios")
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(this.servicoUser.addUsuario(usuario), HttpStatus.OK);
	}
	
	@GetMapping("/auth/api/usuarios/{email}")
	public ResponseEntity<Usuario> buscaUsuario(@PathVariable String email) {
		try {
			return new ResponseEntity<Usuario>(servicoUser.getUsuario(email), HttpStatus.OK);
		} catch(IllegalArgumentException iae) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);	
		}
	}

	@DeleteMapping("/auth/api/usuarios/{email}")
	public ResponseEntity<Usuario> removeUsuario(@PathVariable String email,
			@RequestHeader("Authorization") String header) {
		try {
			return new ResponseEntity<Usuario>(servicoUser.removeUsuario(email, header), HttpStatus.OK);
		} catch (IllegalArgumentException iae) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		} catch (ServletException e) {
			return new ResponseEntity<Usuario>(HttpStatus.FORBIDDEN);
		}
	}
	
}
