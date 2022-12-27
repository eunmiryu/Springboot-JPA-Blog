package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

	@GetMapping("temp/home")
	public String tempHome() {
		System.out.println("temp home");
		//파일을 리턴할때 기본경로 : src/main/resources/static
		return "/home.html";
	}
	
	@GetMapping("temp/jsp")
	public String tempJsp() {
		
		//prifix: /WEB-INF/views
		//suffix: .jsp
		//풀네임: /WEB-INF/views/test.jsp
		return "/test";
	}
}
