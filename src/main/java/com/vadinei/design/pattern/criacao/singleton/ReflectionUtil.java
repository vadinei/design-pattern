package com.vadinei.design.pattern.criacao.singleton;

public final class ReflectionUtil {

	private static ReflectionUtil instance;
	
	private ReflectionUtil() {
		super();
	}
	
	public static ReflectionUtil getInstance() {
		if (ReflectionUtil.instance == null) {
			ReflectionUtil.instance = new ReflectionUtil();
		}
		return ReflectionUtil.instance;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized <T> T get(final Class<T> instanceClassType) {		
		T retorno = null;
		if (instanceClassType != null) {
			try {
				retorno = (T) Class.forName(instanceClassType.getName()).newInstance();
			} catch (final Exception e) {
				System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
			}
		}
		return retorno;
	}

}
