package br.com.ahrpius.brick;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.ahrpius.brick.interfaces.ForField;
import br.com.ahrpius.brick.tools.ClassTools;

public class Brick {
	
	private Class<?> clazz;
	private List<Field> fields = new ArrayList<Field>();
	private ClassTools classTool;
	
	private TypedTagList typedTagList = new TypedTagList();
	
	public Brick(final Class<?> clazz){
		this.clazz = clazz;
		classTool = new ClassTools(this.clazz);
	}
	
	public Brick(){
		this(null);
	}
	
	public String generate(){
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for (Field field : fields) {
			ForField toTag = typedTagList.get(field);
			if ( toTag != null && toTag.match(field) ) {				
				stringBuffer.append(toTag.make(field));
			}
		}
		
		return stringBuffer.toString();
		
	}
	
	public void putTag(Class<?> toClass, Class<? extends ForField> clazzTag) {
		try {
			ForField toTag = clazzTag.newInstance();
			typedTagList.put(toClass, toTag);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void load(final Class<?> clazz){
		Class<?> c = clazz;
        while (c != null) {
            this.fields.addAll(Arrays.asList(c.getDeclaredFields()));
            for (Class<?> interfaces : c.getInterfaces()) {
                fields.addAll(Arrays.asList(interfaces.getFields()));
            }
            c = c.getSuperclass();
        }
	}
	
	public void load(){
		if ( this.clazz != null ) 
			this.load(this.clazz);
	}
	
	public void add(Field field){
		this.fields.add(field);
	}
	
	public String getClassNameFirstInLower(){
		return classTool.getSimpleNameFirstInLower(); 
	}
			
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(final Class<?> clazz) {
		this.clazz = clazz;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
}