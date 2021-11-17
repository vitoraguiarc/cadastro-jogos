package br.senai.sp.jandira.model;

public enum Console {
	
	PLAYSTATION2("PlayStation 2", "Sony"),
	NINTENDODS("Nitendo DS", "Nintendo"),
	PLAYSTATION4("PlayStation 4", "Sony"),
	NINTENDOSWITCH("Nitendo Switch", "Nintendo"),
	XBOX360("Xbox 360", "Microsoft"),
	XBOXONE("Xbox One", "Microsoft");
	
	private String descricao;
	
	private Console(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	private String empresa;
	
	private Console(String descricao, String empresa) {
		this.empresa = empresa;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	

}
