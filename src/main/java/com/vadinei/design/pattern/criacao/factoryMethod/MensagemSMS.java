package com.vadinei.design.pattern.criacao.factoryMethod;

public class MensagemSMS implements Mensagem {

	@Override
	public void enviar(final String mensagem) {
		System.out.println("Mensagem SMS: " + mensagem);
	}

}
