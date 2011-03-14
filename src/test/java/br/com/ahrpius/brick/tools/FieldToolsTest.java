package br.com.ahrpius.brick.tools;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldToolsTest {
	
	private class Peopple {
		@SuppressWarnings("unused")
		private String name;
	}
	
	@Test
	public void testOwnerClassInSimpleName(){
		
		final String expected = "peopple";
		
		Field[] declaredFields = Peopple.class.getDeclaredFields();
				
		FieldTools fieldTool = new FieldTools(declaredFields[0]);
		
		String result = fieldTool.getDeclaringClassinSimpleName();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testClassDotAttributeName(){
		
		final String expected = "peopple.name";
		
		Field[] declaredFields = Peopple.class.getDeclaredFields();
		
		FieldTools fieldTool = new FieldTools(declaredFields[0]);
		
		String result = fieldTool.getClassDotName();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testInJspNamed(){
		
		final String expected = "${peopple.name}";
		
		Field[] declaredFields = Peopple.class.getDeclaredFields();
		
		FieldTools fieldTool = new FieldTools(declaredFields[0]);
		
		String result = fieldTool.getInJspNamed();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testSameType(){
		
		Field[] declaredFields = Peopple.class.getDeclaredFields();
		
		FieldTools fieldTool = new FieldTools(declaredFields[0]);
		
		Boolean result = fieldTool.isType(String.class);

		assertTrue(result);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyConstructor(){
		new FieldTools(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyParameterInIsType(){
		
		Field[] declaredFields = Peopple.class.getDeclaredFields();
		
		FieldTools fieldTool = new FieldTools(declaredFields[0]);
		
		fieldTool.isType(null);
		
	}

}
