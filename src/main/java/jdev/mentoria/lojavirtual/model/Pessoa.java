package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//@Inheritance(strategy = InheritanceType.JOINED)    // usa com @PrimaryKeyJoinColumn(name = "id") nas classes que vão herdar
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)

//Essa classe é abstrata para poder ser herdada pelas as classes concretas PessoaFisica e PessoaJuridica
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    
    
    //------Estânciando lista de endereços-------------
    //A anotação @OneToMany é geralmente usada do lado "um" da relação e mapeia a associação para a classe "muitos".
    //pessoa esta sendo mapeado da associação de Endereco.java private Pessoa pessoa;   linha 54
    /*
     Explicação dos Parâmetros:
	mappedBy:

	O parâmetro mappedBy é usado para indicar o lado "muitos" da relação e aponta para o atributo da entidade "muitos" que mapeia o relacionamento 
	de volta para o lado "um".
	No exemplo, "pessoa" é o nome do atributo na classe Endereco que mantém a referência para a classe Pessoa. Ou seja, o relacionamento é 
	controlado pela classe Endereco e a coluna de chave estrangeira estará na tabela Endereco.
	orphanRemoval:

	O parâmetro orphanRemoval = true garante que, se um item (neste caso, um Endereco) for removido da lista de endereços de uma Pessoa, esse item 
	será removido automaticamente do banco de dados. Ou seja, se você disassociar um Endereco de uma Pessoa (remover da lista), o JPA irá 
	automaticamente deletar esse Endereco no banco de dados.
	Sem orphanRemoval = true, o Endereco seria apenas desassociado da Pessoa, mas não seria removido do banco.

	cascade: O parâmetro cascade = CascadeType.ALL indica que todas as operações de persistência realizadas na entidade "um" (neste caso, a Pessoa) 
	serão propagadas para as entidades "muitos" (neste caso, os Endereco associados).
	CascadeType.ALL inclui várias operações de persistência, como:
	Persistir (salvar)
	Remover (excluir)
	Atualizar (atualizar)
	Merge (mesclar)
	Ou seja, se você salvar ou remover uma Pessoa, as mesmas operações serão feitas em todos os Enderecos associados a ela.
	fetch:

	O parâmetro fetch = FetchType.LAZY controla o comportamento de carregamento das coleções associadas. Com LAZY, a lista de Endereco será 
	carregada sob demanda (somente quando você acessar o atributo enderecos), ou seja, os dados não são carregados automaticamente junto com a 
	entidade Pessoa, o que pode melhorar a performance em consultas que não necessitam dos dados dos Endereco.
	Se fosse FetchType.EAGER, a lista de Endereco seria carregada automaticamente quando você carregasse uma Pessoa, mesmo que você não precisasse 
	acessar os endereços, o que poderia gerar uma sobrecarga no desempenho se a lista de endereços fosse muito grande.
     * */
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<Endereco>();
    
    public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
    
    
    //-----------------------------------------------
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        Pessoa other = (Pessoa) obj;
        return Objects.equals(id, other.id);
    }

	
}
