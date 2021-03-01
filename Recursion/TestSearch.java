package Recursion;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class TestSearch {
	int[] arr={2,4,5,8,6};
	int num=5;
	int low=0;
	int high=4;
	int output_index=2;
	@Test
	public void evaluate_linear_search(){
		assertEquals(output_index,Search.linearSearch(arr, num, low, high));
	}
	@Test
	public void evaluate_binary_search(){
		assertEquals(output_index, Search.binarySearch(arr, num, low, high));
	}
}
