package com.zz.initializrstart.controller;

import com.zz.initializrstart.domain.User;
import com.zz.initializrstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private List<User> getUserlist() {
		return userRepository.listUser();
	}

	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", getUserlist());
		model.addAttribute("title", "user management");
		return new ModelAndView( "users/list","userModel", model);
	}


	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model){
		User user = userRepository.getUserById(id);
		model.addAttribute("user",user);
		model.addAttribute("title","view user");
		return new ModelAndView("users/view","userModel",model);
	}

	//获取创建表单页面
	@GetMapping("/form")
	public ModelAndView createForm(Model model){
		model.addAttribute("user",new User());
		model.addAttribute("title","create a new user");
		return new ModelAndView("users/form","userModel",model);
	}

	@PostMapping
	public ModelAndView saveOrUpdateUser(User user,Model model){
		user = userRepository.saveOrUpdateUser(user);
		model.addAttribute("user",user);
		model.addAttribute("title","modify user");
		return new ModelAndView("users/form","userModel",model);
	}

	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id,Model model){
		User user = userRepository.getUserById(id);
		model.addAttribute("user",user);
		model.addAttribute("title","modify user");
		return new ModelAndView("users/form","userModel",model);
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id,Model model){
		userRepository.deleteUser(id);
		return new ModelAndView("redirect:/users");
	}

}
