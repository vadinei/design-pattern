package com.vadinei.design.pattern.criacao.prototype;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Campanha implements Prototype<Campanha> {

	private final String nome;
	
	private final Calendar vencimento;
	
	private final Set<String> palavraChave;
	
	@Override
	public Campanha clone() {
		final String nome = "Clone da Campanha: " + this.nome;
		final Calendar vencimento = this.vencimento != null ? (Calendar) this.vencimento.clone() : null;
		final HashSet<String> palavraChave = this.palavraChave != null ? new HashSet<>(this.palavraChave) : null;
		return new Campanha(nome, vencimento, palavraChave);
	}
	
}
