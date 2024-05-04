package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String handleTest() {
		return "this is project using sts";
	}

	@RequestMapping("/sum")
	@ResponseBody
	public String getResult() {
		int a = 11;
		int b = 200;
		return String.format("Sum of %d and %d is %d",a,b,a+b);
	}
}
