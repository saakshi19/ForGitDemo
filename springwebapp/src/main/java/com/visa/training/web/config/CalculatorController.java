package com.visa.training.web.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {


	@RequestMapping("/calculator")
	public ModelAndView helloWorld(@RequestParam("op")String op, @RequestParam("n1")String s1, @RequestParam("n2")String s2 ) {
		
		double n1= Double.parseDouble(s1);
		double n2 = Double.parseDouble(s2);
		double result =0.0;
		
		switch(op) {
		case "+": result = n1+n2;
		break;
		case "-" : result = n1-n2;
		break;
		case "*": result = n1*n2;
		break;
		case "/" : result = n1/n2;
			
		}
		String viewName = "calculatorView";
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("result",result);
		
		return new ModelAndView(viewName, attributes);
	}
}
