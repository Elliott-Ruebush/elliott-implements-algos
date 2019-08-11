package sorts;

import java.util.Arrays;

public class Sorts {

	/*
	 * Helper method that swaps two elements in an array
	 * 
	 * @param arr - array to perform the swap operation on
	 * 
	 * @param iOne - index of first element in the swap
	 * 
	 * @param iTwo - index of second element in the swap
	 */
	public void swap(int[] arr, int iOne, int iTwo) {
		int temp = arr[iOne];
		arr[iOne] = arr[iTwo];
		arr[iTwo] = temp;
	}

	public void mergeSort(int[] arr, int L, int R) {
		// Check to make sure R-L > 1, which tells us if there is more than one element
		// in
		// the array
		if (L < R) {
			// Take the average of L and R
			int m = (L + R) / 2;
			System.out.println("Mid: " + m);
			//
			mergeSort(arr, L, m);
			mergeSort(arr, m + 1, R);
//			System.out.println("Something: " + Arrays.toString(Arrays.copyOfRange(arr, L, R + 1)));
			merge(arr, L, m, R);
		}
//		return arr;
	}

	public void merge(int[] arr, int L, int m, int R) {
		System.out.println("L: " + L);
		System.out.println("R: " + R);
		// FINAL PRODUCT GOES HERE, MERGE METHOD THAT ACTUALLY WORKS
		// REFERENCE: https://www.geeksforgeeks.org/merge-sort/

		// Left arr has a length of (m+1 - L)
		// Right arr has a length of (R+1-m+1) = (R-m)
//		int[] rArr = new int[m+1-L];
//		int[] lArr = new int[R-m];
		// Alternative Array.copyOfRange() - populate directly from the input arr
		// Need to add one to the "to" number in copyOfRange() because it's exclusive
		// and we want to include m and R for left and right respectively
		int[] lArr = Arrays.copyOfRange(arr, L, m + 1);
		// Add one to m because we only want to include m in the lArr
		int[] rArr = Arrays.copyOfRange(arr, m + 1, R + 1);
		// Now we have two arrays that capture the two current subarrays we are
		// examining
		System.out.println("Left Subarr: " + Arrays.toString(lArr));
		System.out.println("Right Subarr: " + Arrays.toString(rArr));
		// We now commence the actual merging and insert the values directly into the
		// input arr starting at L
		// k will track where we want to insert the next value into the input arr
		int k = L;
		// Set references to the current index being examined in each array (Start at
		// the 0th index of each subarray)
		int h1 = 0, h2 = 0;
		while (h1 < lArr.length && h2 < rArr.length) {
			if (lArr[h1] <= rArr[h2]) {
				// if lArr has the lower or equal value, we insert the current element into
				// input arr and increment the index tracker for lArr
				arr[k] = lArr[h1];
				h1++;
			} else {
				// otherwise we insert the current element of rArr into input arr and increment
				// the index tracker for rArr
				arr[k] = rArr[h2];
				h2++;
			}
			// Increment k each time so that we do not overwrite an element we already
			// updated
			k++;
		}

		// Now we need to handle left over elements since we exit the first while loop
		// after we finish looking through one array
		while (h1 < lArr.length) {
			arr[k] = lArr[h1];
			h1++;
			k++;
		}
		while (h2 < rArr.length) {
			arr[k] = rArr[h2];
			h2++;
			k++;
		}
		System.out.println("After Merge: " + Arrays.toString(Arrays.copyOfRange(arr, L, R + 1)));

		// Merge two sorted parts of an array
//		int[] tempArr = new int[arr.length];
//		int[] t1 = new int[(m+1)-L];
//		int[] t2 = new int[]
//		System.out.println(Arrays.toString(t1));
//		System.out.println(Arrays.toString(t2));
//		int h1 = L;
//		int h2 = m;
//		System.out.println("h1: " + h1);
//		System.out.println("h2: " + h2);
//		int k = L;
//		while(h1 < m && h2 <= R) {
//			if(arr[h1] <= arr[h2]) {
//				tempArr[k] = arr[h1];
//				k++;
//			}else {
//				tempArr[k] = arr[h2];
//				k++;
//			}
//		}
//		for (int k = L; k <= R; k++) {
//			System.out.println("tempArr: " + Arrays.toString(tempArr));
//			if (h1 < m && ((arr[h1] <= arr[h2]) || (h2 >= R))) {
//				tempArr[k] = arr[h1];
//				h1++;
//			} else{
//				tempArr[k] = arr[h2];
//				h2++;
//			}
//		}
//		System.out.println("tempArr: " + Arrays.toString(tempArr));
//		for (int i = L; i < R; i++) {
//			arr[i] = tempArr[i];
//		}

// 		int[] t1 = Arrays.copyOfRange(arr, L, m);
//		int[] t2 = Arrays.copyOfRange(arr, m, R);
//		System.out.println(Arrays.toString(t1));
//		System.out.println(Arrays.toString(t2));
//		System.out.println(L);
//		System.out.println(m);
//		System.out.println(R);
//		// i represents head of the first subarray
//		int i = L;
//		// j represents head of the second subarray
//		int j = m;
//		for (int k = L; k < R; k++) {
//			// See if elements are already in the right order
//			System.out.println("Hello");
//			if ((i < m) && (t1[i] < t2[j])) {
//				arr[k] = t1[i];
//				i++;
//			} else if((j < R)){
//				arr[k] =t2[j];
//				j++;
//			}
//		}
	}

//	public static void main(String args[]) {
//		int[] data1 = new int[] { 1, 3, 2, 7, 4, 8, 5 };
//		int[] expected1 = new int[] { 1, 2, 3, 4, 5, 7, 8 };
//		mergeSort(data1, 0, data1.length - 1);
//		System.out.println(Arrays.toString(data1));
//		System.out.println(Arrays.equals(data1, expected1));
//		int[] mergeTest = new int[] { 4, 8, 5 };
//		merge(mergeTest, 0, 1, 2);
//		System.out.println(Arrays.toString(mergeTest));
//	}

	public void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			int P = partition(arr, L, R);

			quickSort(arr, L, P - 1);
			quickSort(arr, P + 1, R);

		}
	}

	public int partition(int[] arr, int L, int R) {
		// Lomuto partition scheme, pick last element of partition as pivot
		int pivot = arr[R];
		int pivInd = R;
		// SPI - Smaller Part Index - keeps track of where we put values less than or
		// equal to the pivot when we find them
		int spi = L;
		while (spi < pivInd) {
			if (arr[pivInd - 1] > pivot) {
				swap(arr, pivInd, pivInd - 1);
				pivInd--;
			} else if (arr[pivInd - 1] <= pivot) {
				swap(arr, pivInd - 1, spi);
				spi++;
			}
		}
		return pivInd;

	}

}
