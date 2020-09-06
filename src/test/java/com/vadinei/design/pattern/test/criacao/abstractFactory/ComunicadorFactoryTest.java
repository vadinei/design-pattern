package com.vadinei.design.pattern.test.criacao.abstractFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.abstractFactory.AbstractComunicadorFactory;
import com.vadinei.design.pattern.criacao.abstractFactory.EmissorCartao;
import com.vadinei.design.pattern.criacao.abstractFactory.ReceptorCartao;
import com.vadinei.design.pattern.criacao.abstractFactory.TipoBandeiraCartaoEnum;
import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComunicadorFactoryTest {

	@Test
	@Order(1)
	public void createEmissorCartaoMaster() {
		createComunicadorFactory(TipoBandeiraCartaoEnum.MASTER);
	}
	
	@Test
	@Order(2)
	public void createEmissorCartaoVisa() {
		createComunicadorFactory(TipoBandeiraCartaoEnum.VISA);
	}

	private <T> void createComunicadorFactory(final TipoBandeiraCartaoEnum tipoBandeiraCartaoEnum) {
		final AbstractComunicadorFactory abstractComunicadorFactory = (AbstractComunicadorFactory) ReflectionUtil.getInstance().get(tipoBandeiraCartaoEnum.getComunicadorCartaoClassType());
		assertNotNull(abstractComunicadorFactory);
		assertEquals(abstractComunicadorFactory.getTipoBandeiraCartaoEnum(), tipoBandeiraCartaoEnum);
		assertThat(abstractComunicadorFactory).isInstanceOf(tipoBandeiraCartaoEnum.getComunicadorCartaoClassType());
		createEmissorCartao(abstractComunicadorFactory);
		createReceptorCartao(abstractComunicadorFactory);
	}

	private void createEmissorCartao(final AbstractComunicadorFactory abstractComunicadorFactory) {
		final EmissorCartao emissorCartao = abstractComunicadorFactory.createEmissorCartao();
		assertNotNull(emissorCartao);
		emissorCartao.enviar(EmissorCartaoCreatorTest.MENSAGEM_TESTE);
	}

	private void createReceptorCartao(final AbstractComunicadorFactory abstractComunicadorFactory) {
		final ReceptorCartao receptorCartao = abstractComunicadorFactory.createReceptorCartao();
		assertNotNull(receptorCartao);
		receptorCartao.receber(ReceptorCartaoCreatorTest.MENSAGEM_TESTE);
	}

}
