package net.gojou.ast.fields;

public interface Field {

	public abstract void setName(String fieldName);
	public abstract String getName();

	public abstract void setValue(Object fieldValue);
	public abstract Object getValue();

	public abstract String getValueString();

	
	public abstract void setLabel(String fieldLabel);
	public abstract String getLabel();
	
	public abstract void setEntry(String fieldEntry);
	public abstract String getEntry();
	


	public abstract String getFieldType();
	
	public abstract void setDefaultInput(String defaultInput);
	public abstract String getDefaultInput();
	
	public abstract void setRequired(Boolean required);
	public abstract Boolean isRequired();
	
	public abstract Boolean isValid();
	
	public abstract String getHtml();
	public abstract void setInputType(String inputType);
	public abstract String getInputType();
	
	public abstract void setValidationNote(String validationNote);
	public abstract String getValidationNote();
	
}