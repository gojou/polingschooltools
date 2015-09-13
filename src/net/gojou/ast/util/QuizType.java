package net.gojou.ast.util;

public enum QuizType implements OptionEnum {
	ADDITION("addition"), 
	SUBTRACTION("subtraction"),
	NEGATIVES("subtraction with negatives"),
	MULTIPLICATION("multiplication"), 
	FRACTIONS("fraction"), 
	WHOLE_FRACTIONS("fractions without remainders"),
	DIVISION("division")
/*	ADD_AND_SUBTRACT("addition and subtraction"),
	MULTIPLY_AND_FRACTION("multiplication and addition"),
	MIXED("mixed")
*/	;
	
	private final String name;
	
	private QuizType(String name){
		this.name = name;
	}
	
/*	public String getName(){
		return this.name;
	}
*/	
	/* (non-Javadoc)
	 * @see net.gojou.ast.util.OptionEnum#getOptionString()
	 */
	@Override
	public String getOptionString(){
		return this.name;
	}

}
