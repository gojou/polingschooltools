package net.gojou.ast.fields;

import java.io.Serializable;

public class DoubleField extends AbstractField implements Field, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2873371590759823987L;
	

	public DoubleField() {
		this.fieldClass = Double.class;

	}
	
	public DoubleField(String name, String label, String type, Boolean required) {
		super(name, label, type, required);
		// TODO Auto-generated constructor stub
	}



/*
	@Override
	public String getHtml() {

		String html = "";
		
		html = html + "<label for " + this.name +" >";
		html = html + this.getLabel() +"</label> ";
		html = html + "<input type=" +  "\"text\" ";
		html = html + "name=\""+ this.name + "\" ";
		html = html + "value=\""+this.valueString + "\" ";
		html = html + (this.isRequired() ? "required" : "") +">";

		return html;
	}
*/	
	@Override
	public String getFieldType() {
		/**
		 * 
		 */
		return "text";
	}
	
	@Override
	public void setValue(Object value){
		
		Double d = null;
		
		if (value instanceof Double) {
			d = (Double) value;
		}
		
		else if (value instanceof String){
			d = Double.parseDouble((String) value);
		}
		
		this.value = d;
		
	}



	

}
