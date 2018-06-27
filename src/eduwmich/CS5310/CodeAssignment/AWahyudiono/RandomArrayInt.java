package eduwmich.CS5310.CodeAssignment.AWahyudiono;

/**
 * Class for producing random array of integer
 * @author agung wahyudiono
 *
 */

public class RandomArrayInt {
	
	private int length; // array length to be produced
	private final int range = 14000; // range of random number
	
	/**
	 * Set length field
	 * @param length, length of array to be produced
	 */
	public void setLength(int length) {
		
		this.length = length;
		
	}
	
	/**
	 * Generate array by iteration
	 * @return, array of int
	 */
	public int[] generate() {
		
		// initiate array with the length as defined in paramater
		int arr[] = new int[this.length];
		
		// do iteration
		for(int i = 0; i < this.length; i++) {
			
			// produce random number
			arr[i] = (int)(Math.random()*this.range + 1);
			
		}
		
		return arr;
	}

}
