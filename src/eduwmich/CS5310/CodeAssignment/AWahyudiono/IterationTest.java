package eduwmich.CS5310.CodeAssignment.AWahyudiono;

/**
 * Class for doing iteration test for each sorting algorithms.
 * The test will be performed as the number that mentioned in the argument.
 * The result will be an average time that took by total number of time divide by iteration number
 * @author agung
 *
 */

public class IterationTest {
	
	private int iNumber; // iteration number
	private Sorting sort; // Sort class instance 
	private int arr[]; // test array
	
	/**
	 * Set the parameter of test
	 * @param iNumb, iteration number
	 * @param s, instance of sorting class
	 * @param a, array to be sorted
	 */
	public void setTest(int iNumb, Sorting s, int a[] ) {
		this.iNumber = iNumb;
		this.sort = s;
		this.arr = a;
	}
	
	/**
	 * Do the iteration test based on input parameter
	 * @return diff time, as long
	 */
	public long doTest() {
		
		// Define time diff
		long timeDif;
		
		// set array to be sorted for the sorting algorithms
		sort.setArray(this.arr);
		
		// Get the system time before the iteration test.
		long startTime = System.nanoTime();
		
		// Do iteration test 
		for(int i = 0; i < this.iNumber; i++) {
			sort.doSort();
		}
		
		// Get the system time after the iteration test
		long endTime = System.nanoTime();
		
		// calculate the average diff time
		timeDif = (endTime-startTime)/this.iNumber;
		
		// return the average diff time
		return timeDif;
	}

}
