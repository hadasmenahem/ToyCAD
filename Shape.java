
public abstract class Shape {
	int ID;
	String color;
	
	
	public Shape(int ID, String color){
		this.ID=ID;
		this.color=color;
	}
	
	public void SetNewColor(String newColor){
		this.color=newColor;
	}
	
	public String GetColor(){
		return this.color;
	}
	
	public abstract double AreaCalculation();
	public abstract double CircumferenceCalculation();
	public abstract void Move(double xUnitsToMove, double yUnitsToMove);
	public abstract boolean IsInside(Point coordinate);

}
