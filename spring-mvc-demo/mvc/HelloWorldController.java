package awesome.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a method to show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}
	
	//need a method to show greeting page
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	//add a controller method to read form data and add data to the model
	@RequestMapping("/processFormVTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTMl form
		String theName = request.getParameter("studentName");
		
		//change it to uppercase
		theName = theName.toUpperCase();
		
		//add the message
		theName = "Yo! " + theName;
		
		//add it to the model
		model.addAttribute("message", theName);
		
		
		return "helloWorld";
	}
	
	
	//add another type of  controller method to read form data and add data to the model
		@RequestMapping("/processFormVThree")
		public String processFormVThree(@RequestParam("studentName") String theName, Model model) {
			
			//read the request parameter from the HTMl form
			//String theName = request.getParameter("studentName");
			
			//change it to uppercase
			theName = theName.toUpperCase();
			
			//add the message
			theName = "Bello " + theName;
			
			//add it to the model
			model.addAttribute("message", theName);
			
			
			return "helloWorld";
		}
		
	
}
