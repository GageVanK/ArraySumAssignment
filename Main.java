import java.util.Random;


public class Main {

public static void main(String[] args) throws InterruptedException

{
//Using RNG for values in array
Random rng = new Random();

int threadCount = Runtime.getRuntime().availableProcessors();
SingleThreadSum singleSum = new SingleThreadSum();	


//Creating the integer array of 200 Million Values 
int[] randNumArr = new int[200000000];


//For loop to assign RNG Values between 1-10 to array
for (int i = 0; i < randNumArr.length; i++) {

	randNumArr[i] = rng.nextInt(10) + 1;

}

//Using a single thread to calculate the sum of the array
long startTime = (long) System.currentTimeMillis();
System.out.println("The Sum of the Array is " + singleSum.sum(randNumArr) + ". This took " + (System.currentTimeMillis() - startTime) + "ms.");

//Using 12 processors to solve for the sum
//Not sure where I am going wrong it is either incorrectly adding the sum or adding the sum of a different rng Array because the totals never seem to match
//Although this always is faster its not calculating the sum of the same array as the single thread array
ParallelThreadSum paraSum = new ParallelThreadSum(threadCount);
startTime = (long) System.currentTimeMillis();
System.out.println("The Sum of the Array is " + paraSum.sum(randNumArr) + ". This took " + (System.currentTimeMillis() - startTime) + "ms and used " + threadCount + " threads to solve.");
}

}
