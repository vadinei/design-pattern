package com.vadinei.design.pattern.criacao.abstractFactory;

public class ReceptorCartaoVisa implements ReceptorCartao {

	@Override
	public void receber(String mensagem) {
		System.out.println("Receptor de Cartão Visa: " + mensagem);
	}

}
