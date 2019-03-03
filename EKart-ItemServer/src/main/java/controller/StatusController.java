package controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StatusController {

	@Value("${server.port}")
	String port;
	
	@GetMapping("/status")
	@HystrixCommand(fallbackMethod="fallBack")
	public String instance(){
		
		Random random = new Random();
		Boolean value = random.nextBoolean();
		System.out.println(value);
		if(value) {
			throw new NullPointerException();
		}
		else if(random.nextBoolean()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return "instace is up on port - "+port;
	}
	
	public String fallBack() {
		return "Fall Back via Hystrix";
	}
	
}
