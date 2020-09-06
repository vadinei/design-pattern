package com.vadinei.design.pattern.criacao.abstractFactory;

@FunctionalInterface
public interface ReceptorCartao {
	
	void receber(final String mensagem);

}
