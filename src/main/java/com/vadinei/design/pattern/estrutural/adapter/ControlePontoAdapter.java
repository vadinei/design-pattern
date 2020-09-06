package com.vadinei.design.pattern.estrutural.adapter;

public class ControlePontoAdapter extends ControlePonto {
	
	private final ControlePontoNovo controlePontoNovo;
	
	public ControlePontoAdapter() {
		controlePontoNovo = new ControlePontoNovo();
	}

	@Override
	public void registrarPontoEntrada(Funcionario funcionario) {
		controlePontoNovo.registrarPonto(funcionario, Boolean.TRUE);
	}
	
	@Override
	public void registrarPontoSaida(Funcionario funcionario) {
		controlePontoNovo.registrarPonto(funcionario, Boolean.FALSE);
	}

}
