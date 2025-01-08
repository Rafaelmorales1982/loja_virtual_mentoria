package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)

public class Endereco implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	private Long id;
	
	private String ruaLogra;
	private String cep;
	private String numero;
	private String complemento;
	private String bairro;
	private String uf;
	private String cidade;
	
	//pessoa pode ter muitos endereços     (Pessoa 1 e Endereco * )
	/*
	A anotação @ManyToOne(targetEntity = Pessoa.class) é usada para mapear um relacionamento de muitos para um no JPA.
 	Isso indica que várias entidades podem estar associadas a uma única instância da classe Pessoa.
	 */
	@ManyToOne(targetEntity = Pessoa.class)
	/*
	 Parâmetros da Anotação
		name: Define o nome da coluna no banco de dados que será usada como chave estrangeira.
		nullable: Indica se a coluna aceita valores nulos.
		foreignKey: Configura a chave estrangeira:
		@ForeignKey: Especifica a criação da chave estrangeira.
		value = ConstraintMode.CONSTRAINT: Garante que o banco de dados aplique a restrição.
		name: Define o nome da restrição no banco de dados.
	*/
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk" ))
	private Pessoa pessoa;//associar com a classe pessoa  que tem uma chave estrangeira na tabela Endereco(tabela)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuaLogra() {
		return ruaLogra;
	}

	public void setRuaLogra(String ruaLogra) {
		this.ruaLogra = ruaLogra;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
