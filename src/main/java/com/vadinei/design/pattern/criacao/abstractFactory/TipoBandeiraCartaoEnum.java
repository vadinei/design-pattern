package com.vadinei.design.pattern.criacao.abstractFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoBandeiraCartaoEnum {
	
	MASTER(MasterComunicadorFactory.class, EmissorCartaoMaster.class, ReceptorCartaoMaster.class), 
	VISA(VisaComunicadorFactory.class, EmissorCartaoVisa.class, ReceptorCartaoVisa.class);
	
	private final Class<?> comunicadorCartaoClassType;
	
	private final Class<?> emissorCartaoClassType;
	
	private final Class<?> receptorCartaoClassType;

}
