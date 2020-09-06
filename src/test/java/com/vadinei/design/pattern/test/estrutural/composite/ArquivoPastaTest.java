package com.vadinei.design.pattern.test.estrutural.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.estrutural.composite.ArquivoPDF;
import com.vadinei.design.pattern.estrutural.composite.ArquivoTXT;
import com.vadinei.design.pattern.estrutural.composite.Pasta;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArquivoPastaTest {

	private Pasta pastaPrincipal;
	
	@BeforeEach
	public void setup() {
		pastaPrincipal = new Pasta("Pasta Principal");
		pastaPrincipal.adicionar(new ArquivoPDF("PDF1"));
		pastaPrincipal.adicionar(new ArquivoPDF("PDF2"));
		pastaPrincipal.adicionar(new ArquivoPDF("PDF1"));
		pastaPrincipal.adicionar(new ArquivoPDF("PDF2"));
		pastaPrincipal.adicionar(new ArquivoTXT("TXT1"));
		pastaPrincipal.adicionar(new ArquivoTXT("TXT2"));
		pastaPrincipal.adicionar(new ArquivoTXT("TXT1"));
		pastaPrincipal.adicionar(new ArquivoTXT("TXT2"));
	}
	
	@Test
	@Order(2)
	public void listarArquivoPDF() {
		pastaPrincipal.listar(null);
		pastaPrincipal.listar(pastaPrincipal);
	}

}
