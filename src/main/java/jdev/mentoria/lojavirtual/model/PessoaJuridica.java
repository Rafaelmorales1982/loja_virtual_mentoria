
package jdev.mentoria.lojavirtual.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")

/*
 Ao usar @PrimaryKeyJoinColumn(name = "id"), você está dizendo ao JPA que a coluna "id" 
 da tabela de origem (aquela onde está definida a entidade que tem o relacionamento mapeado) será usada como chave 
 estrangeira na tabela de destino (tabela da outra entidade no relacionamento).
  Essa chave estrangeira também estará referenciando a chave primária da tabela de destino.
 
 */

//anotação para apontar o id da tabela Pessoa pegar como herança classe Pessoa Abstrata e Pessoa Fisica é concreta
//@PrimaryKeyJoinColumn(name = "id")

//extender da classe abstrata Pessoa para PessoaFisica ou seja pegar atributos como herança
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String inscEstadual;
	private String inscMunicipal;
	private String nomeFantasia;
	private String razaoSocial;
	private String categoria;
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getInscMunicipal() {
		return inscMunicipal;
	}
	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	

}
