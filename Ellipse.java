
public class Ellipse extends Shape {
	private Point focus1;
	private Point focus2;
	private double D;
	
	public Ellipse(int ID, String color, Point focus1, Point focus2, double D){
		super(ID, color);
		this.focus1=focus1;
		this.focus2=focus2;
		this.D=D;
	}
	
	private double aSubAxisCalculation(){
		return this.D/2;
	}
	
	private double bSubAxisCalculation(){
		double distanceBetweenFocusPoints=Point.getDistanceBetweenTwoPoints(this.focus1, this.focus2);
		return(Math.sqrt(Math.pow(this.D/2, 2)-Math.pow(distanceBetweenFocusPoints/2, 2)));
	}
	
	public double GetCircleRadius(){
		return this.D/2;
	}
	
	public double AreaCalculation(){
		double aSubAxis=aSubAxisCalculation();
		double bSubAxis=bSubAxisCalculation();
		return (aSubAxis*bSubAxis*Math.PI);	
	}
	
	public double CircumferenceCalculation(){
		double aSubAxis=aSubAxisCalculation();
		double bSubAxis=bSubAxisCalculation();
		return (Math.PI*(aSubAxis+bSubAxis)-Math.sqrt(10*aSubAxis*bSubAxis+3*(Math.pow(aSubAxis, 2)
			+Math.pow(bSubAxis, 2))));
	}
	
	public void Move(double xUnitsToMove, double yUnitsToMove){
		this.focus1.setX(this.focus1.getX()+xUnitsToMove);
		this.focus1.setY(this.focus1.getY()+yUnitsToMove);
		this.focus2.setX(this.focus2.getX()+xUnitsToMove);
		this.focus2.setY(this.focus2.getY()+yUnitsToMove);
	}
	
	public boolean IsInside(Point coordinate){
		double xRadius=aSubAxisCalculation();
        double yRadius=bSubAxisCalculation();

		Point center = new Point(Point.getDistanceBetweenTwoAxisValues(focus1.getX(), focus2.getX())/2,
				Point.getDistanceBetweenTwoAxisValues(focus1.getY(), focus2.getY())/2);
           
        Point normalizedCoordinate = new Point(coordinate.getX()-center.getX(),
        		coordinate.getY()-center.getY());

        return ((Math.pow(normalizedCoordinate.getX(),2)/Math.pow(xRadius,2) +
        		Math.pow(normalizedCoordinate.getY(), 2)/Math.pow(yRadius, 2))<= 1.0);
	}
}

