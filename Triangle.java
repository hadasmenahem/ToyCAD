
public class Triangle extends Shape {
	private Point top;
	private Point bottomLeft;
	private Point bottomRight;
	
	public Triangle(int ID, String color, Point top, Point bottomLeft, Point bottomRight){
		super(ID, color);
		this.top=top;
		this.bottomLeft=bottomLeft;
		this.bottomRight=bottomRight;
	}

	
	public double AreaCalculation(){
		double height=Point.getDistanceBetweenTwoAxisValues(this.bottomLeft.getY(), this.top.getY());
		double base=Point.getDistanceBetweenTwoAxisValues(this.bottomLeft.getX(), this.bottomRight.getX());
		
		return (height*base/2);
	}
	
	public double CircumferenceCalculation(){
		double side1Length=Point.getDistanceBetweenTwoPoints(this.bottomLeft, this.top);
		double side2Length=Point.getDistanceBetweenTwoPoints(this.bottomRight, this.top);
		double side3Length=Point.getDistanceBetweenTwoPoints(this.bottomLeft, this.bottomRight);
		
		return (side1Length+side2Length+side3Length);
	}
	
	public void Move(double xUnitsToMove, double yUnitsToMove){
		this.top.setY(this.top.getY()+yUnitsToMove);
		this.top.setX(this.top.getX()+xUnitsToMove);
		
		this.bottomLeft.setY(this.bottomLeft.getY()+yUnitsToMove);
		this.bottomLeft.setX(this.bottomLeft.getX()+xUnitsToMove);
		
		this.bottomRight.setY(this.bottomRight.getY()+yUnitsToMove);
		this.bottomRight.setX(this.bottomRight.getX()+xUnitsToMove);
	}
	
	public boolean IsInside(Point coordinate){
		double vectorProduct1=((this.top.getY()-this.bottomRight.getY())*(coordinate.getX()-this.bottomRight.getX())+
				(this.bottomRight.getX()-this.top.getX())*(coordinate.getY()-this.bottomRight.getY()))/
				((this.top.getY()-this.bottomRight.getY())*(this.bottomLeft.getX()-this.bottomRight.getX())+
				(this.bottomRight.getX()-this.top.getX())*(this.bottomLeft.getY()-this.bottomRight.getY()));
		double vectorProduct2=((this.bottomRight.getY()-this.bottomLeft.getY())*(coordinate.getX()-this.bottomRight.getX()+
				(this.bottomLeft.getX()-this.bottomRight.getX())*(coordinate.getY()-this.bottomRight.getY()))/
		     		  ((this.top.getY()-this.bottomRight.getY())*(this.bottomLeft.getX()-this.bottomRight.getX())+
		    		   (this.bottomRight.getX()-this.top.getX())*(this.bottomLeft.getY()-this.bottomRight.getY())));
		double vectorProduct3=1.0f-vectorProduct1-vectorProduct2;
		
		return (vectorProduct1>0 && vectorProduct2>0 && vectorProduct3>0);
	}
}
