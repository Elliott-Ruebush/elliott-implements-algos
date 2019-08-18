package algos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void testSortNormal() {
		// Arrange
		Sorts test = new Sorts();
		int[] data1 = new int[] { 1, 3, 2, 7, 4, 8, 5 };
		int[] sorted = Arrays.copyOf(data1, data1.length);
		Arrays.sort(sorted);
		// Act
		test.quickSort(data1, 0, data1.length - 1);
		System.out.println(Arrays.toString(data1));
		// Assert
		assertArrayEquals(sorted, data1);
	}

	@Test
	void testSortOneDif() {
		// Arrange
		Sorts test = new Sorts();
		int[] data1 = new int[] { 1, 1, 1, 1, 2, 1, 1 };
		int[] sorted = Arrays.copyOf(data1, data1.length);
		Arrays.sort(sorted);
		// Act
		test.quickSort(data1, 0, data1.length - 1);
		System.out.println(Arrays.toString(data1));
		// Assert
		assertArrayEquals(sorted, data1);
	}

	@Test
	void testZerosArray() {
		// Arrange
		Sorts test = new Sorts();
		int[] data1 = new int[70];
		int[] sorted = Arrays.copyOf(data1, data1.length);
		Arrays.sort(sorted);
		// Act
		test.quickSort(data1, 0, data1.length - 1);
		System.out.println(Arrays.toString(data1));
		// Assert
		assertArrayEquals(sorted, data1);
	}

	@Test
	void testSortRandomPosandNeg100000IntLongArray() {
		//Arrange
		Sorts test = new Sorts();
		int[] data = new int[100000];
		Random random = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(200000) * ((Math.random() < .5) ? 1 : -1);
		}
		int[] sorted = Arrays.copyOf(data, data.length);
		Arrays.sort(sorted);
		//Act
		test.quickSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
		//Assert
		assertArrayEquals(sorted, data);
	}

}
