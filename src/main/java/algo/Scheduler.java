package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Scheduler 
{
	
	public static class Job {
		
		public int weigth;
		public int length;
		
		public Job(int w, int l) {
			weigth = w;
			length = l;			
		}
		
	}
	
	List<Job> jobs = new ArrayList<Job>();
	
	public void addJob(int w, int l) {
		jobs.add(new Job(w, l));		
	}
	
	public void scheduleOne() {
		
		Collections.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job j1, Job j2) {
				
				int d1 = j1.weigth - j1.length;
				int d2 = j2.weigth - j2.length;
				if (d1 != d2) {
					return d1 - d2;
				}
				return j1.weigth - j2.weigth;
			}
			
		});
		
		Collections.reverse(jobs);
		
	}
	
	public void scheduleTwo() {
		
		Collections.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job j1, Job j2) {
				
				float f1 = (float)j1.weigth / (float)j1.length;
				float f2 = (float)j2.weigth / (float)j2.length;
				if (f1 > f2)
					return 1;
				if (f2 > f1)
					return -1;
				return 0;
			}
			
		});
		
		Collections.reverse(jobs);
		
	}
	
	public long computeCost() {
		
		long sum = 0;
		long  completion = 0;
		for(Job job : jobs) {
			completion += job.length;
			sum += completion * job.weigth;
		}
		return sum;
	}
	
	
}
