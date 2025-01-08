package jdev.mentoria.lojavirtual.model;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "acesso")

@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1 )
//GrantedAuthority  spring security uma autorização
public class Acesso implements GrantedAuthority {

	
	/*
	 * 
	 * Serialização: Transforma um objeto em uma sequência de bytes para armazenamento ou transmissão.

		Desserialização: Transforma uma sequência de bytes de volta em um objeto, restaurando seu estado original.
	 */
	//Definir esse campo é fundamental para manter a compatibilidade e evitar erros quando você precisa serializar e deserializar objetos
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
	private Long id;
	
	@Column(nullable = false)//false, a coluna não pode conter valores nulos. Ou seja, é obrigatório ter um valor não nulo para essa coluna.
	private String descricao; /*Acesso ex: ROLE_ADMIN ou ROLE_SECRETARIO -> O atributo descricao armazena uma descrição do papel, como "ADMIN" ou "USER".*/ 
	
	@Override
	public String getAuthority() { //O método getAuthority() retorna essa descrição, que é utilizada pelo Spring Security para verificar as permissões de um usuário.
		return this.descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Acesso other = (Acesso) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
