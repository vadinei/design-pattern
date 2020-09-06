package com.vadinei.design.pattern.estrutural.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControlePonto {
	
	public static final String SAIDA = "Saída";
	public static final String ENTRADA = "Entrada";
	public static final String FUNCIONARIO_NAO_INFORMADO = "Funcionário não informado";

	public void registrarPontoEntrada(final Funcionario funcionario) {
		validarInstanciaFuncionario(funcionario);
		registrarEvento(funcionario, ENTRADA);
	}
	
	public void registrarPontoSaida(final Funcionario funcionario) {
		validarInstanciaFuncionario(funcionario);
		registrarEvento(funcionario, SAIDA);
	}
	
	public static void validarInstanciaFuncionario(final Funcionario funcionario) {
		if (funcionario == null || funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
			throw new IllegalArgumentException(FUNCIONARIO_NAO_INFORMADO);
		}
	}
	
	public static void registrarEvento(final Funcionario funcionario, final String evento) {
		final Calendar calendar = Calendar.getInstance();
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(funcionario.getNome() + ": " + evento + " às " + simpleDateFormat.format(calendar.getTime()));
	}

}
