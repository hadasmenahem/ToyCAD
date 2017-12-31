
public class Parallelogram extends Shape {
	private Point bottomLeft;
	private Point topLeft;
	private Point topRight;
	private Point bottomRight;
		
	public Parallelogram(int ID, String color,Point bottomLeft, Point topLeft, Point topRight){
		super(ID, color);
		this.bottomLeft=bottomLeft;
		this.topLeft=topLeft;
		this.topRight=topRight;
		this.bottomRight=Point.getFourthPoint(bottomLeft,topLeft,topRight);
	}
	
	public double AreaCalculation(){
		double height=Point.getDistanceBetweenTwoAxisValues(bottomLeft.getY(), topLeft.getY());
		double base=Point.getDistanceBetweenTwoAxisValues(bottomLeft.getX(), bottomRight.getX());
		
		return height*base;
	}
	
	public double CircumferenceCalculation(){
		double sideDistance=Point.getDistanceBetweenTwoPoints(bottomLeft, topLeft);
		double baseDistance=Point.getDistanceBetweenTwoAxisValues(bottomLeft.getX(), bottomRight.getX());
		
		return (2*(sideDistance+baseDistance));
	}
	
	public void Move(double xUnitsToMove, double yUnitsToMove){
		this.bottomLeft.setY(this.bottomLeft.getY()+yUnitsToMove);
		this.bottomLeft.setX(this.bottomLeft.getX()+xUnitsToMove);
		
		this.topLeft.setY(this.topLeft.getY()+yUnitsToMove);
		this.topLeft.setX(this.topLeft.getX()+xUnitsToMove);
		
		this.topRight.setY(this.topRight.getY()+yUnitsToMove);
		this.topRight.setX(this.topRight.getX()+xUnitsToMove);
		
		this.bottomRight.setY(this.bottomRight.getY()+yUnitsToMove);
		this.bottomRight.setX(this.bottomRight.getX()+xUnitsToMove);
	}
	
	public boolean IsInside(Point coordinate){
		double slop=0.0;
		if (coordinate.getX()>=this.topLeft.getX() && coordinate.getX()<=this.bottomRight.getX() &&
				coordinate.getY()>=this.bottomRight.getY() && coordinate.getY()<=this.topLeft.getY())
			return true;
		if (coordinate.getX()<this.topLeft.getX()){
			slop=(this.topLeft.getY()-this.bottomLeft.getY())/(this.topLeft.getX()-this.bottomLeft.getX());
			if ((this.topLeft.getX()-this.bottomLeft.getX())!=0){
				if (coordinate.getY()<slop*coordinate.getX())
					return true;
			}
		}
		if (coordinate.getX()>this.bottomRight.getX()){
			slop=(this.topRight.getY()-this.bottomRight.getY())/(this.topRight.getX()-this.bottomRight.getX());
			if ((this.topRight.getX()-this.bottomRight.getX())!=0){
				if (coordinate.getY()>slop*coordinate.getX())
					return true;
			}
		}
		return false;
	}
		
	
}
