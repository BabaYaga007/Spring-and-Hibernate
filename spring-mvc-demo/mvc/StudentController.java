package awesome.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		//we added the Student class so that we could bind data of the form(in variable student) to theStudent object and
		//in this way we can easily use the data, no calling functions to get each type of data		
		
		
		//log the input data
		System.out.println("theStudent: "+ theStudent.getFirstName() +" "+ theStudent.getLastName() +" from " + theStudent.getCountry());
		
		return "student-confirmation";
	}
	
}
