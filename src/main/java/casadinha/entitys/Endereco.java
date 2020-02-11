package casadinha.entitys;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
	private int id_endereco;	
	private String rua;
	private String cep;
	private String numero;
	
	@ManyToMany(mappedBy = "endereco")	
	private List<Usuario> usuarios;
	
	public Endereco()
	{
		setRua(new String());
		setCep(new String());
		setNumero(new String());
		
	}
	
	public List<Usuario> getUsuarios()
	{
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios)
	{
		this.usuarios= usuarios;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
