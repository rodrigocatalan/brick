package br.com.ahrpius.brick.interfaces;

import java.lang.reflect.Field;

public interface ForField {
	
	public String make(final Field field);
	
	public Boolean match(final Field field);

}