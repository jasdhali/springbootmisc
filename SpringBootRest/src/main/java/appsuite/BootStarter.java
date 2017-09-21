package appsuite;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages="appsuite")
//@EnableDiscoveryClient
public class BootStarter extends org.springframework.boot.web.support.SpringBootServletInitializer{

	@RequestMapping("/hello")
	public String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(BootStarter.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}*/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<BootStarter> applicationClass = BootStarter.class;
}