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
	
	//Função para mostrar a descrição em algum lugar do projeto
	public String getDescricao() {
		return this.descricao;
	}

	/*
	 A sobrescrita do método toString() é útil nos seguintes casos:

	Depuração (debugging): Ao imprimir objetos em logs ou depuradores, o método toString() fornece informações mais legíveis 
	e relevantes sobre o objeto.
	Exibição de dados: Em interfaces gráficas ou APIs, você pode retornar informações relevantes do objeto diretamente.
	Legibilidade: Facilita a identificação de objetos sem acessar diretamente seus atributos.

	 */
	
	@Override
	public String toString() {
		return this.descricao;
	}
	
	

}
