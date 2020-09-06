package com.vadinei.design.pattern.test.criacao.singleton;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.Serializable;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vadinei.design.pattern.criacao.singleton.ReflectionUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReflectionUtilTest {
	
	@Test
	@Order(1)
	public void getInstanceNull() {
		assertNull(ReflectionUtil.getInstance().get(null));
	}
	
	@Test
	@Order(2)
	public void getInstanceSerializable() {
		assertNull(ReflectionUtil.getInstance().get(Serializable.class));
	}
	
	@Test
	@Order(3)
	public void getInstanceObject() {
		assertNotNull(ReflectionUtil.getInstance().get(Object.class));
	}

}
