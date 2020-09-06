package com.vadinei.design.pattern.criacao.abstractFactory;

@FunctionalInterface
public interface EmissorCartao {
	
	void enviar(final String mensagem);

}
