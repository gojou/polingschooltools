package net.gojou.ast.forms;

import java.util.Set;

import net.gojou.ast.fields.Field;

public interface Form {
	
	 
	
	public Set<Field> getFields();
	public void setFields(Set<Field> fieldList);
	 
	public void setField(Field field);
	public Field getField(String fieldName);
	
	public Boolean isComplete();
	 
	
	

}
