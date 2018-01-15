package appsuite;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringBootRestApplication extends org.springframework.boot.web.support.SpringBootServletInitializer {

	@RequestMapping("/hello")
	public String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(SpringBootRestApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { // TODO Auto-generated
	 * method stub return super.configure(builder); }
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<SpringBootRestApplication> applicationClass = SpringBootRestApplication.class;
}