package appsuite.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	@RequestMapping( value = "/summary" ,method = RequestMethod.GET)
	public Map<String, Long> getSummary() {
		final HashMap<String, Long> summary = new HashMap<String, Long>();
		summary.put("first", 1L);
		summary.put("second", 2L);
		return summary;
	}

}