package src;

import java.util.ArrayList;

public class Obstacles {
	public ArrayList<MyPolygon> list;
	
	public Obstacles()
	{
		list = new ArrayList<MyPolygon>();
	}
	
	public void addObstacle(MyPolygon mp)
	{
		if(list.isEmpty()) list.add(mp);
		else {
			
			for(int i = 0; i<list.size();i++)
			{
				if(list.get(i).intersect(mp))
				{
					MyPolygon toAdd = list.remove(i);
					toAdd.merge(mp);
					addObstacle(toAdd);
				}
			}
			
		}
	}
}
