package eduwmich.CS5310.CodeAssignment.AWahyudiono;

/**
 * Insertion sort 
 * Algorithm implementation of Insertion Sort, depicted from the book
 * "Fundamental of Computer Algorithm", by E. Horowitz, S. Sahni. 
 * Chapter 3, page 151
 * @author Agung Wahyudiono
 *
 */

public class InsertionSort extends Sorting {
	
	private int arr[];
	private int length;
	
	public void setArray(int a[]) {
		this.arr = a;
		this.length = a.length-1;
	}

	public void Sort(int arr[], int n) {
		for(int j = 1; j <= n ; j++) {
			int item = arr[j];
			int i = j-1;
			while(i >= 0 && item < arr[i]){
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = item;
		}
	}

	@Override
	public int[] doSort() {
		
		this.Sort(this.arr, length);
		
		return arr;
	}

}
