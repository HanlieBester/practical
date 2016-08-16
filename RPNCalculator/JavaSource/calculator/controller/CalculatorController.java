package calculator.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import calculator.dao.RPNDao;
import calculator.domain.Result;
import calculator.util.RPN;

@Controller
@RequestMapping(value = "/calculate")
public class CalculatorController {
	
	@Autowired
	RPNDao rpnDao;

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	/** 
	 * 
	 * This method takes in a RPN expression and return the calculated result. 
	 * 
	 * @param expression
	 * 				is the equation entered, space delimited.  
	 * 				Use URL encoding to parse special characters in the request.
	 * 				Valid operators (+ - * / x ^)
	 * 
	 * @return 
	 * 		1.) the input expression
	 * 		2.) an allocated unique id 
	 * 		3.) the calculated answer of the RPN expression or an error message
	 * 		
	 */	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Result calculate(@RequestParam(value="expression", required=true) String expression) {									
		
		Result result = new Result();
		result.setRequest(expression);
		
		try {
			result.setAnswer(RPN.calculate(expression));			
		} catch (Exception e) {			
			logger.debug("RPN Calculator threw exception: input: " + expression + "exception: " + e.getMessage());
			result.setAnswer(e.getMessage());
		}	
		
		/* Persist request and response */
		try {
			rpnDao.store(result);
		} catch (Exception e){
			/* Ignore error */
			logger.debug("RPN persistance failed: input: " + expression + "exception: " + e.getMessage());
		}
		
		return result;
	}	
}

