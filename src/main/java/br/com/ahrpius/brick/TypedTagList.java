package br.com.ahrpius.brick;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ahrpius.brick.interfaces.ForField;

public class TypedTagList {
	
	private Map<Class<?>, List<ForField>> map = new HashMap<Class<?>, List<ForField>>();
	
	public void put(Class<?> clazz, ForField forType){
		
		if ( !this.map.containsKey(clazz) ) {
			this.map.put(clazz, new ArrayList<ForField>());
		}
		
		List<ForField> list = this.map.get(clazz);
		
		if ( list == null ) {
			list = new ArrayList<ForField>();
		}
		
		list.add(forType);
		
	}
	
	public List<ForField> get(Class<?> clazz){
		return this.map.get(clazz);
	}
	
	public ForField get(Field field){
		List<ForField> list = map.get(field.getType());
		if ( list == null || list.size() == 0 ) {
			return null;
		} else {
			for (ForField toTag : list) {
				if ( toTag.match(field) ) {
					return toTag;
				}
			}
			return null;
		}
	}
	
}
