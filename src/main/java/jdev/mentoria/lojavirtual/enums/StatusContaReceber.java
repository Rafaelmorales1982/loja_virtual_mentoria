package jdev.mentoria.lojavirtual.enums;

public enum StatusContaReceber {
	
	COBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada");
	
	private String descricao;
	
	//construtor
	private StatusContaReceber(String descricao) {
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
