package net.gojou.ast.fields;

import java.io.Serializable;


public abstract class AbstractField implements DataField, Field , Serializable {
	
	private static final long serialVersionUID = 5380955017448934191L;
	
	protected static final String FIELDTYPE = "text";
	
	protected String name = null;
	protected String label = null;
	protected String entry = null;
	protected String type = null;
	protected Object value = null;
	protected String valueString = null;
	protected String defaultInput = null;
	protected Class<?> fieldClass = null;
	protected Boolean valid = false;
	protected Boolean required = true;
	protected String validationNote=null;

	private String inputType;

	public AbstractField() {
		
	}
	
	public AbstractField(String name, String label, String type, Boolean required){
		this.name=name;
		this.label= label;
		this.type = type;
		this.required = required;
	}
	
	

	@Override
	public final void setDefaultInput(String defaultInput) {
		this.defaultInput = defaultInput;
		
	}



	@Override
	public final String getDefaultInput() {
		
		return this.defaultInput;
	}

	@Override
	public final void setEntry(String entry) {
		
		this.entry = ("".equals(entry) ? null : entry);
		this.setValue(this.entry);
	}



	@Override
	public final String getEntry(){
		return entry;
	}

	@Override
	public final void setInputType(String inputType) {
		this.inputType=inputType;
	}
	
	@Override
	public final String getInputType() {
		return this.inputType;
	}

	@Override
	public final void setLabel(String fieldLabel) {
		this.label = fieldLabel;
	}



	@Override
	public final String getLabel() {
		return label;
	}
	

	
	@Override
	public final void setName(String fieldName) {
		this.name = fieldName;
	
	}



	@Override
	public final String getName() {
		return name;
	}
	
	@Override
	public final Object getValue(){
		return value;
	}
	
	@Override
	public final String getValueString(){
		return (this.value == null ? "" : this.value.toString());
	}
	
	
	@Override
	public void setRequired(Boolean required){
		this.required = required;
	}

	@Override
	public Boolean isRequired() {
		
		return ((this.required == null) ? false : this.required);
		
	}
	
	@Override
	public Boolean isValid() {
		boolean b = true;
		
		if((this.value == null) && (this.required)){
		
			b = false;
		}
		if (b == true) {
			b = (this.value.getClass() == this.fieldClass);
		}
		
		return (b);
		
	}
	
	@Override
	public String getHtml() {

		String html = "";
		
		this.valueString = (this.value == null ? "" : this.getValue().toString());
		
		html = html + "<label for " + this.name +" >";
		html = html + this.getLabel() +":&nbsp;</label>";
		html = html + "<input type=" +  "\"text\" ";
		html = html + "name=\""+ this.name + "\" ";
		html = html + "value=\""+this.valueString + "\" ";
		html = html + (this.isRequired() ? "required" : "") +">";

		return html;
		

	}

	@Override
	public final void setValidationNote(String validationNote){
		this.validationNote = validationNote;
		
	}
	
	@Override
	public final String getValidationNote(){
//		return this.validationNote;
		return (this.validationNote == null ? null : this.validationNote);
	}






}
