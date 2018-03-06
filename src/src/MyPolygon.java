package src;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class MyPolygon {
	public List<Point> points = new ArrayList<Point>();
	public Area area = new Area();
	
	public MyPolygon(Point a, Point b, Point c)
	{
		points.add(a);
		points.add(b);
		points.add(c);
		
		int[] xcord = new int[3];
		xcord[0] = a.x;
		xcord[1] = b.x;
		xcord[2] = c.x;
		
		int[] ycord = new int[3];
		ycord[0] = a.y;
		ycord[1] = b.y;
		ycord[2] = c.y;
		
		area = new Area(new Polygon(xcord, ycord, 3));
		//System.out.println(mp.intersect(mp1));
		//new Area([triangle a.x,a.y => b.x,b.y => c.x,c.y]);
	}
	
	public boolean intersect(MyPolygon p)
	{
		Area temp = area;
		temp.intersect(p.area);
		
		return !temp.isEmpty();
	}
	
	public void merge(MyPolygon p)
	{
		area.add(p.area);
		points.addAll(p.points);
			
		points = GrahamScan.getConvexHull(points);
	}
	
	public List<Point> getPoints()
	{
		return points;
	}
	
	public static void main(String[] args)
	{
		MyPolygon mp = new MyPolygon(new Point(0,0), new Point (1,1), new Point(1,0));
		MyPolygon mp1 = new MyPolygon(new Point(0,0), new Point (1,1), new Point(1,0));
		
		System.out.println(mp.getPoints().toString());
		System.out.println(mp1.getPoints().toString());
		
		//System.out.println(mp.intersect(mp1));
		
		mp.merge(mp1);
		System.out.println(mp.getPoints().toString());
		//Area a = new Area(new Rectangle(2,2,2,2));
		//Area b = new Area(new Rectangle(3,3,10,10));
		//a.intersect(b);
		//System.out.println(a.toString());
	}
}
