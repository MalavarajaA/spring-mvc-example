package com.spring.mvc.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.hibernate.model.Person;
import com.spring.mvc.hibernate.service.PersonService;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

	PersonService personService;

	@Autowired
	@Qualifier(value = "personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public ModelAndView addPerson(Model model, HttpServletRequest request) {

		if (request.getParameter("name") != null && request.getParameter("country") != null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("person");
			Person person = new Person();
			String name = request.getParameter("name");
			person.setName(name);
			person.setCountry(request.getParameter("country"));
			boolean status = personService.isPersonExist(name);
			if (status) {
				personService.addPerson(person);
				model.addAttribute("message", "Person details has been added Successfully.!!!");
			}else{
				model.addAttribute("message", "The Person Name \""+name+"\" is already exist...!!!");
			}
			return mv;
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/listPersons", method = RequestMethod.GET)
	public ModelAndView listPersons(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listPersons");
		List<Person> persons = personService.listPersons();
		model.addAttribute("persons", persons);
		return mv;
	}

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView deletePerson(Model model, HttpServletRequest request) {
		if (request.getParameter("personId") != null) {
			int personId = Integer.parseInt(request.getParameter("personId"));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("deletePerson");
			personService.deletePerson(personId);
			return mv;
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/retrievePerson", method = RequestMethod.GET)
	public ModelAndView retrievePerson(Model model, HttpServletRequest request) {
		if (request.getParameter("name") != null) {
			String name = request.getParameter("name");
			List<Person> persons = personService.retrievePerson(name);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("retrievePerson");
			model.addAttribute("persons", persons);
		}
		return new ModelAndView();
	}
}
