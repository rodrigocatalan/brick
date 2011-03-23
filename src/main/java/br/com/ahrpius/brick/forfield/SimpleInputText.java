package br.com.ahrpius.brick.forfield;

import java.lang.reflect.Field;

import br.com.ahrpius.brick.interfaces.ForField;
import br.com.ahrpius.brick.tools.FieldTools;

public class SimpleInputText implements ForField {

	FieldTools fieldTool;
	
	@Override
	public String make(Field field) {
		final String mask = "<input type=\"text\" name=\"%s\"></input>";
		return String.format(mask, fieldTool.getClassDotName());
	}

	@Override
	public Boolean match(Field field) {
		fieldTool = new FieldTools(field);
		return fieldTool.isType(String.class) || fieldTool.isType(Integer.class);
	}

}
