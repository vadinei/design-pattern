package com.vadinei.design.pattern.criacao.buider;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public interface BoletoBuilder {
	
	public static final String MENSAGEM_CODIGO_BARRAS = "Geração do Código de Barras";
	
	void buildSacado(final String sacado);
	
	void buildCedente(final String cedente);
	
	void buildValor(final BigDecimal valor);
	
	void buildVencimento(final Calendar vencimento);
	
	void buildNossoNumero(final BigInteger nossoNumero);
	
	void buildLogotipo(final byte[] logotipo);
	
	void buildCodigoBarras();
	
	AbstractBoleto getBoleto();

}
