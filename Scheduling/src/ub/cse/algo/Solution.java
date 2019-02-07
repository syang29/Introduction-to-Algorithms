package ub.cse.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    
    private int _n_rallies;
    private ArrayList<int[]> _rallies;
    
    public Solution (int n_rallies, ArrayList<int[]> rallies){
        _n_rallies = n_rallies;
        _rallies = rallies;
    }
    
    /**
     * You should fill this in on your own. Rallies is list of tuples, in the form (rally duration, rally deadline).
     * Your output should also be a list of tuples, of the form (rally id, start time of rally). If no possible
     * schedule exists, you should return an empty list.
     * @return
     */
    public ArrayList<int[]> getSchedule(){
        ArrayList<int[]> schedule = new ArrayList<int[]>();
        ArrayList<int[]> rallyIDAndEnd = new ArrayList<int[]>();
        
        for(int i = 0; i < _n_rallies; i++) {
        	int[] temp = new int[3];
        	temp[0] = i;
        	temp[1] = _rallies.get(i)[0];
        	temp[2] = _rallies.get(i)[1];
        	        	
        	rallyIDAndEnd.add(temp);
        }
        
        Collections.sort(rallyIDAndEnd, new Comparator<int[]>() {
        	@Override
        		public int compare(int[] first, int[] second) {
        			if(first.length == 3 && second.length == 3) {
        				return first[2] - second[2];
        			}return 0;
        	}
        });
        
        int lastFinish = 0;
                
        for(int i = 0; i < _n_rallies; i++) {
        	int[] retInp = new int[2];
        	retInp[0] = rallyIDAndEnd.get(i)[0];
        	retInp[1] = lastFinish;
        	schedule.add(retInp);
        	lastFinish = lastFinish + rallyIDAndEnd.get(i)[1];
        	if(lastFinish > rallyIDAndEnd.get(i)[2]) {
            	return new ArrayList<int[]>();
            }
        	
        }
        
        System.out.println("IMPLEMENT ME!");
        
        return schedule;
    }
}
