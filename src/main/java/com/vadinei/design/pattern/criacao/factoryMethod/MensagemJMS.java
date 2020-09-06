package com.vadinei.design.pattern.criacao.factoryMethod;

public class MensagemJMS implements Mensagem {

	@Override
	public void enviar(final String mensagem) {
		System.out.println("Mensagem JMS: " + mensagem);
	}

}
