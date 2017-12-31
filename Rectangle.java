
public class Rectangle extends Parallelogram{
	
	public Rectangle(int ID, String color, Point bottomLeft, Point topRight){
		super(ID, color, bottomLeft, new Point(bottomLeft.getX(),topRight.getY()), topRight);
	}
}
