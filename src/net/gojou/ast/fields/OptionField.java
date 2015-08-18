package net.gojou.ast.fields;

import java.io.Serializable;



// import net.gojou.ast.util.C;
import net.gojou.ast.util.Operations;

public class OptionField extends AbstractField implements Field, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String FIELDTYPE ="select";


	public OptionField() {
		// TODO Auto-generated constructor stub
		super();
		this.fieldClass=Operations.class;
	}

	public OptionField(String name, String label, String type, Boolean required) {
		super(name, label, type, required);
		// TODO Auto-generated constructor stub
	}

	
	
/*	
	@Override
	public String getHtml() {
		
		String name = this.getName();
		Map<String,String> map = this.getValidInputMap();
		String html = "";
		String selectedItem = (this.getValueString()==null ? 
				(this.getDefaultInput() == null ? "" :this.getDefaultInput())
					: this.getValueString());

		
		html = html + "<label for " + name +">";
		html = html + this.getLabel() + ":&nbsp;</label>";
		html = html + "<select name =\"" + name + "\" >";
		for (String key: map.keySet()){
			html = html + "\t<option value=" +"\"" + map.get(key) +"\"";
			if (selectedItem.equals(map.get(key))){
				html = html + " selected";
			}
			html = html + ">";
			html = html + key +"</option>\n";
			
		}
		html = html + "</select>\n";
		return html;
	}
	
*/	
	@Override
	public String getHtml() {
		
		String name = this.getName();
		String html = "";
		String selectedItem = (this.getValueString()==null ? 
				(this.getDefaultInput() == null ? "" :this.getDefaultInput())
					: this.getValueString());

		
		html = html + "<label for " + name +">";
		html = html + this.getLabel() + ":&nbsp;</label>";
		html = html + "<select name =\"" + name + "\" >";
		for (Operations operation : Operations.values()){
			html = html + "\t<option value=" +"\"" + operation.name() +"\"";
			if (selectedItem.equals(operation.name())){
				html = html + " selected";
			}
			html = html + ">";
			html = html + operation.getOptionString() +"</option>\n";
			
		}
		html = html + "</select>\n";
		return html;
	}

	@Override
	public String getFieldType() {
		// TODO Auto-generated method stub
		return FIELDTYPE;
	}


	
	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		boolean b;
		b= Operations.contains(getValueString());
		this.validationNote = (b ? "Valid!" : "Something optional went terribly wrong.");
		return b;
	
	}
	
	@Override
	public void setValue(Object value){
		
		this.value = (value instanceof Operations ? value : this.getOperation(value));
		
		this.entry = (String) this.value.toString();
		
	}
	

	private Operations getOperation(Object value){
		
		
//		C.c(this.getClass().getSimpleName() + ":"+value.toString());
		Operations operation;
		
		operation = Operations.valueOf((String) value);
		
		return operation;
		
	}

}
