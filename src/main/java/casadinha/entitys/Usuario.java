package casadinha.entitys;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario_sistema")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	
	private String login;	
	private String senha;
	private String email;
	
	@ManyToMany
	@JoinTable(
			  name = "usuario_endereco", 
			  joinColumns = {@JoinColumn(name = "id_usuario")}, 
			  inverseJoinColumns = @JoinColumn(name = "id_endereco"))
	private List<Endereco> endereco;
		
	public Usuario()
	{
		setLogin(new String());
		setSenha(new String());
		setEmail(new String());
		SetEndereco(new LinkedList<Endereco>());
	}
	
	
	public Usuario(String login, String senha, String email, List<Endereco> endereco)
	{
		setLogin(login);
		setSenha(senha);
		setEmail(email);
		SetEndereco(endereco);
	}
	
	public List<Endereco> getEndereco()
	{
		return endereco;
	}

	public void SetEndereco(List<Endereco> endereco)
	{
		this.endereco = endereco;
	}
	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}
	

}
