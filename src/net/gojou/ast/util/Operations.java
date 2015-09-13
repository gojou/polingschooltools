package net.gojou.ast.util;

public enum Operations {
	ADDITION("+","addition"), 
	SUBTRACTION("-","subtraction"),
	NEGATIVES("-","subtraction with negatives"),
	MULTIPLICATION("x","multiplication"), 
	FRACTIONS("/","fractions"),
	WHOLE_FRACTIONS("/","fractions without remainders"),
	DIVISION("&divide;","division");
	
	private final String symbol;
	private final String optionString;
	
	private Operations(String s, String n){
		this.symbol = s;
		this.optionString = n;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	public String getOptionString(){
		return this.optionString;
	}
	
	public static Operations getOperation(String operationString) throws NullPointerException{
		Operations returnOperation = null;
		for (Operations operation : Operations.values()){
			if (operation.name().equals(operationString)){
				returnOperation = operation;
			}
		}
		if (returnOperation == null){
			throw new NullPointerException("Operations Not Found");
		}
		return returnOperation;
		
	}
	
	public static Boolean contains (String operationString){
		Boolean result = false;
		for (Operations operation : Operations.values()){
			if (operation.name().equals(operationString)){
				result = true;
				break;
			}
		}
		return result;
	}


}
