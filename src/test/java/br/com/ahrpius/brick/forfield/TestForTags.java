package br.com.ahrpius.brick.forfield;

import org.junit.Test;
import static org.junit.Assert.*;

import br.com.ahrpius.brick.Brick;

public class TestForTags {
	
	private class Peopple{
		private String name;
		private Integer age;
		private Boolean something;
	}
	
	@Test
	public void simpleInputText(){
		
		final String expected = 
			"<input type=\"text\" name=\"peopple.name\"></input>" +
			"<input type=\"text\" name=\"peopple.age\"></input>";
		
		Brick brick = new Brick(Peopple.class);
		brick.putTag(SimpleInputText.class, String.class, Integer.class);
		brick.load();
		
		String actual = brick.generate();
		System.out.println(actual);
		assertEquals(expected, actual);
	}

}
