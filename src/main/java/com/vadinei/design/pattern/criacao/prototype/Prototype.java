package com.vadinei.design.pattern.criacao.prototype;

@FunctionalInterface
public interface Prototype<T> {
	
	Prototype<T> clone();

}
