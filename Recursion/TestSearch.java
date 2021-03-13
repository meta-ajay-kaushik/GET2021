package Recursion;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class TestSearch {
	int[] arr={2,4,5,8,6};
	int num=5;
	int num1=6;
	int low=0;
	int high=4;
	int outputIndex=2;
	@Test
	public void evaluateLinearSearch(){
		assertEquals(outputIndex,Search.linearSearch(arr, num, low, high));
	}
	@Test
	public void evaluateBinarySearch(){
		assertEquals(outputIndex, Search.binarySearch(arr, num, low, high));
	}
	@Test
	public void evaluateLinearSearch1(){
		assertEquals(outputIndex,Search.linearSearch(arr, num1, low, high));
	}
	@Test
	public void evaluateBinarySearch1(){
		assertEquals(outputIndex, Search.binarySearch(arr, num1, low, high));
	}
}
