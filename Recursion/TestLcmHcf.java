package Recursion;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLcmHcf {
	int num1=10;
	int num2=15;
	int lcm=30;
	int hcf=5;
	@Test
	public void evaluate_LCM(){
		assertEquals(lcm, LcmHcf.find_lcm(num1, num2));
	}
	@Test
	public void evaluate_HCF(){
		assertEquals(hcf, LcmHcf.find_hcf(num1, num2));
	}
}
