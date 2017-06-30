import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/welcome")
	public String sayHello(Model model){
		
		model.addAttribute("welcome", "Spring MVC Hello World.");
		
		return "Hello";
	}
	
}
