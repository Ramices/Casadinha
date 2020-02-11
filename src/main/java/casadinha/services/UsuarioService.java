package casadinha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casadinha.entitys.Usuario;
import casadinha.repositorys.UsuarioRepository;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository repositorioUsuario;

	public Usuario findByLogin(String login)
	{
		return repositorioUsuario.findByLogin(login);
	}
	
	public Usuario findByLoginAndEmail(String login, String email)
	{

		return repositorioUsuario.findByLoginAndEmail( login,  email);
	}

	
	public Usuario findByLoginAndSenha(String login, String senha)
	{
		return repositorioUsuario.findByLoginAndSenha(login, senha);
	}
	
	
	public void AddUsuario(Usuario usuario)
	{
		
		repositorioUsuario.save(usuario);
		
	}
	
	public void DeleteUsuario(Usuario usuario)
	{
		repositorioUsuario.delete(usuario);
	}
	
	
}
