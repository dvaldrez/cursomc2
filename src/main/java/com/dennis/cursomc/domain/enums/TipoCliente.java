package com.dennis.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private Integer id;
	private String descricao;

	private TipoCliente(Integer cod, String descricao) {
		this.id = cod;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getId())) {
				return x;
			}
		}

			throw new IllegalArgumentException("Tipo ID Invalido" + cod);
	}
}
