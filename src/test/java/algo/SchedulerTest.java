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

    public void testProblems() throws IOException
    {
    	Scheduler sched = initScheduler("jobs.txt");
    	
    	sched.scheduleOne();
    	
    	long cost = sched.computeCost();
    	
    	System.out.println("HW1 - Problem 1 = "+cost);
    	
    	assertEquals(69119377652L, cost);
                
    	sched.scheduleTwo();
    	
    	cost = sched.computeCost();
    	
    	System.out.println("HW1 - Problem 2 = "+cost);
    	
    	assertEquals(67311454237L, cost);
    }

    public void testEx4() throws IOException
    {
    	
    	Scheduler sched = initScheduler("jobs2.txt");
    	sched.scheduleOne();
    	assertEquals(7226993, sched.computeCost());
    	sched.scheduleTwo();	
    	assertEquals(7078040, sched.computeCost());    
    }

	private Scheduler initScheduler(String filename) throws IOException {
		Scheduler sched = new Scheduler();
    	
    	List<String> lines = Files.readLines(new File(filename), Charset.forName("UTF-8"));

    	for(String line : lines.subList(1, lines.size())) {
    		String []fields = line.split(" ");
    		assertEquals(2, fields.length);
    		
    		int weight = Integer.parseInt(fields[0]);
    		int len    = Integer.parseInt(fields[1]);
    		
    		sched.addJob(weight, len);
    	}
		return sched;
	}
    
    public void testEx1() {
    	
    	Scheduler sched = new Scheduler();
    	sched.addJob(3, 5);
    	sched.addJob(1, 2);    	
    	sched.scheduleOne();

    	assertEquals(23, sched.computeCost());
     	sched.scheduleTwo();
    	assertEquals(22, sched.computeCost());
    }
    
    
    public void testEx2() {
    	
    	Scheduler sched = new Scheduler();
  
    	sched.addJob(20, 50);
    	sched.addJob(4, 79);
    	sched.addJob(9, 80);
    	sched.addJob(77, 58);
    	sched.addJob(46, 2);
    	sched.addJob(31, 92);
    	sched.addJob(55, 8);
    	sched.addJob(13, 12);
    	sched.addJob(61, 92);
    	sched.addJob(38, 5);

    	sched.scheduleOne();
    	assertEquals(40135, sched.computeCost());
     	sched.scheduleTwo();
    	assertEquals(38638, sched.computeCost());
    }
    
    public void testEx3() {
    	
    	Scheduler sched = new Scheduler();

    	sched.addJob(77, 7);
    	sched.addJob(74, 40);
    	sched.addJob(3, 19);
    	sched.addJob(99, 39);
    	sched.addJob(30, 58);
    	sched.addJob(89, 86);
    	sched.addJob(76, 43);
    	sched.addJob(47, 3);
    	sched.addJob(23, 14);
    	sched.addJob(54, 94);
    	
    	sched.scheduleOne();
    	assertEquals(79805, sched.computeCost());
     	sched.scheduleTwo();
    	assertEquals(76719, sched.computeCost());
    }


  }
