package com.vadinei.design.pattern.criacao.factoryMethod;

public class MensagemEmail implements Mensagem {

	@Override
	public void enviar(final String mensagem) {
		System.out.println("Mensagem E-mail: " + mensagem);
	}

}
