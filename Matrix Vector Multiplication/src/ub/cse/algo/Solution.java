package ub.cse.algo;

import java.util.Arrays;
import java.util.Vector;
import java.util.ArrayList;

/**
 * For use in CSE 331
 * Template for Homework 3
 */
public class Solution {
    
    private ArrayList<Integer> in_vector;
    
    /**
     * The constructor simply sets up the necessary data structures.
     * The grader for the homework will first call this class and pass the necessary variables.
     * There is no need to edit this constructor.
     *
     * @param in_vector the vector used to multiply against the matrix
     */
    public Solution(ArrayList<Integer> in_vector) {
        this.in_vector = in_vector;
    }
    
    /**
     * This method must be filled in by you. You may add other methods and subclasses as you see fit,
     * but they must remain within the Solution class.
     * @return Your resulting vector.
     */
    public ArrayList<Integer> outputVector() {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	int index1 = 0;
    	
    	for(int i = 0; i < in_vector.size(); i++) {
    		index1 = index1 +in_vector.get(i);
    	}
    	ret.add(index1);
    	
    	for(int i = 0; i < in_vector.size()-1; i++) {
    		index1 = index1 - in_vector.get(i);
    		ret.add(index1);
    	}
    	
        return ret;
    }
}
