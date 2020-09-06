package com.vadinei.design.pattern.criacao.factoryMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMensagemEnum {
	
	EMAIL(MensagemEmail.class), JMS(MensagemJMS.class), SMS(MensagemSMS.class);
	
	private final Class<?> mensagemClassType;

}
