package com.vadinei.design.pattern.criacao.buider;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public class ItauBoletoBuilder implements BoletoBuilder {	

	private String sacado;
	
	private String cedente;
	
	private BigDecimal valor;
	
	private Calendar vencimento;
	
	private BigInteger nossoNumero;
	
	private byte[] logotipo;
	
	@Override
	public void buildSacado(final String sacado) {
		this.sacado = sacado;
	}

	@Override
	public void buildCedente(final String cedente) {
		this.cedente = cedente;
	}

	@Override
	public void buildValor(final BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public void buildVencimento(final Calendar vencimento) {
		this.vencimento = vencimento;
	}

	@Override
	public void buildNossoNumero(final BigInteger nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	
	@Override
	public void buildLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}

	@Override
	public void buildCodigoBarras() {
		System.out.println(BoletoBuilder.MENSAGEM_CODIGO_BARRAS + ": " + this.getClass().getSimpleName());
	}

	@Override
	public AbstractBoleto getBoleto() {
		return new ItauBoleto(sacado, cedente, valor, vencimento, nossoNumero, logotipo);
	}

}
