package sorts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class mergeSortTest {

	@Test
	void testSortNormal() {
		Sorts test = new Sorts();
		int[] data1 = new int[] { 1, 3, 2, 7, 4, 8, 5 };
		int[] expected1 = new int[] { 1, 2, 3, 4, 5, 7, 8 };
		test.mergeSort(data1, 0, data1.length - 1);
		assertArrayEquals(expected1, data1);
	}

}
