package calculator.util;

import java.text.DecimalFormat;
import java.util.*;
import calculator.exception.DivideByZeroException;
import calculator.exception.EmptyException;
import calculator.exception.InvalidException;
import calculator.exception.TooManyNumbersException;

/** 
 * 
 * This class takes in a RPN expression and return the calculated result. 
 * 
 * @param expression
 * 				is the equation entered, space delimited.  
 * 				Use URL encoding to parse special characters in the request.
 * 				Valid operators (+ - * / x ^)
 * 
 * @return the calculated answer of the RPN expression 
 * 
 * @exception EmptyException when no value supplied
 * @exception InvalidException when the input string is invalid, i.e. unable to parseDouble
 * @exception DevideByZeroException when attempt was made to divide by zero
 * @exception EmptyStackException when not enough values in the stack
 * @exception TooManyNumbersException too many numbers for operators supplied
 * 		
 */	

public class RPN {	
	
	public static String calculate(String expression) throws Exception{					
		
		Stack<Double> stack = new Stack<Double>();		
		
		if (expression == null || expression.trim() == ""){
			throw new EmptyException("No expression supplied");
		}

        for (String token : expression.trim().split("\\s+")) {
        	
        	System.out.print(token + "\t");
        	
        	try {
        		if (token.equals("+")){
                    System.out.print("Operate\t\t");
                    stack.push(stack.pop() + stack.pop());
                    
                } else if (token.equals("-")){
                    System.out.print("Operate\t\t");
                    stack.push(-stack.pop() + stack.pop());
                    
                } else if (token.equals("*")){
                	 System.out.print("Operate\t\t");
                     stack.push(stack.pop() * stack.pop());
                     
                } else if (token.equals("x")){
               	 	System.out.print("Operate\t\t");
                    stack.push(stack.pop() * stack.pop());
                     
                } else if (token.equals("/")){
            	   System.out.print("Operate\t\t");
                   double divisor = stack.pop();
                   if (divisor == 0){
                	   throw new DivideByZeroException("RPN equation attempted to devide by zero");
                   }
                   stack.push(stack.pop() / divisor);
                       
                } else if (token.equals("^")){
                	 System.out.print("Operate\t\t");
                     double exponent = stack.pop();
                     stack.push(Math.pow(stack.pop(), exponent));
                     
                } else { // numeric 
                	try {
                		System.out.print("Push\t\t");
                		stack.push(Double.parseDouble(token));
                	} catch (NumberFormatException nfe){
                		throw new InvalidException("The string is not a valid RPN Equation.");
                	}
                }       
        	} catch (EmptyStackException empty){
        		throw empty;
        	}

            System.out.println(stack);                        
        }
       
        if (stack.size() > 1) {
        	throw new TooManyNumbersException("There too many numbers and not enough mathematical operators with which to evaluate them.");
          }
        
        DecimalFormat df = new DecimalFormat("0.00");
        String answer = df.format(stack.pop()); 
        
        System.out.println("Final Answer: " + answer);
		
        return answer;                        	
	}
}
