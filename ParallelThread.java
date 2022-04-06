
public class ParallelThread extends Thread{
	
	private int[] randNumArr;
	private int low, high, partialSum;
	
	//Setter
	public ParallelThread(int[] randNumArr, int low, int high) {
		this.randNumArr = randNumArr;
		this.low = low;
		this.high = Math.min(high, randNumArr.length);	
	}
	
	//Getter
	public int getPartialSum() {
		return this.partialSum;
		
	}
	
	//Allows individual threads to calculate their partialSum to be added together to find the total
	@Override
	public void run() {
		partialSum = 0;
		
		for(int i = low; i < high; i++) {
			partialSum = partialSum + randNumArr[i];
		}
	}
}
