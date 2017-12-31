
public class Point {

	private double x;
	private double y;
	
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double getY(){
		return y;
	}
		
	public double getX(){
		return x;
	}
	
	public void setY(double y){
		this.y=y;
	}
	
	public void setX(double x){
		this.x=x;
	}
	
	public static double getDistanceBetweenTwoAxisValues(double value1, double value2){
		return Math.abs(value2-value1);
	}
	
	public static double getDistanceBetweenTwoPoints(Point point1, Point point2){
		double xDistance=getDistanceBetweenTwoAxisValues(point1.getX(), point2.getX());
		double yDistance=getDistanceBetweenTwoAxisValues(point1.getY(), point2.getY());
		return (Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2)));
	}
	
	public static Point getFourthPoint(Point bottomLeft, Point topLeft, Point topRight){
		Point bottomRight=new Point(0,0);
		double yDistance=Point.getDistanceBetweenTwoAxisValues(bottomLeft.getY(), topLeft.getY());
		double xDistance=Point.getDistanceBetweenTwoAxisValues(bottomLeft.getX(), topLeft.getX());
		
		bottomRight.setY(topRight.getY()-yDistance);
		bottomRight.setX(topRight.getX()-xDistance);
		
		return bottomRight;
		
	}
}
