package com.vadinei.design.pattern.criacao.buider;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AbstractBoleto {
	
	private final String sacado;
	
	private final String cedente;
	
	private final BigDecimal valor;
	
	private final Calendar vencimento;
	
	private final BigInteger nossoNumero;
	
	private final byte[] logotipo;
	
}
