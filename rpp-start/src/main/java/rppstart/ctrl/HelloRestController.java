package rppstart.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloRestController {
	
	
	
	
	@RequestMapping("/")
	public String helloWorld() {
		
		return "Hello World!";
		
		
		
	}
	
	@RequestMapping("zbir")
	public String zbir() {
		long x = Math.round(Math.random()*10);
		long y = Math.round(Math.random()*10);
		return x+" + "+y+" = "+(x+y);
		
	}

}
