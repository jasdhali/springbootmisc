package appsuite.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomSimpleController {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}

}
