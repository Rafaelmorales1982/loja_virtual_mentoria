package jdev.mentoria.lojavirtual.enums;

/*
 Em Java, um enum (abreviação de enumeration) é um tipo especial de classe que representa um conjunto de constantes (valores fixos). 
 Ele é usado quando você precisa de um conjunto de valores predefinidos e não quer que outros valores sejam atribuídos a uma variável dessa classe.
  Os enums ajudam a melhorar a legibilidade e a segurança do código.
 
 */
public enum TipoEndereco {
	//Enum serve para criar constantes valores fixos
	COBRANCA("Cobrança"),
	ENTREGA("Entrega");
	
	private String descricao;

	//construtor
	private TipoEndereco(String descricao) {
	 this.descricao = descricao;
		
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
	
	

}
