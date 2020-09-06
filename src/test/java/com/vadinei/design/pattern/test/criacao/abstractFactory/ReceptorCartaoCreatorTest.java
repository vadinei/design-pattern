package com.vadinei.design.pattern.test.criacao.abstractFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.abstractFactory.ReceptorCartao;
import com.vadinei.design.pattern.criacao.abstractFactory.ReceptorCartaoCreator;
import com.vadinei.design.pattern.criacao.abstractFactory.ReceptorCartaoMaster;
import com.vadinei.design.pattern.criacao.abstractFactory.ReceptorCartaoVisa;
import com.vadinei.design.pattern.criacao.abstractFactory.TipoBandeiraCartaoEnum;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReceptorCartaoCreatorTest {

	public static final String MENSAGEM_TESTE = "Mensagem de Teste do Receptor";
	
	@Test
	@Order(1)
	public void createReceptorCartaoNull() {
		assertNull(ReceptorCartaoCreator.create(null));
	}
	
	@Test
	@Order(2)
	public void createReceptorCartaoMaster() {
		createReceptorCartao(TipoBandeiraCartaoEnum.MASTER, ReceptorCartaoMaster.class);
	}
	
	@Test
	@Order(3)
	public void createReceptorCartaoVisa() {
		createReceptorCartao(TipoBandeiraCartaoEnum.VISA, ReceptorCartaoVisa.class);
	}

	private <T> void createReceptorCartao(final TipoBandeiraCartaoEnum tipoBandeiraCartaoEnum, final Class<T> receptorClassType) {
		final ReceptorCartao receptorCartao = ReceptorCartaoCreator.create(tipoBandeiraCartaoEnum);
		assertNotNull(receptorCartao);
		receptorCartao.receber(MENSAGEM_TESTE);
		assertEquals(tipoBandeiraCartaoEnum.getReceptorCartaoClassType(), receptorCartao.getClass());
		assertThat(receptorCartao).isInstanceOf(receptorClassType);
	}

}
