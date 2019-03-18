package shopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@Value("${welcome.message}")
	private String message;

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

}
