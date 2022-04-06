public class SingleThreadSum extends Thread{
	
	//Sum Method that takes in the randNumArr to calculate the sum and return the total
	public int sum(int[] randNumArr) {
		int total = 0;
		for(int i = 0; i < randNumArr.length; i++) {
			total = total + randNumArr[i];
		}
		
		return total;
	}
	
}
