package jdev.mentoria.lojavirtual.enums;

public enum StatusContaPagar {
	
	COBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada"),
	NEGOCIADA("Renegociada");
	
	private String descricao;
	
	//construtor
	private StatusContaPagar(String descricao) {
		this.descricao = descricao;
	}

	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		
		return this.descricao;//ou getDescricao
	}
	
	
	

}
