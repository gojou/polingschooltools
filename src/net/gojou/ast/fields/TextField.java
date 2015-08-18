package net.gojou.ast.fields;

import java.io.Serializable;


public class TextField extends AbstractField implements Field, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8190543874533929315L;

	public TextField(){
		super();
		this.fieldClass = String.class;

	}
	
	public TextField(String name, String label, String type, Boolean required) {
		super(name, label, type, required);
		this.fieldClass = String.class;
	}

	
	@Override
	public String getFieldType() {
		// TODO Auto-generated method stub
		return "text";
	}


	@Override
	public void setValue(Object fieldValue) {
		// TODO Auto-generated method stub
		if (fieldValue.getClass() == this.fieldClass){
			this.value = fieldValue;
		}
		else {
			this.value = fieldValue.toString();
		}
	}


	
}
