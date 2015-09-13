package net.gojou.ast.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Problem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4980833069620116789L;


    private static Random rand = new Random();

    protected int n1;
    protected int n2;
	protected Operations operation;

    private int min;
    private int max;

    private int hashCode;


    private String solutionString;
    
    public Problem(Operations op, int x, int y){
    	this.operation = op;
    	if (x < y){
			min = x;
			max = y;
		}
		else {
			min = y;
			max = x;
		}
    	this.generatePair();


		
    	this.hashCode = Problem.getHashCode(op, n1, n2);
		
    }

/*
    public Problem(int x, int y){
    	operation = Operations.ADDITION;
    	init(x,y);

    }
    
*/   
    
    private void generatePair(){
    	
    	// TODO: Fix this hot mess. Should be handled with a switch/case
    	// n1 and n2 should be set within this 

		
		n1 = rand.nextInt((max - min) + 1) + min;
		n2 = rand.nextInt((max - min) + 1) + min;
		
		switch(this.operation){
		case SUBTRACTION:
			int low;
			int high;
			if(n1<n2){
				high = n2;
				low = n1;
				n1 = high;
				n2 = low;
			}
			break;
		case WHOLE_FRACTIONS:
			
			int dividend;
//			int divisor;
			
			while (n2 == 0){
				n2 = rand.nextInt((max - min) + 1) + min;
			}
			
			dividend = n1 * n2;
			n1 = dividend;
			break;

		default:
			break;
			
		}
		
		
/*		
		if (this.operation.toString().equals("WHOLE_FRACTIONS")){
			
			boolean tryAgain = false;
			
			tryAgain = n2==0;
			
			
			
			if (n1 % n2 != 0) {
				this.generatePair();
			}

		}
*/		
/*		
		if (this.operation.toString().equals("SUBTRACTION")){
			int low;
			int high;
			if(n1<n2){
				high = n2;
				low = n1;
				n1 = high;
				n2 = low;
			}
		}
    	
*/    
		}
    
	public int getN1() {
		return n1;
	}

	public int getN2() {
		return n2;
	}

	public int getSum() {
		return n1+n2;
	}

	public int getDifference(){
		return n1-n2;
	}
	
	public int getProduct() {
		return n1*n2;
	}

	public Integer getDiv() {
		return (n2 == 0 ? null : (int) n1/n2);
	}

	public Integer getMod() {
		return (n2 == 0 ? null : (int) n1%n2);
	}
	
	public Double getQuotient(){
		return (n2 == 0 ? null : (double) n1/n2); 
	}
	
public String getOperatorString(){
		return this.operation.getSymbol();
	
	}


public String getTerm1String(){
		return String.valueOf(this.getN1());
		
	}


public String getTerm2String(){
	return String.valueOf(this.getN2());
}


/*	
	public String getProblemString(){
		return problemString;
	}

*/	
	public String getSolutionString(){
		
		String answerString = "___";

		switch(this.operation){
		case ADDITION:
			answerString = Integer.toString(this.getSum());
			break;
		case SUBTRACTION:
			answerString = Integer.toString(this.getDifference());
			break;
		case NEGATIVES:
			answerString = Integer.toString(this.getDifference());
			break;
		case MULTIPLICATION:
			answerString = Integer.toString(this.getProduct());
			break;
		case FRACTIONS:
		case WHOLE_FRACTIONS:

			Integer whole = this.getDiv();
			Integer numerator = this.getMod();
			Integer denominator = this.n2;
			
			if (whole == null){
				answerString="Undefined";
			}
			else {
				
				if (whole.equals(0) && numerator.equals(0)){
					answerString = numerator.toString();
				}
				if (whole.equals(0) && !numerator.equals(0)){
					answerString  = Problem.asFraction(numerator, denominator);
				}
				if (!whole.equals(0) && numerator.equals(0)){
					answerString = whole.toString();
				}
				if (!whole.equals(0) && !numerator.equals(0)) {
					answerString = whole + " " + Problem.asFraction(numerator, denominator);
				}
			}
			break;
			
		case DIVISION:
			if (this.getDiv()==null){
				answerString="Undefined";
			}
			else {
				Double d = Problem.round(this.getQuotient(),2);
				answerString = d.toString();
			}
			break;
			
		default:
			break;
		}
		solutionString = answerString;
		
		return solutionString;
	}
	





	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	@Override
	public boolean equals(Object testpair){

		if (testpair == null)
			return false;
		
		if (!(testpair instanceof Problem))
			return false;
		
		if (testpair == this)
			return true;
		
		Problem tp = (Problem) testpair;

		return ((this.n1 == tp.n1) && (this.n2 == tp.n2) && (this.operation == tp.operation));
		// return ((this.n1 == tp.getN1()) && (this.n2 == tp.getN2()));
		
		
	}
	
	@Override
	public int hashCode(){

		return this.hashCode;
		
	}


	@Override
	public String toString(){
		return "Operation: " + operation.toString() +" -- N1: " + n1 + " -- N2:" + n2;
	}
	
	private static int getHashCode(Operations operation, int n1, int n2){
		
		int opord = operation.ordinal() +10;
		
		int n1Offset = numlength(n1);
		int n2Offset = numlength(n2);
		
		
		
		return (opord * (int) Math.pow(10, (n1Offset + n2Offset))) + (n1* ((int) Math.pow(10, n2Offset))) + n2 ;
	}

	private static int numlength(int n)
	{
		int x;
		n=Math.abs(n);
		
		if (n==0)
			return 1;
		for (x=0;n>0;++x)
			n/=10;
		return x;			
	}
	
	private static int gcd(int a, int b) {
	    return b == 0 ? a : gcd(b, a % b); // Not bad for one line of code :)
	}

	private static String asFraction(int a, int b) {
	    int gcm = gcd(a, b);
	    return (a / gcm) + "/" + (b / gcm);
	}


}
