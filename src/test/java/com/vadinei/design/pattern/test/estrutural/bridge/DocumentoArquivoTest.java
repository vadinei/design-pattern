package com.vadinei.design.pattern.test.estrutural.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;
import com.vadinei.design.pattern.estrutural.bridge.Arquivo;
import com.vadinei.design.pattern.estrutural.bridge.Documento;
import com.vadinei.design.pattern.estrutural.bridge.Recibo;
import com.vadinei.design.pattern.estrutural.bridge.Relatorio;
import com.vadinei.design.pattern.estrutural.bridge.TipoArquivoEnum;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocumentoArquivoTest {

	@Test
	@Order(1)
	public void criarReciboTipoArquivoNull() {
		criarDocumento(Recibo.class, null);
	}
	
	@Test
	@Order(2)
	public void criarReciboTipoArquivoPDF() {
		criarDocumento(Recibo.class, TipoArquivoEnum.PDF);
	}
	
	@Test
	@Order(3)
	public void criarReciboTipoArquivoTXT() {
		criarDocumento(Recibo.class, TipoArquivoEnum.TXT);
	}
	
	@Test
	@Order(4)
	public void criarRelatorioTipoArquivoNull() {
		criarDocumento(Relatorio.class, null);
	}
	
	@Test
	@Order(5)
	public void criarRelatorioTipoArquivoPDF() {
		criarDocumento(Relatorio.class, TipoArquivoEnum.PDF);
	}
	
	@Test
	@Order(6)
	public void criarRelatorioTipoArquivoTXT() {
		criarDocumento(Relatorio.class, TipoArquivoEnum.TXT);
	}
	
	@Test
	@Order(7)
	public void criarArquivoPDFDocumentoNull() {
		criarArquivo(TipoArquivoEnum.PDF.getArquivoClassType(), null);
	}
	
	@Test
	@Order(8)
	public void criarArquivoPDFRecibo() {
		criarArquivo(TipoArquivoEnum.PDF.getArquivoClassType(), getDocumento(Recibo.class));
	}
	
	@Test
	@Order(9)
	public void criarArquivoPDFRelatorio() {
		criarArquivo(TipoArquivoEnum.PDF.getArquivoClassType(), getDocumento(Relatorio.class));
	}
	
	@Test
	@Order(10)
	public void criarArquivoTXTDocumentoNull() {
		criarArquivo(TipoArquivoEnum.TXT.getArquivoClassType(), null);
	}
	
	@Test
	@Order(11)
	public void criarArquivoTXTRecibo() {
		criarArquivo(TipoArquivoEnum.TXT.getArquivoClassType(), getDocumento(Recibo.class));
	}
	
	@Test
	@Order(12)
	public void criarArquivoTXTRelatorio() {
		criarArquivo(TipoArquivoEnum.TXT.getArquivoClassType(), getDocumento(Relatorio.class));
	}
	
	private void criarDocumento(final Class<? extends Documento> documentoClassType, final TipoArquivoEnum tipoArquivoEnum) {
		assertNotNull(documentoClassType);
		try {
			final Documento documento = getDocumento(documentoClassType);
			assertNotNull(documento);
			assertArquivoCriado(documento.criarArquivo(tipoArquivoEnum));
		} catch (IllegalArgumentException e) {
			assertEquals(Documento.TIPO_ARQUIVO_NAO_INFORMADO, e.getMessage());
		}
	}

	private Documento getDocumento(final Class<? extends Documento> documentoClassType) {
		return ReflectionUtil.getInstance().get(documentoClassType);
	}
		
	private void criarArquivo(final Class<? extends Arquivo> arquivoClassType, final Documento documento) {
		assertNotNull(arquivoClassType);
		try {
			final Arquivo arquivo = ReflectionUtil.getInstance().get(arquivoClassType);
			assertNotNull(arquivo);
			assertArquivoCriado(arquivo.criar(documento));
		} catch (IllegalArgumentException e) {
			assertEquals(Arquivo.DOCUMENTO_NAO_INFORMADO, e.getMessage());
		}
	}
	
	private void assertArquivoCriado(final Arquivo arquivo) {
		assertNotNull(arquivo);
	}

}
