package jdev.mentoria.lojavirtual.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

//manipular e armazenar dados em bancos de dados de forma automática e estruturada
@Entity 
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "Seq_usuario", allocationSize = 1, initialValue = 1)

	/*
 		 UserDetails é uma interface da API do Spring Security que define os métodos necessários para:

		Recuperar informações do usuário:
		Nome de usuário.
		Senha.
		Autorizações (ou "roles").
		Verificar o status da conta:
		Se a conta está ativa, expirada, bloqueada, etc.
	 */
public class Usuario implements UserDetails{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	
	
	private String login;
	private String senha;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtualSenha;
	
	//----- Anotações para criar  a classe (Tabela) Usuario_Acesso  Unir as tabelas Usuari, acesso e Usuario_Acesso
	
	@OneToMany(fetch = FetchType.LAZY)
	//unir as tabelas e criando a tabela usuario_acesso
	@JoinTable(name = "usuarios_acesso", uniqueConstraints = @UniqueConstraint (columnNames = {"usuario_id", "acesso_id"},
	name = "unique_acesso_user"), joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario",
	unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
	inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", 
	table = "acesso", foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)) )
	
	
	//--------------------------------------------------------------
	
	
	
	//---- Criar Lista de acessos da classe acesso -------
	private List<Acesso> acessos;
	
	//--------------------------------------------------
	
	
	//Autoridades = São os acessos, ou seja ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.acessos;// Retorna as roles ou permissões
	}

	@Override
	public String getPassword() {
		
		return this.senha;// Retorna a senha
	}

	@Override
	public String getUsername() {
	
		return this.login;// Retorna o nome de usuário
	}

	
	@Override
    public boolean isAccountNonExpired() {
        return true; // Retorna true se a conta não estiver expirada
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Retorna true se a conta não estiver bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Retorna true se as credenciais não estiverem expiradas
    }

    @Override
    public boolean isEnabled() {
        return true; // Retorna true se a conta estiver habilitada
    }
}
