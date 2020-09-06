package com.vadinei.design.pattern.estrutural.bridge;

public abstract class Arquivo {

	public static final String DOCUMENTO_NAO_INFORMADO = "Documento não informado";
	
	public Arquivo criar(final Documento documento) {
		if (documento == null) {
			throw new IllegalArgumentException(DOCUMENTO_NAO_INFORMADO);
		}
		System.out.println("Documento de Origem do Arquivo: " + documento.getClass());
		System.out.println("Tipo de Arquivo Gerado ao Documento: " + this.getClass());
		return this;
	}
	
}
