package com.vadinei.design.pattern.criacao.buider;

import java.math.BigDecimal;
import java.util.Calendar;

public class BoletoGenerator {
	
	private final BoletoBuilder boletoBuilder;

	public BoletoGenerator(BoletoBuilder boletoBuilder) {
		super();
		this.boletoBuilder = boletoBuilder;
	}
	
	public AbstractBoleto generate() {
		boletoBuilder.buildSacado("SACADO DE ORIGEM");
		boletoBuilder.buildCedente("CEDENTE DE ORIGEM");
		boletoBuilder.buildValor(new BigDecimal(Math.random()));
		boletoBuilder.buildVencimento(Calendar.getInstance());
		boletoBuilder.buildNossoNumero(new BigDecimal(Math.random()).toBigInteger());
		boletoBuilder.buildLogotipo(new byte[] {});
		boletoBuilder.buildCodigoBarras();
		return boletoBuilder.getBoleto();
	}

}
