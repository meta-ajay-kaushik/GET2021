package JUnitTesting;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Parameterized.class)
public class TestCountClumps {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,2,3,4,4},2},{new int[]{1,1,2,1,1},2},{new int[]{1,1,1,1,1},1}
		});
	}
	int output;
	int[] input;
	public TestCountClumps(int[] input,int output) {
		this.input=input;
		this.output=output;
	}
	@Test
	public void evaluate(){
		assertEquals(output, ArrOperation.countClumps(input));
	}
}