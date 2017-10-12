package com.gkatzioura.spring.aop;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkatzioura.spring.aop.service.SampleService;
import com.spring.logging.aop.LogExecutionTime;

@RestController
public class AopController {
	
	@Autowired 
	private SampleService sampleService;
	
	@LogExecutionTime
	@RequestMapping(value = "/aop-greeting")
	  public String greet() {
	
	    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
	    Random rand = new Random();

	    int randomNum = rand.nextInt(greetings.size());
	    if(  sampleService !=null){
	    	sampleService.createSample("jaspal");
	    }
	    try {
			serve();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return greetings.get(randomNum)+"--";
	  }
	
	@LogExecutionTime
	public void serve() throws InterruptedException {
	    Thread.sleep(2000);
	}
}
