package casadinha.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import casadinha.entitys.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
	
	Usuario findByLogin(String login);
	Usuario findByLoginAndEmail(String login, String email);
	Usuario findByLoginAndSenha(String login, String senha);
	Usuario findByEmail(String email);
}
