package appsuite.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import appsuite.domain.Person;

@Configuration
@Profile("default")
public class ArbitraryConfig {
	
	@Value("${person.first-name:jas}")
	private String firstName; 
	
	@Value("${person.last-name:singh}")
	private String lastName; 
	
	@Bean
	public Person getPerson() {
		Person p = new Person();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return p;
	}
}
