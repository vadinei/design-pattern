package com.vadinei.design.pattern.criacao.abstractFactory;

public class ReceptorCartaoMaster implements ReceptorCartao {

	@Override
	public void receber(String mensagem) {
		System.out.println("Receptor de Cartão Master: " + mensagem);
	}

}
