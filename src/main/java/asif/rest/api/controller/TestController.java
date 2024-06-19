package asif.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@GetMapping("/test")
	public Test  getLoginMapping() {
		return new Test(1,"asif",24);
	}
	
	@GetMapping("/test-path/{id}")
	public Test  getPathVariableMapping(@PathVariable int id ) {
		if(id==2)
			return new Test(2,"asif_new",26);
		
		return null;
	}
}
