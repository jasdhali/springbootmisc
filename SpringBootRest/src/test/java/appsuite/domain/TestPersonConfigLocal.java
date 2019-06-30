package appsuite.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import appsuite.domain.Person;

@Configuration
@Profile("dev")
public class TestPersonConfigLocal {
	
	@Value("${person.firstName}")
	private String firstName; 
	
	@Value("${person.lastName}")
	private String lastName; 
	
	@Bean
	public Person getPerson() {
		Person p = new Person();
		p.setFirstName(firstName+"-Test");
		p.setLastName(lastName+"-Test");
		return p;
	}
}
