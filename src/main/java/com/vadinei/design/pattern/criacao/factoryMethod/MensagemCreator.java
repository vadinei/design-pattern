package com.vadinei.design.pattern.criacao.factoryMethod;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

public final class MensagemCreator {

	private MensagemCreator() {
		super();
	}
	
	public static Mensagem create(final TipoMensagemEnum tipoMensagemEnum) {
		if (tipoMensagemEnum == null) {		
			return null;
		}
		return (Mensagem) ReflectionUtil.getInstance().get(tipoMensagemEnum.getMensagemClassType());		
	}

}
