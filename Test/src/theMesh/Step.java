package theMesh;

public class Step {
	public int num1, num2;
	
	public Step(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public String toString(){
		return num1 + " combines with " + num2 + "\n";
	}
}
