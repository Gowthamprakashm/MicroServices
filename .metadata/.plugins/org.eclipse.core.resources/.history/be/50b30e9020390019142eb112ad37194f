package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	@Value("${server.port}")
	String port;
	
	@GetMapping("/status")
	public String instance(){
		return "instace is up on port - "+port;
	}
	
}
