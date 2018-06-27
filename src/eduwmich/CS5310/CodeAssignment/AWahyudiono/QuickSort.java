package eduwmich.CS5310.CodeAssignment.AWahyudiono;

/**
 * Quick Sort 
 * @author Agung Wahyudiono
 *
 */

public class QuickSort extends Sorting {
	
	private int arr[];
	private int low;
	private int high;
	
	/**
	 * @param a, int array as input
	 */
	public void setArray(int a[]) {
		this.arr = a;
		this.low = 0;
		this.high = a.length-1;
	}
	
	/**
	 * Sorting 
	 * @param arr, array input
	 * @param low, lowest index
	 * @param high, highest index
	 */
	private static void Sort(int arr[], int l, int h) {
		if(l < h) {
			int j = Partition(arr, l, h);
			Sort(arr,l,j-1);
			Sort(arr,j+1,h);
		}
	}
	
	/**
	 * Partition
	 * @param arr, input array
	 * @param m
	 * @param p
	 * @return
	 */
	private static int Partition(int arr[], int m, int p) {
		
		int pv = arr[p];
		int i = m-1;
		for(int j=m; j<p; j++) {
			if(arr[j] <= pv) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[p];
		arr[p] = temp;
		return i+1;
	}
	
	@Override
	public int[] doSort() {
		
		this.Sort(arr, low, high);
		
		return arr;
	}
	
	

}
