package appsuite.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	@RequestMapping("/summary")
	public Map<String, Long> getSummary() {
		final HashMap<String, Long> summary = new HashMap<String, Long>();
		summary.put("first", 1L);
		summary.put("second", 2L);
		return summary;

	}

}