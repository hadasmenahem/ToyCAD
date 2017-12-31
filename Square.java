
public class Square extends Rectangle {

	public Square(int ID, String color, Point bottomLeft, double length){
		super(ID, color, bottomLeft, new Point(bottomLeft.getX()+length, bottomLeft.getY()+length));
		
	}
}
