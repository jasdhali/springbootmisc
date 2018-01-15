package com.gkatzioura.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.spring.logging.aop.LoggingConfig;

//@SpringBootApplication(scanBasePackages={"com.spring.logging.aop","com.gkatzioura.spring.aop"})
@SpringBootApplication
@Import({LoggingConfig.class})
public class SpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}
}
