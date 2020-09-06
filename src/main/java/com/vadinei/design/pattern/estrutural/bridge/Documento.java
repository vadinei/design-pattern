package com.vadinei.design.pattern.estrutural.bridge;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

public interface Documento {
	
	public static final String TIPO_ARQUIVO_NAO_INFORMADO = "Tipo de arquivo não informado";
	
	default Arquivo criarArquivo(final TipoArquivoEnum tipoArquivoEnum) {
		if (tipoArquivoEnum == null) {
			throw new IllegalArgumentException(TIPO_ARQUIVO_NAO_INFORMADO);
		}
		final Arquivo arquivo = (Arquivo) ReflectionUtil.getInstance().get(tipoArquivoEnum.getArquivoClassType());
		arquivo.criar(this);
		return arquivo;
	}

}
