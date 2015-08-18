package net.gojou.ast.forms;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import net.gojou.ast.fields.Field;
// import net.gojou.ast.util.C;

public abstract class AbstractForm implements Form, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Set<Field> fields = null;

	public AbstractForm() {
		fields = new LinkedHashSet<Field>();
	}

	@Override
	public final Set<Field> getFields() {
		// TODO Auto-generated method stub
		return fields;
	}

	@Override
	public final void setFields(Set<Field> fields) {
		this.fields = fields;

	}

	@Override
	public final void setField(Field field) {
		fields.add(field);

	}

	@Override
	public final Field getField(String fieldName) {

	
		Field returnField = null;
		for (Field field : this.fields) {
			if (fieldName.equals(field.getName())) {
				returnField = field;
				break;
			}

		}

		return returnField;
	}
	
	@Override
	public final Boolean isComplete(){

		Boolean b = true;

		
		for(Field field: this.fields){
			boolean isFieldValid = field.isValid();
			
			field.setValidationNote(isFieldValid ? null : "Please enter a valid value");
			b = (b && isFieldValid ? b : false);
		}
		return b;
		
	}


}
