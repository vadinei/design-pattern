package com.vadinei.design.pattern.criacao.abstractFactory;

public class MasterComunicadorFactory extends AbstractComunicadorFactory {

	public MasterComunicadorFactory() {
		super(TipoBandeiraCartaoEnum.MASTER);
	}

}
