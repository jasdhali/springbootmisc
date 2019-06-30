package com.spring;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages="com.spring")
//@EnableDiscoveryClient
public class BookRentalSpringBootApplication extends org.springframework.boot.web.support.SpringBootServletInitializer{

		@RequestMapping("/bookrent/hello")
		public String home() {
			return "Hello World!";
		}

		public static void main(String[] args) throws Exception {
			SpringApplication app = new SpringApplication(BookRentalSpringBootApplication .class);
			app.setBannerMode(Banner.Mode.OFF);
			app.run(args);
		}


	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
	    
	  @Autowired(required = false) 
	  DataSource dataSource;
	  
	  @PostConstruct
	  public void postConstructMthd(){
		  System.out.println(".....postConstructMthd.....");
	  }

	   private static Class<BookRentalSpringBootApplication > applicationClass = BookRentalSpringBootApplication .class;
	}