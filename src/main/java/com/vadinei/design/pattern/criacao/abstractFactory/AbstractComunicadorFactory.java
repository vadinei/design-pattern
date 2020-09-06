package com.vadinei.design.pattern.criacao.abstractFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AbstractComunicadorFactory {
	
	private final TipoBandeiraCartaoEnum tipoBandeiraCartaoEnum;
	
	public EmissorCartao createEmissorCartao() {
		return EmissorCartaoCreator.create(tipoBandeiraCartaoEnum);
	}
	
	public ReceptorCartao createReceptorCartao(){
		return ReceptorCartaoCreator.create(tipoBandeiraCartaoEnum);
	}

}
