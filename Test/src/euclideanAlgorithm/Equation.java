package euclideanAlgorithm;


public class Equation {
	private int firstCoefficient = 1;
	private boolean fCisNegative = false;
	private int secondCoefficient = 1;
	private boolean sCisNegative = false;
	private int[] originalNumbers = new int[2];
	private int gcd = 1;


	public int getGcd() {
		return gcd;
	}

	public Equation(int a, int b) {
		//stores original values
		originalNumbers[0] = a;
		originalNumbers[1] = b;

		//changes negatives accordingly
		if (a < 0){
			fCisNegative = true;
			a = Math.abs(a);
		}
		if (b < 0){
			sCisNegative = true;
			b = Math.abs(b);
		}
		
		//simplifies if gcd != 0
		int[] simplified = simplify(a, b);
		a = simplified[0];
		b = simplified[1];
		
		//initiates value objects with the (possibly) changed inputs
		Value v1 = new Value(a, 1, 0);
		Value v2 = new Value(b, 0, 1);
		
		//begins the recursion
		if (Math.max(v1.getNumber(), v2.getNumber()) == v1.getNumber()){
			calculate(v1, v2);
		} else {
			calculate(v2, v1);
		}
	}

	//calculates gcd and returns the simplified numbers
	private int[] simplify(int a, int b) {
		for (int i = 2; i <= a; i++){
			if(a % i == 0 && b % i == 0){
				gcd = i;
			}
		}
		int[] simplified = {a / gcd, b / gcd};
		return simplified;
	}

	private void calculate(Value v1, Value v2) {
		
		//if we haven't reached the value we want, we make a new value
		if (v1.getNumber() - v2.getNumber() != 1){
			Value v3 = new Value(v1.getNumber() - v2.getNumber(), v1.getC1() - v2.getC1(), v1.getC2() - v2.getC2());
			
			//continues recursion with new lowest values
			if (Math.max(v2.getNumber(), v3.getNumber()) == v2.getNumber()){
				calculate(v2, v3);
			} else {
				calculate(v3, v2);
			}
			
		} else {
			//if we have reached the value, the coefficient values are set accordingly
			firstCoefficient = v1.getC1() - v2.getC1();
			secondCoefficient = v1.getC2() - v2.getC2();
		}
		
	}

	public int getFirstCoefficient() {
		if (fCisNegative){
			return firstCoefficient * -1;
		} else {
			return firstCoefficient;
		}
	}

	public int getSecondCoefficient() {
		if (sCisNegative){
			return secondCoefficient * -1;
		}
		return secondCoefficient;
	}
	
	public String getAnswer(){
		return getFirstCoefficient() + " * " + originalNumbers[0] + " + " + getSecondCoefficient() + 
				" * " + originalNumbers[1] + " = " + gcd;
	}

	public String getEquation() {
		return "(x * " + originalNumbers[0] + ") + (y * " + originalNumbers[1] + ") = " + gcd;
	}

}
