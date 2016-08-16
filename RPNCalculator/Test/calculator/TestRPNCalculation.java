package calculator;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import calculator.exception.DivideByZeroException;
import calculator.exception.EmptyException;
import calculator.exception.InvalidException;
import calculator.exception.TooManyNumbersException;
import calculator.util.RPN;

public class TestRPNCalculation {

	 @Rule
	 public final ExpectedException exception = ExpectedException.none();
	
	 @Test
	 public void testValid() throws Exception {
		 assertNotNull(RPN.calculate("23.3 5 16.2 + 8 * -"));
		 assertEquals("-146.30", RPN.calculate("23.3 5 16.2 + 8 * -"));
	 }
	 
	 @Test
	 public void testNull() throws Exception {
		 exception.expect(EmptyException.class);
		 RPN.calculate(null);
	 }
	 
	 @Test
	 public void testEmptyString() throws Exception {
		 exception.expect(EmptyException.class);
		 RPN.calculate("");
	 }
	 
	 @Test
	 public void testInvalidString() throws Exception {
		 exception.expect(InvalidException.class);
		 RPN.calculate("Hello world!");
	 }
	 
	 @Test
	 public void testDevideByZero() throws Exception {
		 exception.expect(DivideByZeroException.class);
		 RPN.calculate("52.2 12 + 17 - 9.7 10 0 / + -");
	 }
	 
	 @Test
	 public void testTooManyNumbers() throws Exception {
		 exception.expect(TooManyNumbersException.class);
		 RPN.calculate("12.2 17 / 33.333 - 12");
	 }		
}
