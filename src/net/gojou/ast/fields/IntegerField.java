package net.gojou.ast.fields;

import java.io.Serializable;


public class IntegerField extends AbstractField implements Field , Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5080587792947436760L;

	public IntegerField(){
		super();
		this.fieldClass = Integer.class;

	}

	public IntegerField(String name, String label, String type, Boolean required) {
		super(name, label, type, required);
		this.fieldClass = Integer.class;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setValue(Object value){

		if (value instanceof Integer){
			this.value = value;
		} 
		else if (value instanceof String){
			try {
				this.value = Integer.parseInt(entry);
			}
			catch (NumberFormatException ex1){
				this.value = null;
			}
		}
		else {
			this.value = null;
		}
			
		
	}

	@Override
	public String getFieldType() {
		/**
		 * 
		 */
		return "text";
	}
	
/*
	@Override
	public Boolean isValid() {
		


		boolean b = (this.value instanceof Integer ? true : false);
		this.validationNote = ( b ? "Valid!" : "Please enter an integer value.");
		return b;
	}
	
*/

}
