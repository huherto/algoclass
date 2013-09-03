package algo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SchedulerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public void testProblemOne() throws IOException
    {
    	Scheduler sched = initScheduler();
    	
    	sched.scheduleOne();
    	
    	long cost = sched.computeCost();
    	
    	System.out.println("Problem 1 = "+cost);
    	
        assertTrue( true );
                
    }

    public void testProblemTwo() throws IOException
    {
    	Scheduler sched = initScheduler();
    	
    	sched.scheduleTwo();
    	
    	long cost = sched.computeCost();
    	
    	System.out.println("Problem 2 = "+cost);
    	
        assertTrue( true );
                
    }

	private Scheduler initScheduler() throws IOException {
		Scheduler sched = new Scheduler();
    	
    	List<String> lines = Files.readLines(new File("jobs.txt"), Charset.forName("UTF-8"));
    	assertEquals(10001, lines.size());
    	for(String line : lines.subList(1, lines.size())) {
    		String []fields = line.split(" ");
    		assertEquals(2, fields.length);
    		
    		int weight = Integer.parseInt(fields[0]);
    		int len    = Integer.parseInt(fields[1]);
    		
    		sched.addJob(weight, len);
    	}
		return sched;
	}
    
    public void testOne() {
    	
    	Scheduler sched = new Scheduler();
    	sched.addJob(3, 5);
    	sched.addJob(1, 2);    	
    	sched.scheduleOne();
    	long cost = sched.computeCost();
    	assertEquals(23, cost);
    }
    public void testTwo() {
    	
    	Scheduler sched = new Scheduler();
    	sched.addJob(3, 5);
    	sched.addJob(1, 2);    	
    	sched.scheduleTwo();
    	long cost = sched.computeCost();
    	assertEquals(22, cost);
    }
  }
