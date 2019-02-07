package ub.cse.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    
    private Integer _n_points;          // Number of points in the plane
    private ArrayList<Point> _points;  // This ArrayList contains all points in the plane
    
    public Solution (Integer n_points, ArrayList<Point> points){
        _n_points = n_points;
        _points = points;
    }
    
    public class PointCompX implements Comparator<Point>{

		@Override
		public int compare(Point first, Point second) {
			if(first._x == second._x) {return first._y - second._y;}
			return first._x - second._x;
		}
    	
    }
    
    public class PointCompY implements Comparator<Point>{

		@Override
		public int compare(Point first, Point second) {
			if(first._y == second._y) {return first._x - second._x;}
			return first._y - second._y;
		}
    	
    }
    
    public double distance(Point one, Point two) {
    	int x = one._x-two._x;
    	int y = one._y - two._y;
    	return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
    
    public double closestInBox(ArrayList<Point> s, double delta){
    	
    	double minDistance = delta;
    	for(int i = 0; i < s.size(); i++) {
    		for(int j = 1; j < 15 && i+j < s.size(); j++) {
    			double tempDist = distance(s.get(i), s.get(i+j));
    			if(tempDist < minDistance) {
    				minDistance = tempDist;
    				
    			}
    		}
    	}
    	return minDistance;
    }
    
    public double minDistance(ArrayList<Point> Px) {
    	double minDistance = Double.MAX_VALUE;
 		for(int i = 0; i < Px.size(); i++) {
 			for(int j = i+1; j < Px.size(); j++) {
 				double temp = distance(Px.get(i), Px.get(j));
 				if(temp < minDistance) {
 					minDistance = temp;
 				}
 			}
 		}return minDistance;
    }
    
    
    
    public double closestDistance(ArrayList<Point> Px){
    	if(Px.size() < 4) {
    		return minDistance(Px);
    	}
    	
    	int half = Px.size()/2;
    	Point halfX = Px.get(half);
    	
       	ArrayList<Point> qx = new ArrayList<Point>();
    	ArrayList<Point> rx = new ArrayList<Point>();
    	
    	for(int i = 0; i < Px.size(); i++) {
    		if(i<half) {qx.add(Px.get(i));}
    		else {rx.add(Px.get(i));}
    	}
    	 	
         	
    	double smallestQ = closestDistance(qx);
    	double smallestR = closestDistance(rx);
    	
    	
    	double delta = Math.min(smallestQ, smallestR);
		ArrayList<Point> s = new ArrayList<Point>();
		for(int i = 0; i < Px.size(); i++) {
			
			if(Px.get(i)._x >= (halfX._x + delta)) {break;}
			if(Px.get(i)._x > (halfX._x - delta)) {
				s.add(Px.get(i));
			}
		}
		
		
		Collections.sort(s,new PointCompY());
		return closestInBox(s, delta );
    	
    }
    
    public double outputClosestDistance(){
        Collections.sort(_points, new PointCompX());
        ArrayList<Point> sortedByX = new ArrayList<Point>();
        for(int i = 0; i < _points.size(); i++) {
        	sortedByX.add(_points.get(i));
        }
        Collections.sort(_points, new PointCompY());
      
    	return closestDistance(sortedByX);
    }
}
