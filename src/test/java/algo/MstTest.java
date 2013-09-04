package algo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;

import junit.framework.TestCase;

public class MstTest extends TestCase {
	
	public void testProblem3() throws IOException {
		List<String> lines = Files.readLines(new File("edges.txt"),
				Charset.forName("UTF-8"));
		assertEquals(2185, lines.size());
		
		String fields[] = lines.get(0).split(" ");
		assertEquals(2, fields.length);
		
		int nodes = Integer.parseInt(fields[0]);
		int edges = Integer.parseInt(fields[1]);
		assertEquals(500, nodes);
		assertEquals(2184, edges);
		Graph g = new Graph();
		for (String line : lines.subList(1, lines.size())) {
			fields = line.split(" ");
			assertEquals(3, fields.length);

			int v1 = Integer.parseInt(fields[0]);
			int v2 = Integer.parseInt(fields[1]);
			int cost = Integer.parseInt(fields[2]);
			g.addEdge(v1, v2, cost);

		}
		
		
		Graph mst = g.minimumSpanningTree();
		System.out.println("HW1 - Problem 3 "+mst.sumCost());
	}
	
	public void testSmallExample() {
		
		Graph g = new Graph();
		g.addEdge(1, 2, 1);
		g.addEdge(1, 4, 3);
		g.addEdge(1, 3, 4);
		g.addEdge(2, 4, 2);
		g.addEdge(3, 4, 5);
		Graph mst = g.minimumSpanningTree();
		assertEquals(7, mst.sumCost());	
	}

}
