package algo;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	
	Set<Edge> edges = new HashSet<Edge>();
	
	Set<Integer> nodes = new HashSet<Integer>();
	
	public static class Edge {
		int startNode;
		int endNode;
		int cost;
		
		public Edge(int startNode, int endNode, int cost) {
			this.startNode = Math.min(startNode ,endNode);
			this.endNode = Math.max(startNode, endNode);
			this.cost = cost;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cost;
			result = prime * result + endNode;
			result = prime * result + startNode;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (cost != other.cost)
				return false;
			if (endNode != other.endNode)
				return false;
			if (startNode != other.startNode)
				return false;
			return true;
		}			
		
		public String toString() {
			return String.format("(%d, %d, %d)", startNode, endNode, cost);
		}
	}
	
	public void addEdge(int n1, int n2, int cost) {
		edges.add(new Edge(n1, n2, cost));
		nodes.add(n1);
		nodes.add(n2);
	}
	
	public Graph minimumSpanningTree() {
		
		Graph mst = new Graph();
		
		mst.nodes.add(nodes.iterator().next());
		while(!mst.nodes.equals(nodes)) {
			
			Edge e = chooseEdge(mst.nodes);
			mst.edges.add(e);
			mst.nodes.add(e.startNode);
			mst.nodes.add(e.endNode); 			
		}		
		return mst;
	}
	
	private boolean crosses(Edge edge, Set<Integer> x) {
		if (x.contains(edge.startNode)) {
			if (!x.contains(edge.endNode))
				return true;				
		}
		else {
			if (x.contains(edge.endNode))
				return true;								
		}		
		return false;
	}

	private Edge chooseEdge(Set<Integer> x) {
		
		Edge minEdge = null;
		for(Edge edge : edges) {		
			if (crosses(edge, x)) {
				if (minEdge == null) {
					minEdge = edge;
				}
				else {
					if (edge.cost < minEdge.cost)
						minEdge = edge;
				}
			}
		}		
		return minEdge;
	}

	public long sumCost() {
		long sum = 0;
		for(Edge edge : edges) {	
			sum += edge.cost;
		}
		return sum;
	}

}
