package eduwmich.CS5310.CodeAssignment.AWahyudiono;

/**
 * Merge sort 
 * Algorithm implementation of Merge Sort, depicted from the book
 * "Fundamental of Computer Algorithm", by E. Horowitz, S. Sahni. 
 * Chapter 3, page 146
 * @author Agung Wahyudiono
 *
 */

public class MergeSort extends Sorting {
	
	private int arr[];
	private int low;
	private int high;
	
	public void setArray(int a[]) {
		
		this.arr = a;
		this.low = 0;
		this.high = a.length-1;
		
	}
	
	/**
	 * Default form of array -> arr[low:high]
	 * This method would be divide array into smaller problem, which is true when |small(P)| = 1 or |arr| = 1
	 * @param arr, array integer that would be sorted
	 * @param low, lowest index of arra(y
	 * @param high, highest index of array
	 * @return 
	 */
	public void Sort(int arr[], int low, int high) {
		
		// If there is more than one element
		if(low < high) { 
			
			// Divide P into sub problem
			// Find to split the array
			int mid = (high+low)/2;
			
			// Solve sub problems
			Sort(arr,low,mid);
			Sort(arr,mid+1,high);
			
			// Combine the solution
			this.Merge(arr, low, mid, high);
			
		}
	}
	
	/**
	 * Default form of array -> arr[low:high]
	 * This method would be sorted
	 * @param arr, array integer that would be sorted
	 * @param low, lowest index of array
	 * @param mid, midle index of array 
	 * @param high, highest index of array
	 */
	private void Merge(int arr[], int low, int mid, int high) {
		
		int h = low;
		int i = low;
		int j = mid+1;
		int temp[] = new int[arr.length]; // Temporary / Auxiliary array
		
		while(h <= mid && j <= high) {
			if(arr[h] <= arr[j]) {
				temp[i] = arr[h];
				h++;
			} else {
				temp[i] = arr[j];
				j++;
			}
			i++;
		}
		
		if(h > mid) {
			
			for(int k = j;k <= high;k++) {
				temp[i]=arr[k];
				i++;
			}
			
		} else {
			
			for(int k = h;k <= mid; k++) {
				temp[i]=arr[k];
				i++;
			}
			
		}
		
		for(int k = low; k <= high; k++) {
			arr[k] = temp[k];
		}
		
	}

	@Override
	public int[] doSort() {
		// TODO Auto-generated method stub
		this.Sort(this.arr, this.low, this.high);
		
		return arr;
	}

}
