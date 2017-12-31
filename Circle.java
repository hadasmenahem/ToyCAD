
public class Circle extends Ellipse{
	
	public Circle(int ID, String color, Point focus, double radius){
		super(ID, color, focus, focus, 2*radius);
	}
	
	public double CircumferenceCalculation(){
		return (2*Math.PI*this.GetCircleRadius());
	}
}
