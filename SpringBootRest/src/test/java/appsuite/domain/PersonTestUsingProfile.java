package appsuite.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import appsuite.config.TestPersonConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestPersonConfig.class)
//@Profile("test")
@ActiveProfiles("dev")
public class PersonTestUsingProfile {
	
	@Autowired
	private Person person;
	
	@Test
	public void testPerson() {
		System.out.println(person.getFirstName());
		assertNotNull(person.getFirstName());
	}	
}
