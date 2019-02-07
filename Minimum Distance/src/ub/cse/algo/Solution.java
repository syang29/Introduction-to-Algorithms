package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	  private int startNode;
	  private HashMap<Integer, ArrayList<Integer>> graph;
	  public Solution(int node, HashMap<Integer, ArrayList<Integer>> g){
	    startNode = node;
	    graph = g;
	  }

	  public int[] outputDistances(){
		  int[] connectedAndDistance = new int[graph.size()];
		  for(int i = 0; i < graph.size(); i++) {
			  connectedAndDistance[i] = -1;
		  }
		  connectedAndDistance[startNode] = 0;
		  int layerOrDistance = 0;
		  ArrayList<ArrayList<Integer>> eachLevel = new ArrayList<ArrayList<Integer>>();
		  eachLevel.add(new ArrayList<Integer>());
		  eachLevel.get(0).add(startNode);
		  while(eachLevel.get(layerOrDistance).size() > 0) {
			  eachLevel.add(new ArrayList<Integer>());
			  //loop through all nodes in a layer
			  for(int i = 0; i < eachLevel.get(layerOrDistance).size(); i++) {
				  
				  //loop through all nodes connected to a node in the layer currently being looked at
				  for(int j = 0; j < graph.get(eachLevel.get(layerOrDistance).get(i)).size(); j++) {
					  
					  int connectedNode = graph.get(eachLevel.get(layerOrDistance).get(i)).get(j);
					  if(connectedAndDistance[connectedNode] == -1) {
						  connectedAndDistance[connectedNode] = layerOrDistance+1;
						  eachLevel.get(layerOrDistance+1).add(connectedNode);
					  }
				  }
			  }
			  layerOrDistance++;
		  }
		  
		  
		  
		  return connectedAndDistance;
	  }
}
