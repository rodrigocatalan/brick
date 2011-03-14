package br.com.ahrpius.brick.tools;

public class ClassTools {
	
	private final Class<?> clazz;
	
	public ClassTools(final Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public String getSimpleNameFirstInLower(){
		String name = clazz.getSimpleName();
		return name.substring(0,1).toLowerCase()+name.substring(1);
	}
	
}
