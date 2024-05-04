package com.sts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerWithRestControllerAnnotation {

	@RequestMapping("/test_2")
	public String getString() {
		return "I am using RestController";
	}
}
