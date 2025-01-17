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

@Entity
@Table(name = "categoria_produto")
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)//allocationSize pula de 1 em 1, initialValue inicia com 1 
public class CategoriaProduto implements Serializable {

	/*
	 * 
	 * Serialização: Transforma um objeto em uma sequência de bytes para armazenamento ou transmissão.

		Desserialização: Transforma uma sequência de bytes de volta em um objeto, restaurando seu estado original.
	 */
	//Definir esse campo é fundamental para manter a compatibilidade e evitar erros quando você precisa serializar e deserializar objetos
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto" )
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
		CategoriaProduto other = (CategoriaProduto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
