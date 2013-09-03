package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	
	Set<Edge> edges = new HashSet<Edge>();
	
	Set<Integer> nodes = new HashSet<Integer>();
	
	public static class Edge {
		int startNode;
		int endNode;
		int cost;
		
		public Edge(int startNode, int endNode, int cost) {
			super();
			this.startNode = startNode;
			this.endNode = endNode;
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
			mst.nodes.add(e.endNode); 			
		}		
		return mst;
	}

	private Edge chooseEdge(Set<Integer> x) {
		
		for(Edge edge : edges) {			
			if (x.contains(edge.startNode)) {
				if (!x.contains(edge.endNode))
					return edge;				
			}
			else {
				if (x.contains(edge.endNode))
					return edge;								
			}			
		}		
		throw new RuntimeException("logic error");
	}

}
