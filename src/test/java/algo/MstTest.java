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
		for (String line : lines.subList(1, lines.size())) {
			fields = line.split(" ");
			assertEquals(3, fields.length);

			int v1 = Integer.parseInt(fields[0]);
			int v2 = Integer.parseInt(fields[1]);
			int cost = Integer.parseInt(fields[2]);

		}
	}

}
