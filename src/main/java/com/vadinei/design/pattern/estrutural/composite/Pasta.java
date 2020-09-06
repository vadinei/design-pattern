package com.vadinei.design.pattern.estrutural.composite;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Pasta extends Arquivo {

	public static final String NENHUM_ARQUIVO_ENCONTRADO = "Nenhum arquivo encontrado";
	
	private final Set<Arquivo> arquivos;
	
	public Pasta(final String nome) {
		super(nome);
		this.arquivos = new HashSet<>();
	}

	public void adicionar(final Arquivo arquivo) {
		getArquivos().add(arquivo);
	}
	
	public void listar(final Pasta pasta) {
		final Pasta origem = (pasta == null) ? this : pasta;
		origem.getArquivos().forEach(a -> System.out.println(a.getNome()));
	}

}
