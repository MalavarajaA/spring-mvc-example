package com.spring.mvc.hibernate.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import com.spring.mvc.hibernate.model.Person;
import com.spring.mvc.hibernate.service.PersonService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired
	@Qualifier(value = "personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.GET)
	public ModelAndView addPerson(Model model, HttpServletRequest request) {

		if (request.getParameter("name") != null && request.getParameter("country") != null) {
			Person newPerson = new Person();
			newPerson.setName(request.getParameter("name"));
			newPerson.setCountry(request.getParameter("country"));
			personService.addPerson(newPerson);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Person");
			model.addAttribute("message", "Person has been added successfully...!!!");
			return mv;
		}

		return new ModelAndView();
	}

	@RequestMapping(value = "/listPersons", method = RequestMethod.GET)
	public ModelAndView listPersons(Model model, HttpServletRequest request) {
		List<Person> persons = personService.listPersons();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listPersons");
		model.addAttribute("persons", persons);
		return mv;
	}

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView deletePerson(Model model, HttpServletRequest request) {
		if (request.getParameter("personId") != null) {
			personService.deletePerson(Integer.parseInt(request.getParameter("personId")));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("deletePerson");
			return mv;
		}
		return new ModelAndView();
	}
	
	@RequestMapping(value="/retrievePerson",method = RequestMethod.GET)
	public ModelAndView retrievePerson(Model model,HttpServletRequest request){
		
		if(request.getParameter("name")!=null){
			List<Person> persons = personService.retrievePerson(request.getParameter("name"));
			model.addAttribute("persons", persons);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("retrievePerson");
		}
		
		return new ModelAndView();
		
	}
}