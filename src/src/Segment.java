package src;

import java.awt.Point;

public class Segment {
	public Point a;
	public Point b;
	
	public Segment(Point a, Point b)
	{
		this.a = a;
		this.b = b;
	}
	
	public double length()
	{
		return Math.sqrt( (a.x - b.x) * (a.x - b.x) - (a.y - b.y) * (a.y - b.y) );
	}
}
