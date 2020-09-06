package com.vadinei.design.pattern.criacao.buider;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public class BradescoBoleto extends AbstractBoleto {

	public BradescoBoleto(final String sacado, final String cedente, final BigDecimal valor, 
		final Calendar vencimento, final BigInteger nossoNumero, final byte[] logotipo) {
		super(sacado, cedente, valor, vencimento, nossoNumero, logotipo);
	}

}
