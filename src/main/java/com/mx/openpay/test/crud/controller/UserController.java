package com.mx.openpay.test.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mx.openpay.test.crud.dao.UserRepository;
import com.mx.openpay.test.crud.model.User;

/**
 * class that contains the crud methods for users
 * @author abc
 *
 */
@Controller
public class UserController {

	//user repository
	@Autowired
	private UserRepository userRepository;

	/**
	 * method to initialize attributes and obtain all user records
	 * 
	 * @param model for adding attributes
	 * @return view name
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		return "home";
	}

	/**
	 * method to insert or update users
	 * 
	 * @param user object with user attributes to insert or update information
	 * @return view name
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute(value = "user") User user) {
		userRepository.save(user);

		return "save";
	}
	
	/**
	 * method for delete a user record 
	 * 
	 * @param id user identifier 
	 * @return view name
	 */
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer id) {
		User user = new User();
		user.setUserId(id);
		
		userRepository.delete(user);

		return "delete";
	}
	
	/**
	 * method to establish user information in the model and then update it
	 * 
	 * @param user object with user attributes to update information
	 * @param model for adding attributes
	 * @return view name
	 */
	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(value="user") User user, Model model) {
        model.addAttribute("user", user);
        return "home"; 
    }
}
