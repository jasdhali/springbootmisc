package com.spring;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//@EnableDiscoveryClient
public class BookRentBootApplication 
//extends org.springframework.boot.web.support.SpringBootServletInitializer
{

		@RequestMapping("/bookrent/hello")
		public String home() {
			return "Hello World!";
		}

		public static void main(String[] args) throws Exception {
			SpringApplication app = new SpringApplication(BookRentBootApplication .class);
			app.setBannerMode(Banner.Mode.OFF);
			app.run(args);
		}


/*	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }*/

	    private static Class<BookRentBootApplication > applicationClass = BookRentBootApplication .class;
	}