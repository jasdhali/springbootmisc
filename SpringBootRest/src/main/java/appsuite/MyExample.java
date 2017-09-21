package appsuite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
@EnableAutoConfiguration
public class MyExample {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main__(String[] args) throws Exception {
		SpringApplication.run(MyExample.class, args);
	}

}