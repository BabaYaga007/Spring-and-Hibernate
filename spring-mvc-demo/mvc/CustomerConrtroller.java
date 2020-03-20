package awesome.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerConrtroller {

	// add an initbinder ... to trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor =new StringTrimmerEditor(true);
		// this functions trims the leading and trailing spaces in the string.
		//Since the value is true, if the string contains all spaces , it will trim the string to null
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		//it registers the custom editor we made on all the strings / dataBinder
				
	}
	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		//@Valid performs the validation rules on Customer object
		//@BindingResult places the results of validation in theBindingResult 
		
		System.out.println("Last name: |"+ theCustomer.getLastName()+"|");
		
		System.out.println("Binding Result :"+theBindingResult);
		
		System.out.println("\n\n\n");
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
		
	}
}