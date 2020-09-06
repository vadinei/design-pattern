package com.vadinei.design.pattern.test.criacao.buider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.buider.AbstractBoleto;
import com.vadinei.design.pattern.criacao.buider.BoletoBuilder;
import com.vadinei.design.pattern.criacao.buider.BoletoGenerator;
import com.vadinei.design.pattern.criacao.buider.BradescoBoletoBuilder;
import com.vadinei.design.pattern.criacao.buider.ItauBoletoBuilder;
import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoletoGeneratorTest {

	@Test
	@Order(1)
	public void generateBoletoBradesco() {
		generateBoleto(BradescoBoletoBuilder.class);
	}
	
	@Test
	@Order(2)
	public void generateBoletoItau() {
		generateBoleto(ItauBoletoBuilder.class);
	}
	
	private <T> void generateBoleto(final Class<T> boletoBuilderClassType) {
		BoletoBuilder boletoBuilder = (BoletoBuilder) ReflectionUtil.getInstance().get(boletoBuilderClassType);
		assertNotNull(boletoBuilder);
		BoletoGenerator boletoGenerator = new BoletoGenerator(boletoBuilder);
		assertNotNull(boletoGenerator);
		assertBoleto(boletoGenerator.generate());
	}

	private void assertBoleto(AbstractBoleto boleto) {
		assertNotNull(boleto);
		assertNotNull(boleto.getSacado());
		assertNotNull(boleto.getCedente());
		assertNotNull(boleto.getValor());
		assertNotNull(boleto.getVencimento());
		assertNotNull(boleto.getNossoNumero());
		assertNotNull(boleto.getLogotipo());
	}

}
