package jdev.mentoria.lojavirtual.model;



import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")

/*
Ao usar @PrimaryKeyJoinColumn(name = "id"), você está dizendo ao JPA que a coluna "id" 
da tabela de origem (aquela onde está definida a entidade que tem o relacionamento mapeado) será usada como chave 
estrangeira na tabela de destino (tabela da outra entidade no relacionamento).
 Essa chave estrangeira também estará referenciando a chave primária da tabela de destino.

*/

//anotação para apontar o id da tabela Pessoa pegar como herança classe Pessoa Abstrata e Pessoa Fisica é concreta
//@PrimaryKeyJoinColumn(name = "id") não pode usar com @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//extender da classe abstrata Pessoa para PessoaFisica ou seja pegar atributos como herança
public class PessoaFisica extends Pessoa {

	/*
	  Serialização: Transforma um objeto em uma sequência de bytes para armazenamento ou transmissão.
		Desserialização: Transforma uma sequência de bytes de volta em um objeto, restaurando seu estado original.
	 */
	//Definir esse campo é fundamental para manter a compatibilidade e evitar erros quando você precisa serializar e deserializar objetos
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)//false, a coluna não pode conter valores nulos. Ou seja, é obrigatório ter um valor não nulo para essa coluna.
	private String cpf;
	
	
	/*
	 é uma anotação usada para especificar que um atributo do tipo java.util.Date ou java.util.Calendar 
	 deve ser mapeado para uma coluna de banco de dados que armazena apenas a data,
	*/
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	
	
}
