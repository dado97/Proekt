package src;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args)
	{
		Point start = new Point();
		Point end = new Point();
		Obstacles obstacles = new Obstacles();
		
		Scanner scanner = new Scanner(System.in);
		
		start.setLocation(scanner.nextInt(), scanner.nextInt());
		end.setLocation(scanner.nextInt(), scanner.nextInt());
		
		int n = scanner.nextInt();
		
		for(int i = 0; i<n; i++)
		{
			Point a = new Point(scanner.nextInt(),scanner.nextInt());
			Point b = new Point(scanner.nextInt(),scanner.nextInt());
			Point c = new Point(scanner.nextInt(),scanner.nextInt());
			
			MyPolygon toAdd = new MyPolygon(a,b,c);
			
			obstacles.addObstacle(toAdd);
		}
		
		scanner.close();
	}
}
