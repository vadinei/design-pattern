package com.vadinei.design.pattern.estrutural.bridge;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoArquivoEnum {
	
	PDF(ArquivoPDF.class), TXT(ArquivoTXT.class);
	
	private final Class<? extends Arquivo> arquivoClassType;

}
