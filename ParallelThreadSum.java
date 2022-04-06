
public class ParallelThreadSum {
	private ParallelThread[] sums;
	private int threadCount;
	
	//Setter
	public ParallelThreadSum(int threadCount) {
		this.threadCount = threadCount;
		this.sums = new ParallelThread[threadCount];
	}
	
	//This divides up the array between multiple processors to calculate the sum
	public int sum(int[] randNumArr) {
		
		int steps = (int) Math.ceil(randNumArr.length * 1.0 / threadCount);
		
		for(int i = 0; i < threadCount; ++i) {
			sums[i] = new ParallelThread(randNumArr, i * steps, (i+1) * steps);
			sums[i].start();
		}
		
		//Makes sure Threads are calculating in parallel with eachother
		for(ParallelThread threads : sums)
			try {
				threads.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
		
		int total = 0;
		
		for(ParallelThread threads : sums) 
			total = threads.getPartialSum();
		
		
		return total;
	}
}
