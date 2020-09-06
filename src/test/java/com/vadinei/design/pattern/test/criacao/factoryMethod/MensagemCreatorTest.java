package com.vadinei.design.pattern.test.criacao.factoryMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.factoryMethod.Mensagem;
import com.vadinei.design.pattern.criacao.factoryMethod.MensagemCreator;
import com.vadinei.design.pattern.criacao.factoryMethod.MensagemEmail;
import com.vadinei.design.pattern.criacao.factoryMethod.MensagemJMS;
import com.vadinei.design.pattern.criacao.factoryMethod.MensagemSMS;
import com.vadinei.design.pattern.criacao.factoryMethod.TipoMensagemEnum;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MensagemCreatorTest {

	private static final String MENSAGEM_TESTE = "Mensagem de Teste";

	@Test
	@Order(1)
	public void createMensagemNull() {
		assertNull(MensagemCreator.create(null));
	}
	
	@Test
	@Order(2)
	public void createMensagemEmail() {
		createMensagem(TipoMensagemEnum.EMAIL, MensagemEmail.class);
	}
	
	@Test
	@Order(3)
	public void createMensagemJMS() {
		createMensagem(TipoMensagemEnum.JMS, MensagemJMS.class);
	}

	@Test
	@Order(4)
	public void createMensagemSMS() {
		createMensagem(TipoMensagemEnum.SMS, MensagemSMS.class);
	}

	private <T> void createMensagem(final TipoMensagemEnum tipoMensagemEnum, final Class<T> mensagemClasseType) {
		final Mensagem mensagem = MensagemCreator.create(tipoMensagemEnum);
		assertNotNull(mensagem);
		mensagem.enviar(MENSAGEM_TESTE);
		assertEquals(tipoMensagemEnum.getMensagemClassType(), mensagem.getClass());
		assertThat(mensagem).isInstanceOf(mensagemClasseType);
	}
	
}
