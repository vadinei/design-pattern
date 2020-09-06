package com.vadinei.design.pattern.criacao.abstractFactory;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

public final class EmissorCartaoCreator {
	
	private EmissorCartaoCreator() {
		super();
	}
	
	public static EmissorCartao create(final TipoBandeiraCartaoEnum tipoBandeiraCartaoEnum) {
		if (tipoBandeiraCartaoEnum == null) {		
			return null;
		}
		return (EmissorCartao) ReflectionUtil.getInstance().get(tipoBandeiraCartaoEnum.getEmissorCartaoClassType());		
	}

}
