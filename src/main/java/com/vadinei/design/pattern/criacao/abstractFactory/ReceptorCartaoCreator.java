package com.vadinei.design.pattern.criacao.abstractFactory;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

public final class ReceptorCartaoCreator {
	
	private ReceptorCartaoCreator() {
		super();
	}
	
	public static ReceptorCartao create(final TipoBandeiraCartaoEnum tipoBandeiraCartaoEnum) {
		if (tipoBandeiraCartaoEnum == null) {		
			return null;
		}
		return (ReceptorCartao) ReflectionUtil.getInstance().get(tipoBandeiraCartaoEnum.getReceptorCartaoClassType());		
	}

}
