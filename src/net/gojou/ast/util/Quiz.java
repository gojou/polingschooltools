package net.gojou.ast.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Quiz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int MAXRETRIES = 100;

	private Integer lowerBound = null;
	private Integer upperBound = null;
	private Integer problemCount = null;
	private QuizType quizType = null;
	private Set<Problem> problemSet = new LinkedHashSet<Problem>();

	public Quiz(){

	}

	public Quiz(QuizType type, int n1, int n2, int length){
		this.quizType = type;
		this.lowerBound=n1;
		this.upperBound=n2;
		this.problemCount=length;
		this.populateQuiz();

	}

	public Boolean isComplete(){
		boolean complete = (this.isValid() && this.isPopulated()); 
/*
		if (!complete)
			this.outputQuizInfo();

*/		return complete;
	}

	public Boolean isPopulated(){
		return (!this.problemSet.isEmpty());
		// return (this.problemSet.isEmpty() ? false : true);
	}

	public Boolean isValid(){
		return (
				(this.lowerBound != null) &&
				(this.upperBound != null) &&
				(this.problemCount != null) &&
				(this.quizType != null)
				);
	}


	public boolean addProblem(Problem problem){
		Problem p = problem;
		return this.problemSet.add(p);
	}

	public Set<Problem> getProblems(){
		return this.problemSet;
	}

	public int getProblemSetSize(){
		return problemSet.size();
	}

	public void clear(){
		problemSet.clear();
	}

	public Integer getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Integer lowerBound) {
		this.lowerBound = lowerBound;
	}

	public Integer getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Integer upperBound) {
		this.upperBound = upperBound;
	}

	public Integer getProblemCount() {
		return problemCount;
	}

	public void setProblemCount(Integer problemCount) {
		this.problemCount = problemCount;
	}

	public OptionEnum getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType){
		this.quizType = QuizType.valueOf(quizType);
	}

	public void setQuizType(QuizType quizType) {
		this.quizType = quizType;
	}

	public void setProblems(Set<Problem> problemSet) {
		this.problemSet = problemSet;
	}

	public void populateQuiz(){

		int retries = 0;

		while ((this.problemSet.size() < this.problemCount) && retries < MAXRETRIES){
			Problem p = new Problem(this.getOperation(), this.lowerBound, this.upperBound);
			if (this.addProblem(p) == false) {
				retries++;
			}
		}

		/*		
		if (this.problemSet.size() != this.problemCount){
			C.c("Retries: " + retries);
			C.c("Requested: " + this.problemCount + " -- " + "Returned: " + this.problemSet.size());
		}

		 */	
	}

	public Set<String> getFieldNames(){
		Set<String> nameSet = new LinkedHashSet<String>();
		String[] names = {"lowerbound",
				"upperbound",
				"length",
		"operation"};
		nameSet.addAll(Arrays.asList(names));
		return nameSet;
	}

	public void setQuizParameter(String name, String value){
//		C.c(this.getClass().getSimpleName()+": "+"Reached setQuizParameter: "+ name + " = " + value);
		switch(name){
		case "n1":
			this.setLowerBound(Integer.valueOf(value));
			break;
		case "n2":
			this.setUpperBound(Integer.valueOf(value));
			break;
		case "length":
			this.setProblemCount(Integer.valueOf(value));
			break;
		case "operation":
			this.setQuizType(value);
		}
	}

	private Operations getOperation(){
		switch(this.quizType){
		case ADDITION:
			return Operations.ADDITION;
		case SUBTRACTION:
			return Operations.SUBTRACTION;
		case MULTIPLICATION:
			return Operations.MULTIPLICATION;
		case FRACTIONS:
			return Operations.FRACTIONS;
		case DIVISION:
			return Operations.DIVISION;
			/*		case ADD_AND_SUBTRACT:
			return Operations.ADDITION;
		case MULTIPLY_AND_FRACTION:
			return Operations.ADDITION;
		case MIXED:
			return Operations.ADDITION;
			 */
		case NEGATIVES:
			return Operations.NEGATIVES;
		default:
			break;			
		}

		return Operations.ADDITION;
	}

/*

	private void outputQuizInfo(){
		C.c(this.getClass().getSimpleName()+".outputQuizInfo:");
		C.c("\t" + "lowerBound = " + this.lowerBound);
		C.c("\t" + "upperBound = " + this.upperBound);
		C.c("\t" + "problemCount = " + this.problemCount);
		C.c("\t" + "quizType = " + this.quizType);

	}

*/

	public enum fields {
		LOWERBOUND("lowerbound"), 
		UPPERBOUND("upperbound"),
		PROBLEMCOUNT("problemcount"),
		OPERATION("operation");

		private String fieldName;

		private fields(String s){
			this.fieldName = s;
		}

		public String getFieldName(){
			return this.fieldName;
		}
	}

}
