package assignment1;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
public class ExpressionTestCases {
	static ExpressionEvaluate expressionEvaluator;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expressionEvaluator = new ExpressionEvaluate();
	}
	@Test
	public void infixExpressionEvaluatorMethodTest() throws Exception {
		String infixExpression1 = "( ( ( 3 < 4 ) + ( 4 * 3 ) ) / ( 11 - 9 ) )";
		String infixExpression2 = "( 5 * 6 ) / 5";
		String infixExpression3 = "3 && 4";
		String infixExpression4 = "7 || 9";
		String infixExpression5 = "( 5 - 2 ) * 3";
		String infixExpression6 = "( 3 < 6 ) * 6";
		String infixExpression7 = "( 7 > 9 )";
		String infixExpression8 = "7 >= 9";
		String infixExpression9 = "7 <= 9";
		String infixExpression10 = "! 6";
		String infixExpression11 = "5 == 5";
		assertEquals(6,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression1));
		assertEquals(6,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression2));
		assertEquals(1,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression3));
		assertEquals(1,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression4));
		assertEquals(9,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression5));
		assertEquals(6,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression6));
		assertEquals(0,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression7));
		assertEquals(0,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression8));
		assertEquals(1,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression9));
		assertEquals(
				0,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression10));
		assertEquals(
				1,
				expressionEvaluator
				.functionForEvaluateInfixExpression(infixExpression11));
	}
}