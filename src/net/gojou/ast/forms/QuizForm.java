package net.gojou.ast.forms;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import net.gojou.ast.fields.Field;
import net.gojou.ast.fields.IntegerField;
import net.gojou.ast.fields.OptionField;
import net.gojou.ast.util.Operations;

public class QuizForm extends AbstractForm implements Form, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1504885115362574372L;
	
	private Field f1;
	private Field f2;
	private Field f3;
	private Field f4;
	
	private static final Map<String,String> validInputMap = new LinkedHashMap<String,String>();
	static {
		validInputMap.put("addition", "ADDITION");
		validInputMap.put("subtraction", "SUBTRACTION");
		validInputMap.put("multiplication", "MULTIPLICATION");
		validInputMap.put("fractions", "FRACTIONS");
		validInputMap.put("division", "DIVISION");
	}
	
	
	public QuizForm() {
		// TODO Auto-generated constructor stub
		
		f1 = new IntegerField();
		f2 = new IntegerField();
		f3 = new IntegerField();
		f4 = new OptionField();
		
		f1.setName("length");
		f1.setLabel("Quiz Length");
		f1.setInputType("number");
		f1.setDefaultInput("10");
		f1.setRequired(true);
		
		f2.setName("n1");
		f2.setLabel("Lower Bound");
		f2.setInputType("number");
		f2.setDefaultInput("0");
		f2.setRequired(true);
		
		f3.setName("n2");
		f3.setLabel("Upper Bound");
		f3.setInputType("number");
		f3.setDefaultInput("20");
		f3.setRequired(true);
		
		f4.setName("operation");
		f4.setLabel("Problem type");
		f4.setInputType("text");
		f4.setRequired(true);
		f4.setDefaultInput(Operations.ADDITION.toString());
		
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		fields.add(f4);

	}
}
