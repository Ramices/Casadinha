package casadinha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import casadinha.entitys.Usuario;
import casadinha.repositorys.UsuarioRepository;
import casadinha.services.UsuarioService;

@RestController
@RequestMapping(path="/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController{

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/get/{login}")
	public @ResponseBody ResponseEntity<Usuario> GetEnderecoUsuario(@PathVariable("login")String login)
	{
		Usuario usuario = usuarioService.findByLogin(login);
		
		if(usuario == null)
		{
			return new ResponseEntity<>(usuario, HttpStatus.BAD_REQUEST); 
		}
		
		return new ResponseEntity<>(usuario, HttpStatus.OK); 
		
	}
	
	@DeleteMapping(value="/delete")
	public @ResponseBody ResponseEntity<String> DeleteUsuario(@RequestBody Usuario usuario)
	{
		Usuario usuarioProcurado = usuarioService.findByLoginAndEmail(usuario.getLogin(), usuario.getEmail());
		
		if(usuarioProcurado != null)
		{
			usuarioService.DeleteUsuario(usuarioProcurado);
			return new ResponseEntity<>("Removido com sucesso", HttpStatus.OK); 
		}
		return new ResponseEntity<>("Não existe um usuário para ser removido", HttpStatus.BAD_REQUEST); 
		
		
		
	}
	
	
	@PutMapping(value="/update")
	public @ResponseBody ResponseEntity<String> UpdateUsuario(@RequestBody Usuario usuario)
	{
		Usuario usuarioProcurado = usuarioService.findByLoginAndEmail(usuario.getLogin(), usuario.getEmail());
		
		if(usuarioProcurado != null)
		{
			usuarioProcurado.setEmail(usuario.getEmail());
			usuarioProcurado.setSenha(usuario.getSenha());
			usuarioProcurado.setLogin(usuario.getLogin());
			usuarioProcurado.SetEndereco(usuario.getEndereco());
			
			usuarioService.AddUsuario(usuarioProcurado);
			return new ResponseEntity<>("Atualizado com sucesso", HttpStatus.OK); 
		}
		return new ResponseEntity<>("Não existe um usuário para ser atualizado", HttpStatus.BAD_REQUEST); 
		
		
		
	}
	
	@PostMapping(value="/add")
	public @ResponseBody ResponseEntity<String> AddUsuario(@RequestBody Usuario usuario)
	{
		Usuario usuarioProcurado = usuarioService.findByLoginAndEmail(usuario.getLogin(), usuario.getEmail());
		
		if(usuarioProcurado != null)
		{
			return new ResponseEntity<>("Já existe um usuário cadastrado", HttpStatus.BAD_REQUEST); 
		}
		
		usuarioService.AddUsuario(usuario);
		return new ResponseEntity<>("Adicionado com sucesso", HttpStatus.OK); 
		
	}
	
	@GetMapping(value="/")
	public @ResponseBody ResponseEntity<String> teste()
	{
		return new ResponseEntity<>("Eae", HttpStatus.OK); 
	}
	
}
