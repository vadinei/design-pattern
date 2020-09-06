package com.vadinei.design.pattern.test.criacao.prototype;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.HashSet;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.prototype.Campanha;
import com.vadinei.design.pattern.criacao.prototype.Prototype;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CampanhaPrototypeTest {

	@Test
	@Order(1)
	public void createPrototypeCampanhaNullProperty() {
		createProtorypeCampanha(new Campanha(null, null, null));
	}
	
	@Test
	@Order(2)
	public void createPrototypeCampanhaBase() {
		createProtorypeCampanha(new Campanha("Teste", Calendar.getInstance(), new HashSet<String>()));
	}
	
	private void createProtorypeCampanha(final Campanha campanha) {
		final Prototype<Campanha> prototype = createPrototype(campanha);
		final Campanha campanhaPrototype = (Campanha) prototype;
		assertPrototypeCampanha(campanha, campanhaPrototype);
	}

	private void assertPrototypeCampanha(final Campanha campanha, final Campanha campanhaPrototype) {
		assertNotNull(campanha);
		assertNotNull(campanhaPrototype);
		assertNotEquals(campanha.getNome(), campanhaPrototype.getNome());
		assertEquals(campanha.getVencimento(), campanhaPrototype.getVencimento());
		assertEquals(campanha.getPalavraChave(), campanhaPrototype.getPalavraChave());
	}
	
	private <T> Prototype<T> createPrototype(final Prototype<T> source) {
		assertNotNull(source);
		final Prototype<T> prototype = (Prototype<T>) source.clone();
		assertNotNull(prototype);
		assertThat(prototype).isInstanceOf(source.getClass());
		return prototype;
	}

}
