package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//Pense nela como uma representação de algo que será armazenado no banco.
@Entity


//é uma anotação fornecida pela JPA que é usada para especificar detalhes sobre a tabela de banco de dados que será mapeada para uma entidade (classe Java).
@Table(name = "marca_produto")

// é uma anotação poderosa em JPA que permite utilizar sequências de banco de dados para gerar chaves primárias.
@SequenceGenerator (name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
public class MarcaProduto implements Serializable {

	
	/*
	 * 
	 * Serialização: Transforma um objeto em uma sequência de bytes para armazenamento ou transmissão.

		Desserialização: Transforma uma sequência de bytes de volta em um objeto, restaurando seu estado original.
	 */
	//Definir esse campo é fundamental para manter a compatibilidade e evitar erros quando você precisa serializar e deserializar objetos
	private static final long serialVersionUID = 1L;

	
	@Id
	
	
	//Ela permite que você defina a estratégia de geração de IDs que melhor se adapta às necessidades da sua aplicação e do seu banco de dados, sem precisar gerá-los manualmente.
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
	private Long id;
	
	@Column(nullable = false)//false, a coluna não pode conter valores nulos. Ou seja, é obrigatório ter um valor não nulo para essa coluna.
	private String nomeDesc;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	//Utilizar quando for comparar que são categorias diferentes
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcaProduto other = (MarcaProduto) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
