package br.com.ahrpius.brick.tools;

import java.lang.reflect.Field;

public class FieldTools {
	
	final String ELJSP = "${%s}";
	
	private final Field field;
	
	public FieldTools(final Field field) {
		
		if (field==null)
			throw new IllegalArgumentException("Constructor for FieldTools must be receive a field");
		
		this.field = field;
	}
	
	public Boolean isType(final Class<?> clazz) {
		
		if (clazz==null)
			throw new IllegalArgumentException("Method isType of FieldTools must be receive a class");
		
		return this.field.getType().equals(clazz);
	}

	public Field getField() {
		return field;
	}
	
	public String getDeclaringClassinSimpleName(){
		final ClassTools classTool = new ClassTools(field.getDeclaringClass());
		return classTool.getSimpleNameFirstInLower();
	}
	
	public String getClassDotName() {
		return getDeclaringClassinSimpleName() + '.' + field.getName();
	}
	
	public String getInJspNamed() {		
		return String.format(ELJSP, getClassDotName());
	}

}
