package com.vadinei.design.pattern.test.estrutural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;
import com.vadinei.design.pattern.estrutural.adapter.ControlePonto;
import com.vadinei.design.pattern.estrutural.adapter.ControlePontoAdapter;
import com.vadinei.design.pattern.estrutural.adapter.Funcionario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControlePontoAdapterTest {

	private static final String NOME_PADRAO = "Funcionário Padrão";
	private static final String NOME_EMPTY = "";

	@Test
	@Order(1)
	public void registrarPontoEntradaFuncionarioNull() {
		registrarPonto(null, Boolean.TRUE);
	}
	
	@Test
	@Order(2)
	public void registrarPontoEntradaFuncionarioNomeNull() {
		registrarPonto(new Funcionario(null), Boolean.TRUE);
	}
	
	@Test
	@Order(3)
	public void registrarPontoEntradaFuncionarioNomeEmpty() {
		registrarPonto(new Funcionario(NOME_EMPTY), Boolean.TRUE);
	}
	
	@Test
	@Order(4)
	public void registrarPontoEntradaPadrao() {
		registrarPonto(new Funcionario(NOME_PADRAO), Boolean.TRUE);
	}
	
	@Test
	@Order(5)
	public void registrarPontoSaidaFuncionarioNull() {
		registrarPonto(null, Boolean.FALSE);
	}
	
	@Test
	@Order(6)
	public void registrarPontoSaidaFuncionarioNomeNull() {
		registrarPonto(new Funcionario(null), Boolean.FALSE);
	}
	
	@Test
	@Order(7)
	public void registrarPontoSaidaFuncionarioNomeEmpty() {
		registrarPonto(new Funcionario(NOME_EMPTY), Boolean.FALSE);
	}
	
	@Test
	@Order(8)
	public void registrarPontoSaidaPadrao() {
		registrarPonto(new Funcionario(NOME_PADRAO), Boolean.FALSE);
	}
	
	private void registrarPonto(final Funcionario funcionario, final boolean entrada) {
		registrarPonto(funcionario, entrada, ReflectionUtil.getInstance().get(ControlePonto.class));
		registrarPonto(funcionario, entrada, ReflectionUtil.getInstance().get(ControlePontoAdapter.class));
	}

	private void registrarPonto(final Funcionario funcionario, final boolean entrada, final ControlePonto controlePonto) {
		assertNotNull(controlePonto);
		try {
			if (entrada) {
				controlePonto.registrarPontoEntrada(funcionario);
			} else {
				controlePonto.registrarPontoSaida(funcionario);
			}
		} catch (final IllegalArgumentException e) {
			assertEquals(ControlePontoAdapter.FUNCIONARIO_NAO_INFORMADO, e.getMessage());
		}
	}

}
