package com.vadinei.design.pattern.test.criacao.abstractFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.abstractFactory.EmissorCartao;
import com.vadinei.design.pattern.criacao.abstractFactory.EmissorCartaoCreator;
import com.vadinei.design.pattern.criacao.abstractFactory.EmissorCartaoMaster;
import com.vadinei.design.pattern.criacao.abstractFactory.EmissorCartaoVisa;
import com.vadinei.design.pattern.criacao.abstractFactory.TipoBandeiraCartaoEnum;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmissorCartaoCreatorTest {

	public static final String MENSAGEM_TESTE = "Mensagem de Teste do Emissor";
	
	@Test
	@Order(1)
	public void createEmissorCartaoNull() {
		assertNull(EmissorCartaoCreator.create(null));
	}
	
	@Test
	@Order(2)
	public void createEmissorCartaoMaster() {
		createEmissorCartao(TipoBandeiraCartaoEnum.MASTER, EmissorCartaoMaster.class);
	}
	
	@Test
	@Order(3)
	public void createEmissorCartaoVisa() {
		createEmissorCartao(TipoBandeiraCartaoEnum.VISA, EmissorCartaoVisa.class);
	}

	private <T> void createEmissorCartao(final TipoBandeiraCartaoEnum tipoBandeiraCartaoEnum, final Class<T> emissorClassType) {
		final EmissorCartao emissorCartao = EmissorCartaoCreator.create(tipoBandeiraCartaoEnum);
		assertNotNull(emissorCartao);
		emissorCartao.enviar(MENSAGEM_TESTE);
		assertEquals(tipoBandeiraCartaoEnum.getEmissorCartaoClassType(), emissorCartao.getClass());
		assertThat(emissorCartao).isInstanceOf(emissorClassType);
	}

}
