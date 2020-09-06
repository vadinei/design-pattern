package com.vadinei.design.pattern.estrutural.adapter;

public class ControlePontoNovo {
	
	public void registrarPonto(final Funcionario funcionario, final boolean isEntrada) {
		ControlePonto.validarInstanciaFuncionario(funcionario);
		final String evento = isEntrada ? ControlePonto.ENTRADA : ControlePonto.SAIDA;
		ControlePonto.registrarEvento(funcionario, evento);
	}
	
}
