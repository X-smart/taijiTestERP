package cn.com.taiji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {
	@GetMapping("/admin")
	public String admin() {
		return "admin";
		
	}
	@GetMapping("/html11")
	public String html1() {
		return "html11";
		
	}
	@GetMapping("/html12")
	public String html2() {
		return "html12";
		
	}
	@GetMapping("/html13")
	public String html3() {
		return "html13";
		
	}
	
	@PostMapping("/findAll")
	public String findAll(String page ,String rows) {
		System.out.println("\n============================");
		System.out.println(page);
		System.out.println(rows);
		System.out.println("============================\\n");
		return "html13";
		
	}

}
