package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * For use in CSE 331 HW1.
 * This is the class you will be editing and turning in. It will be timed against our implementation
 * NOTE that if you declare this file to be in a package, it will not compile in Autolab
 */
public class Solution {

    private int numberOfMenAndWomen;


    // The following represent the preference list for the men and women.
    // The KEY represents the integer representation of a given man or woman.
    // The VALUE is a list, from most preferred to least, of the member of the opposite gender.
    private HashMap<Integer, ArrayList<Integer>> men;
    private HashMap<Integer, ArrayList<Integer>> women;
    private ArrayList<Matching> stableMatchings = new ArrayList<>();
    private ArrayList<Matching> matchings = new ArrayList<>();

    /**
     * The constructor simply sets up the necessary data structures.
     * The grader for the homework will first call this class and pass the necessary variables.
     * There is no need to edit this constructor.
     *
     * @param n The number of men/women.
     * @param men A map linking each man (integer value) with their preference list.
     * @param women A map linking each woman (integer value) with their preference list.
     */
    public Solution(int n, HashMap<Integer, ArrayList<Integer>> men, HashMap<Integer, ArrayList<Integer>> women){
        this.numberOfMenAndWomen = n;
        this.men = men;
        this.women = women;
    }

    /**
     * This method must be filled in by you. You may add other methods and subclasses as you see fit,
     * but they must remain within the HW1_Student_Solution class.
     * @return Your set of stable matches. Order does not matter.
     */
    public ArrayList<Matching> outputStableMatchings() {

            /* The code below just calls the permutate function, which just prints all perfect matcgings*/
            ArrayList<Marriage> mar = new ArrayList<Marriage>();
            for(int k = 1; k<=numberOfMenAndWomen; ++k) {
                Marriage m = new Marriage(k, k);
                mar.add(m);
            }
            Matching mat = new Matching(mar);
            System.out.println("Printing all possible perfect matchings for n ="+numberOfMenAndWomen);
            System.out.println("----------------------------");
            permutate(mat,numberOfMenAndWomen);
            System.out.println("----------------------------");
            /*permuate call done*/
            
       
            
        return stableMatchings;
    }
    
    public void matchingStable(Matching match) {
    	boolean stable = true;
    	for(int k = 0; k < match.size(); k++) {
    		for(int j = 0; j < match.size(); j++) {
    			if(j != k) {
    				stable = stableOrNot(match.get(k), match.get(j));
    				if(!stable) {
    					break;
    				}
    			}
    		}	
    		if(!stable) {
    			break;
    		}
    		
    	}
    	if(stable) {
    		stableMatchings.add(match);
    	}
    	
    }
    
    public boolean stableOrNot(Marriage m1, Marriage m2) {
    	int man1 = m1.man;
    	int man2 = m2.man;
    	int woman1 = m1.woman;
    	int woman2 = m2.woman;
    	
    	ArrayList<Integer> m1pref = men.get(man1);
    	ArrayList<Integer> w2pref = women.get(woman2);
    	
    	boolean man1PrefersWoman2 = false;
    	int i = 0;
    	while(m1pref.get(i) != woman1) {
    		if(m1pref.get(i) == woman2) {
    			man1PrefersWoman2 = true;
    			break;
    		}
    		i = i+1;
    	}
    	
    	boolean woman2PrefersMan1 = false;
    	int k = 0;
    	if(man1PrefersWoman2) {
    		while(w2pref.get(k) != man2) {
    			if(w2pref.get(k) == man1) {
    				woman2PrefersMan1 = true;
    				break;
    			}
    			k = k+1;
    		}
    	}else { return true;}
    	if(woman2PrefersMan1 == true) {
    		return false;
 
    	}
    	return true;
    	
    }

    /**
     * This method prints all of the permutations of the input for you.
     * However, it needs some modifications before it can be used for your solution (it will currently overwrite its output every time you run it).
     * Perhaps something needs to be deep-copied.
     * @param set A complete matching set, not necesarrily stable
     * @param length length of the set
     */
    private void permutate(Matching set, int length){
        if(length == 1){
            System.out.println(set);
            Matching match = new Matching();
            for(int i = 0; i < set.size(); i++) {
            	Marriage mar = new Marriage(set.get(i).man.intValue(), set.get(i).woman.intValue());
            	match.add(mar);
            }
            matchingStable(match);
        }
        else{
            for(int i = 0; i < length; i++){
                permutate(set, length - 1);
                int j = (length % 2 == 0 ) ? i : 0;
                Integer t = set.get(length-1).woman;
               
                set.get(length-1).woman = set.get(j).woman;
                set.get(j).woman = t;
            }
        }
    }

}
