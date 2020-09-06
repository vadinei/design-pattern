package com.vadinei.design.pattern.criacao.abstractFactory;

public class EmissorCartaoVisa implements EmissorCartao {

	@Override
	public void enviar(String mensagem) {
		System.out.println("Emissor de Cartão Visa: " + mensagem);
	}

}
